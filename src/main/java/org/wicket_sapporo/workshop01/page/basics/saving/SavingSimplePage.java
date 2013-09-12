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
package org.wicket_sapporo.workshop01.page.basics.saving;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.wicket_sapporo.workshop01.page.WS01IndexPage;

/**
 * SimplePage のコードを極力簡潔に書いたページ.
 *
 * @author Hiroto Yamakawa
 */
public class SavingSimplePage extends WebPage {
	private static final long serialVersionUID = 1556716255512948829L;

	/**
	 * Construct.
	 */
	public SavingSimplePage() {
		add(new Label("label1", Model.of("こんにちは！")));

		add(new Label("label2", Model.of("本日は wicket-sapporo へようこそ！")));

		IModel<String> model3 = Model.of("皆さん、是非Wicketを使ってみてください。\n開発がスピードアップしますよ（当社比）。");

		add(new Label("label3a", model3));

		add(new MultiLineLabel("label3b", model3));

		add(new Label("label4", Model.of("この文字は緑色になっていますか？")) {
			private static final long serialVersionUID = 4710432194688962393L;

			@Override
			protected void onInitialize() {
				super.onInitialize();
				add(AttributeModifier.append("style", "color:#090"));
			}
		});

		add(new Link<Void>("link") {
			private static final long serialVersionUID = 7204379487998423007L;

			@Override
			public void onClick() {
				setResponsePage(WS01IndexPage.class);
			}
		});

	}

}
