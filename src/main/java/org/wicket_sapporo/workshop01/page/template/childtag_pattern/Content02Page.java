package org.wicket_sapporo.workshop01.page.template.childtag_pattern;

import java.util.Date;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

public class Content02Page extends MenuPage {
	private static final long serialVersionUID = 328995353184313618L;

	public Content02Page() {
		add(new Label("dateLabel", Model.of(new Date())));
	}

}
