package org.wicket_sapporo.workshop01.page.template.replace_pattern;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

public class BasePage extends WebPage {

	Component menu;
	Component content;

	public BasePage() {
		add(new Label("headerLabel", Model.of("ヘッダ部分です")));
		add(new Label("fotterLabel", Model.of("フッタ部分です")));

		add(new WebMarkupContainer("menuPanel"));
		add(new WebMarkupContainer("contentPanel"));
	}

}
