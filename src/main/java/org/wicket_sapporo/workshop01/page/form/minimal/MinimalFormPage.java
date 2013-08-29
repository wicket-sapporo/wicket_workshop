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
