/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wicket_sapporo.workshop01.page.template.childtag_pattern;

import org.apache.wicket.bootstrap.Bootstrap;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

/**
 * ヘッダおよびフッタをテンプレートとして表示するページ.
 *
 * @author Hiroto Yamakawa
 */
public class HeaderAndFooterPage extends WebPage {
	private static final long serialVersionUID = 4581732758124803759L;

	/**
	 * Construct.
	 */
	public HeaderAndFooterPage() {
		add(new Label("headerLabel", Model.of("ヘッダ部分です")));

		add(homePageLink("homePageLink"));

		add(new Label("fotterLabel", Model.of("フッタ部分です")));
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
