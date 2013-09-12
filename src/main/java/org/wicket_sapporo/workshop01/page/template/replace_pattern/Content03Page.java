package org.wicket_sapporo.workshop01.page.template.replace_pattern;

import org.wicket_sapporo.workshop01.page.template.replace_pattern.panel.Content04Panel;
import org.wicket_sapporo.workshop01.page.template.replace_pattern.panel.MenuPanel;


public class Content03Page extends BasePage {

	public Content03Page() {
		replace(new MenuPanel("menuPanel"));
		replace(new Content04Panel("contentPanel"));
	}

}
