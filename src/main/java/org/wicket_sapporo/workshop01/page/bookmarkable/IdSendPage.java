package org.wicket_sapporo.workshop01.page.bookmarkable;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wicket_sapporo.workshop01.page.WS01TemplatePage;

public class IdSendPage extends WS01TemplatePage {
	private static final long serialVersionUID = 6864986937301895261L;

	public IdSendPage() {
		this.add(new BookmarkablePageLink<Void>("bookmarkableLink", IdReceiptPage.class));

		PageParameters pageParameters = new PageParameters();
		pageParameters.add("param1", "1000");
		pageParameters.add("param2", "2000");

		this.add(new BookmarkablePageLink<Void>("withParamLink", IdReceiptPage.class, pageParameters));
		this.add(new BookmarkablePageLink<Void>("withArbitraryParamLink", ArbitraryIdReceiptPage.class, pageParameters));
		this.add(new BookmarkablePageLink<Void>("withNamedParamLink", NamedIdReceiptPage.class, pageParameters));
	}

}
