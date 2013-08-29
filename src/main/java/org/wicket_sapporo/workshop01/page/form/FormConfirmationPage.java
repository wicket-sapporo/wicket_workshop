package org.wicket_sapporo.workshop01.page.form;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

public class FormConfirmationPage extends WebPage {
	private static final long serialVersionUID = -5338952454895149872L;

	public FormConfirmationPage(IModel<FormPageBean> formPageModel) {
		super(formPageModel);

		this.add(new Label("name"));
		this.add(new Label("age"));
		this.add(new Label("introduction"));

	}

}
