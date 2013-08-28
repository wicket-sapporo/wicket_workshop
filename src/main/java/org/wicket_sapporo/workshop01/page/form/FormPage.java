package org.wicket_sapporo.workshop01.page.form;

import org.apache.wicket.markup.html.form.Form;
import org.wicket_sapporo.workshop01.page.WS01TemplatePage;

public class FormPage extends WS01TemplatePage {

	public FormPage() {
		add(new Form("form"));

	}

}
