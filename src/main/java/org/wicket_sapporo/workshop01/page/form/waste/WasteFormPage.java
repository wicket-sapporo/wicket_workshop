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
package org.wicket_sapporo.workshop01.page.form.waste;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.wicket_sapporo.workshop01.page.form.FormConfirmationPage;
import org.wicket_sapporo.workshop01.page.form.bean.FormPageBean;

/**
 * SavingFormPage のコードを CompoundPropertyModel を使わずに Model だけを使って書いたページ.
 * こうした実装でも勿論問題はないが、SavingFormPage に比べれば、コード量は増えている。
 *
 * @author Hiroto Yamakawa
 */
public class WasteFormPage extends WebPage {
	private static final long serialVersionUID = -17636676484983833L;

	// FormPageBeanに格納せずに、入力用コンポーネントそれぞれのModelを用意する.
	private IModel<String> nameModel;
	private IModel<Integer> ageModel;
	private IModel<String> introductionModel;

	/**
	 * Construct.
	 */
	public WasteFormPage() {
		nameModel = Model.of("");
		ageModel = Model.of(0);
		introductionModel = Model.of("");

		// 各コンポーネントから直接モデルを参照するので、FormにはModelをセットしない
		Form<Void> form = new Form<Void>("form") {
			private static final long serialVersionUID = 6843470916943201357L;
			@Override

			protected void onSubmit() {
				super.onSubmit();
				FormPageBean bean = new FormPageBean();
				bean.setName(nameModel.getObject());
				bean.setAge(ageModel.getObject());
				bean.setIntroduction(introductionModel.getObject());
				System.out.println(bean.toString());
				setResponsePage(new FormConfirmationPage(Model.of(bean)));
			}
		};

		add(form);

		form.add(new TextField<>("name", nameModel));

		form.add(new TextField<>("age", ageModel));

		form.add(new TextArea<>("introduction", introductionModel));

	}

}
