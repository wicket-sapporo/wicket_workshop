/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wicket_sapporo.workshop01.page.form.validation;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.RangeValidator;
import org.apache.wicket.validation.validator.StringValidator;
import org.wicket_sapporo.workshop01.page.form.FormConfirmationPage;
import org.wicket_sapporo.workshop01.page.form.bean.FormPageBean;

/**
 * SavingFormPage に入力値チェックを追加したもの。
 *
 * @author Hiroto Yamakawa
 */
public class ValidationFormPage extends WebPage {
	private static final long serialVersionUID = -17636676484983833L;

	/**
	 * Construct.
	 */
	public ValidationFormPage() {

		Form<FormPageBean> form = new Form<FormPageBean>("form", new CompoundPropertyModel<>(new FormPageBean())) {
			private static final long serialVersionUID = 6843470916943201357L;

			@Override
			protected void onSubmit() {
				super.onSubmit();
				// getModelObjectメソッドで、コンポーネントにセットされたModelの中身を取得できます
				System.out.println(getModelObject().toString());
				setResponsePage(new FormConfirmationPage(getModel()));
			}
		};

		add(form);

		// FeedbackPanelは、入力値チェックのエラーメッセージなどを表示してくれるコンポーネントです
		form.add(new FeedbackPanel("feedback"));

		form.add(new TextField<String>("name") {
			private static final long serialVersionUID = 5903648176922990518L;

			@Override
			protected void onInitialize() {
				// コンポーネントのonInitializeメソッドには、インスタンス化されるときに一度行う設定を記述する
				super.onInitialize();
				// 入力必須にする
				setRequired(true);
				// 最大30字まで入力できるようにする
				add(StringValidator.maximumLength(10));
				// エラーメッセージ用に、コンポーネントにラベル名をつけておく。
				setLabel(Model.of("名前"));
			}
		});

		form.add(new TextField<Integer>("age") {
			private static final long serialVersionUID = 8030102985942074330L;

			@Override
			protected void onInitialize() {
				super.onInitialize();
				// 入力値は0以上150以下にする
				add(RangeValidator.range(0, 150));
				// エラーメッセージ用に、コンポーネントにラベル名をつけておく。
				setLabel(Model.of("年齢"));
			}
		});

		form.add(new TextArea<>("introduction"));

	}

}
