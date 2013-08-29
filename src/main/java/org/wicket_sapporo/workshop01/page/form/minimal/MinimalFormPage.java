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
package org.wicket_sapporo.workshop01.page.form.minimal;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.wicket_sapporo.workshop01.page.form.FormConfirmationPage;
import org.wicket_sapporo.workshop01.page.form.bean.FormPageBean;

/**
 * FormPage のコードを極力簡潔に書いたページ.
 *
 * @author Hiroto Yamakawa
 */
public class MinimalFormPage extends WebPage {
	private static final long serialVersionUID = -17636676484983833L;

	/**
	 * Construct.
	 */
	public MinimalFormPage() {

		Form<FormPageBean> form = new Form<FormPageBean>("form", new CompoundPropertyModel<>(new FormPageBean())) {
			private static final long serialVersionUID = 6843470916943201357L;
			@Override

			protected void onSubmit() {
				super.onSubmit();
				// 値の確認は省略.
				setResponsePage(new FormConfirmationPage(getModel()));
			}
		};

		add(form);

		form.add(new TextField<>("name"));

		form.add(new TextField<>("age"));

		form.add(new TextArea<>("introduction"));

	}

}
