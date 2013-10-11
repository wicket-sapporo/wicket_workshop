package org.wicket_sapporo.workshop01.page.ajax;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.wicket_sapporo.workshop01.page.WS01TemplatePage;

public class AjaxIndexPage extends WS01TemplatePage {

	public AjaxIndexPage() {
		add(new BookmarkablePageLink<Void>("toAjaxTimerPage", AjaxTimerPage.class));
	}

}
