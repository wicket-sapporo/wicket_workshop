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
 * AjaxLazyLoadPanel のサンプルページ.
 * 
 * @author CIST yamakawa
 * 
 */
public class LazyLoadPage extends WS01TemplatePage {
	private static final long serialVersionUID = -5757272696639481321L;

	/**
	 * Construct.
	 */
	public LazyLoadPage() {

		add(new AjaxLazyLoadPanel("lazyLoad") {
			private static final long serialVersionUID = -7947025060292585468L;

			@Override
			public Component getLazyLoadComponent(String id) {

				// ぐるぐるを表示させるためにわざとSleep.
				try {
					Thread.sleep(7000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				// パネルの表示準備が整うまでぐるぐるが表示される
				return new DatePrintPanel(id);
			}
		});
	}

}
