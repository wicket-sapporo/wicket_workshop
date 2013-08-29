package org.wicket_sapporo.workshop01.page.form;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

public class FormPage extends WebPage {

	public FormPage() {

		FormPageBean fromPageBean = new FormPageBean();

		IModel<FormPageBean> formPageModel = new CompoundPropertyModel<>(fromPageBean);

		Form<FormPageBean> form = new Form<FormPageBean>("form", formPageModel) {
			@Override
			protected void onSubmit() {
				super.onSubmit();
				setResponsePage(new FormConfirmationPage(getModel()));
			}
		};

		this.add(form);

		TextField<String> name = new TextField<>("name");

		form.add(name);

		TextField<Integer> age = new TextField<>("age");

		form.add(age);

		TextArea<String> introduction = new TextArea<>("introduction");

		form.add(introduction);
	}

}
