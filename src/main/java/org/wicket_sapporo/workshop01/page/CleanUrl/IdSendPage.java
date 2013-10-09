package org.wicket_sapporo.workshop01.page.CleanUrl;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wicket_sapporo.workshop01.page.WS01TemplatePage;

public class IdSendPage extends WS01TemplatePage {
	private static final long serialVersionUID = 6864986937301895261L;

	public IdSendPage() {
		this.add(new BookmarkablePageLink<Void>("bookmarkableLink", idReceiptPage.class));

		PageParameters pageParameters = new PageParameters();
		pageParameters.add("foo", "1000");
		this.add(new BookmarkablePageLink<Void>("paramaterLink", idReceiptPage.class, pageParameters));
	}

}
