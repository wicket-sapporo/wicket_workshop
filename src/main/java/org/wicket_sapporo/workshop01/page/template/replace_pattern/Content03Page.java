package org.wicket_sapporo.workshop01.page.template.replace_pattern;

import org.wicket_sapporo.workshop01.page.template.replace_pattern.panel.Content04Panel;
import org.wicket_sapporo.workshop01.page.template.replace_pattern.panel.MenuPanel;


public class Content03Page extends BasePage {
	private static final long serialVersionUID = -310044570120325218L;

	public Content03Page() {
		replace(new MenuPanel("menuPanel"));
		replace(new Content04Panel("contentPanel"));
	}

}
