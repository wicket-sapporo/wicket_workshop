package org.wicket_sapporo.workshop01.page.template.replace_pattern;

import org.apache.wicket.Component;
import org.apache.wicket.bootstrap.Bootstrap;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

public class BasePage extends WebPage {

	Component menu;
	Component content;

	public BasePage() {
		add(new Label("headerLabel", Model.of("ヘッダ部分です")));

		add(homePageLink("homePageLink"));

		add(new Label("fotterLabel", Model.of("フッタ部分です")));

		add(new WebMarkupContainer("menuPanel"));

		add(new WebMarkupContainer("contentPanel"));
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		// wicket-bootstrap.jar を導入したプロジェクトで、以下の様に書くと、Bootsrapを使うためのhtmlヘッダが書き込まれます。
		// Wicket v6.10.0用のwicket-bootstrap v0.12では、Bootstrapv2.3.2 が利用できます。
		Bootstrap.renderHeadPlain(response);
		Bootstrap.renderHeadResponsive(response);
	}

}
