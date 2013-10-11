/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements. See the NOTICE
 * file distributed with this work for additional information regarding copyright ownership. The ASF licenses this file
 * to You under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.wicket_sapporo.workshop01.page.bookmarkable;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wicket_sapporo.workshop01.page.WS01TemplatePage;

/**
 * BookmarkablePageLink と パラメータ文字列のサンプルページ.
 * 
 * @author Hiroto Yamakawa
 */
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

		// 送信するパラメータを準備.
		PageParameters pageParameters = new PageParameters();
		pageParameters.add("param1", "1000");
		pageParameters.add("param2", "2000");

		add(new BookmarkablePageLink<Void>("withParamLink", MountedIdReceiptPage.class, pageParameters));
		add(new BookmarkablePageLink<Void>("withArbitraryParamLink", ArbitraryIdReceiptPage.class, pageParameters));
		add(new BookmarkablePageLink<Void>("withNamedParamLink", NamedIdReceiptPage.class, pageParameters));
	}

}
