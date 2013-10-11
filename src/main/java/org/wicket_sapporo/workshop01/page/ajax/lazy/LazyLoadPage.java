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
package org.wicket_sapporo.workshop01.page.ajax.lazy;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.ajax.markup.html.AjaxLazyLoadPanel;
import org.wicket_sapporo.workshop01.page.WS01TemplatePage;

/**
 * 画面表示後にパネルの準備ができるまでぐるぐるを表示する AjaxLazyLoadPanel のサンプル.
 * 
 * @author Hiroto Yamakawa
 */
public class LazyLoadPage extends WS01TemplatePage {
	private static final long serialVersionUID = -5757272696639481321L;

	/**
	 * Construct.
	 */
	public LazyLoadPage() {

		// 本来表示されるパネルの表示準備が整うまで、ぐるぐるを表示するパネル
		add(new AjaxLazyLoadPanel("lazyLoad") {
			private static final long serialVersionUID = -7947025060292585468L;

			@Override
			public Component getLazyLoadComponent(String id) {
				return new DatePrintPanel(id);
			}
		});
	}

}
