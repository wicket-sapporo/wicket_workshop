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
package org.wicket_sapporo.workshop01.page.form;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.wicket_sapporo.workshop01.page.form.bean.FormPageBean;

/**
 * 入力フォームの確認用のページ
 *
 * @author Hiroto Yamakawa
 */
public class FormConfirmationPage extends WebPage {
	private static final long serialVersionUID = -5338952454895149872L;

	public FormConfirmationPage(IModel<FormPageBean> formPageModel) {
		// setDefaultModel(IModel) は、ページのデフォルトのModelをセットするメソッド.
		// 下のコードが CompoundPropertyModel を想定しているので、強制的にCompoundPropertyModel で再度ラップしておく.
		setDefaultModel(CompoundPropertyModel.of(formPageModel));

		// CompoundPropertyModelの能力で、ページにaddされるコンポーネントの値は、
		// formPageModelにラップされたオブジェクト（=前ページから渡されたformPageBean）の値とリンクする.
		add(new Label("name"));
		add(new Label("age"));
		add(new Label("introduction"));
	}

}
