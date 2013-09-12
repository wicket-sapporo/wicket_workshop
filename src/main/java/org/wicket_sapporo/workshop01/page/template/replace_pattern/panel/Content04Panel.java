package org.wicket_sapporo.workshop01.page.template.replace_pattern.panel;

import java.util.Date;

import org.apache.wicket.datetime.markup.html.basic.DateLabel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class Content04Panel extends Panel {

	public Content04Panel(String id) {
		super(id);
		add(DateLabel.forDatePattern("dateLabel", Model.of(new Date()), "HH:mm:ss"));
	}

}
