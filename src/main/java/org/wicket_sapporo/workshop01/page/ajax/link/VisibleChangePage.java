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
package org.wicket_sapporo.workshop01.page.ajax.link;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.wicket_sapporo.workshop01.page.WS01TemplatePage;

/**
 * Ajaxでコンポーネントの表示・非表示を設定するコンポーネント.
 *
 * @author Hiroto Yamakawa
 */
public class VisibleChangePage extends WS01TemplatePage {
	private static final long serialVersionUID = -9089348992357469537L;

	/**
	 * Construct.
	 */
	public VisibleChangePage() {

		final WebMarkupContainer green = new WebMarkupContainer("green") {
			private static final long serialVersionUID = -3971005661769891977L;

			@Override
			protected void onInitialize() {
				super.onInitialize();
				// Ajaxの更新対象となるコンポーネントには setOutputMarkupId(true) を実行する.
				// これにより、JavaScriptがフックするための id がタグに加えられる.
				setOutputMarkupId(true);
				// 非表示（visible = false）状態から表示（visible = true）になる可能性があるタグには、
				// setOutputMarkupPlaceholderTag(true) を実行する。これにより、表示上は消えても、JavaScriptが
				// フックできるタグが残る.
				setOutputMarkupPlaceholderTag(true);
			}

			@Override
			protected void onConfigure() {
				super.onConfigure();
				// コンポーネントがAjaxなどで更新される度に実行されるメソッド.
				// ここでは、コンポーネントの表示/非表示状態を切り替えている.
				setVisible(!isVisibleInHierarchy());
			}
		};
		add(green);

		add(new AjaxLink<Void>("link") {
			private static final long serialVersionUID = 5989037074637804530L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				// AjaxLinkがクリックされた時の処理
				target.add(green);
			}

		});
	}

}
