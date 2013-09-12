package org.wicket_sapporo.workshop01.page.template.replace_pattern.panel;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.wicket_sapporo.workshop01.page.template.replace_pattern.BasePage;
import org.wicket_sapporo.workshop01.page.template.replace_pattern.Content03Page;
import org.wicket_sapporo.workshop01.page.template.replace_pattern.Content04Page;

public class MenuPanel extends Panel {
	private static final long serialVersionUID = -3774804441628004438L;

	public MenuPanel(String id) {
		super(id);

		add(new Link<Void>("toBasePage") {
			private static final long serialVersionUID = -1750685177996860329L;

			@Override
			public void onClick() {
				setResponsePage(BasePage.class);
			}

		});

		add(new Link<Void>("toContent03Page") {
			private static final long serialVersionUID = 5375534238825665828L;

			@Override
			public void onClick() {
				setResponsePage(Content03Page.class);
			}

		});

		add(new Link<Void>("toContent04Page") {
			private static final long serialVersionUID = 7756105161688137033L;

			@Override
			public void onClick() {
				setResponsePage(Content04Page.class);
			}

		});


	}

}
