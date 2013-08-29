package org.wicket_sapporo.workshop01.page.template.childtag_pattern;

import org.apache.wicket.bootstrap.Bootstrap;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

public class HeaderAndFooterPage extends WebPage {
	private static final long serialVersionUID = 4581732758124803759L;

	public HeaderAndFooterPage() {
		add(new Label("headerLabel", Model.of("ヘッダ部分です")));
		add(new Label("fotterLabel", Model.of("フッタ部分です")));
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);

		//wicket-bootstrap.jar を含んだプロジェクトでは、以下の様に書くと、Bootsrapを使うためのhtmlヘッダが書き込まれます。
		//Wicket v6.10.0用のwicket-bootstrap v0.12では、Bootstrapv2.3.2 が利用できます。
		Bootstrap.renderHeadPlain(response);
		Bootstrap.renderHeadResponsive(response);
	}

}
