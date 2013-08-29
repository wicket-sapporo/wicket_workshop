package org.wicket_sapporo.workshop01.page.template.childtag_pattern;

import java.util.Date;

import org.apache.wicket.datetime.markup.html.basic.DateLabel;
import org.apache.wicket.model.Model;

public class Content02Page extends MenuPage {
	private static final long serialVersionUID = 328995353184313618L;

	public Content02Page() {
		add(DateLabel.forDatePattern("dateLabel", Model.of(new Date()), "HH:mm:ss"));
	}

}
