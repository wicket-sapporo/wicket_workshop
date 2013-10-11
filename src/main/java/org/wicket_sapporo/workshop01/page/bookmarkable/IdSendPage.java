package org.wicket_sapporo.workshop01.page.bookmarkable;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wicket_sapporo.workshop01.page.WS01TemplatePage;

public class IdSendPage extends WS01TemplatePage {
	private static final long serialVersionUID = 6864986937301895261L;

	public IdSendPage() {

		add(new Link<Void>("link") {
			private static final long serialVersionUID = 7783361205395260070L;

			@Override
			public void onClick() {
				setResponsePage(new IdReceiptPage());
			}
		});

		add(new BookmarkablePageLink<Void>("bookmarkableLink", IdReceiptPage.class));


		add(new BookmarkablePageLink<Void>("withMountLink", MountedIdReceiptPage.class));

		PageParameters pageParameters = new PageParameters();
		pageParameters.add("param1", "1000");
		pageParameters.add("param2", "2000");

		add(new BookmarkablePageLink<Void>("withParamLink", MountedIdReceiptPage.class, pageParameters));
		add(new BookmarkablePageLink<Void>("withArbitraryParamLink", ArbitraryIdReceiptPage.class, pageParameters));
		add(new BookmarkablePageLink<Void>("withNamedParamLink", NamedIdReceiptPage.class, pageParameters));
	}

}
