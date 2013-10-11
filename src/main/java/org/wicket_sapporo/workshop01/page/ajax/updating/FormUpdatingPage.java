/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements. See the NOTICE
 * file distributed with this work for additional information regarding copyright ownership. The ASF licenses this file
 * to You under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.wicket_sapporo.workshop01.page.ajax.updating;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;
import org.wicket_sapporo.workshop01.page.WS01TemplatePage;

/**
 * フォームに変更があった際にすぐにsubmitするAjaxのサンプル.
 * 
 * @author Hiroto Yamakawa
 */
public class FormUpdatingPage extends WS01TemplatePage {
	private static final long serialVersionUID = 4879380561190751982L;

	/**
	 * Construct.
	 */
	public FormUpdatingPage() {

		// 選択肢のモデルを用意.
		IModel<List<String>> dropDownModel = new ListModel<>(Arrays.asList("札幌", "東京", "大阪", "福岡"));

		// 洗濯結果を取り扱うモデルを用意.
		IModel<String> choicedModel = new Model<String>(null);

		Form<Void> form = new Form<Void>("form");
		add(form);

		final Label choiced = new Label("choiced", choicedModel) {
			private static final long serialVersionUID = 4475505735169776541L;

			@Override
			protected void onInitialize() {
				super.onInitialize();
				// Ajaxで更新されるコンポーネントには setOuntPutMarkupId(true) を実行する
				// これにより、JavaScriptでフックされるidがタグに追加される
				setOutputMarkupId(true);
			}
		};

		form.add(choiced);

		// ドロップダウン形式のコンポーネントを用意.
		form.add(new DropDownChoice<String>("dropDown", choicedModel, dropDownModel) {
			private static final long serialVersionUID = 9123857368996631355L;

			@Override
			protected void onInitialize() {
				super.onInitialize();
				add(new AjaxFormComponentUpdatingBehavior("change") {
					private static final long serialVersionUID = -5435266116249371422L;

					@Override
					protected void onUpdate(AjaxRequestTarget target) {
						// choiced 変数のコンポーネントを更新
						target.add(choiced);
					}
				});
			}
		});

	}

}
