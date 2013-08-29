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

import org.apache.wicket.markup.html.link.Link;

/**
 * サイドメニューををテンプレートとして表示するためのページ.
 *
 * @author Hiroto Yamakawa
 */
public class MenuPage extends HeaderAndFooterPage {
	private static final long serialVersionUID = -1345487850686995199L;

	/**
	 * Construct.
	 */
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
