package org.wicket_sapporo.workshop01.page.template.childtag_pattern;

import org.apache.wicket.markup.html.link.Link;

public class MenuPage extends HeaderAndFooterPage {
	private static final long serialVersionUID = -1345487850686995199L;

	public MenuPage() {

		add(new Link<Void>("toContent01Page") {
			private static final long serialVersionUID = 3057630357207968701L;

			@Override
			public void onClick() {
				setResponsePage(Content01Page.class);
			}

		});

		add(new Link<Void>("toContent02Page") {
			private static final long serialVersionUID = 3057630357207968701L;

			@Override
			public void onClick() {
				setResponsePage(Content02Page.class);
			}

		});

	}

}
