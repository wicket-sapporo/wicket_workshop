package org.wicket_sapporo.workshop01.page.template.replace_pattern;

import org.wicket_sapporo.workshop01.page.template.replace_pattern.panel.Content03Panel;
import org.wicket_sapporo.workshop01.page.template.replace_pattern.panel.MenuPanel;


public class Content04Page extends BasePage {
	private static final long serialVersionUID = -1573295950747433878L;

	public Content04Page() {
		replace(new MenuPanel("menuPanel"));
		replace(new Content03Panel("contentPanel"));
	}

}
