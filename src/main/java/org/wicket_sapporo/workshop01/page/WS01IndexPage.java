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
package org.wicket_sapporo.workshop01.page;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.ResourceModel;
import org.wicket_sapporo.workshop01.page.basics.SimplePage;
import org.wicket_sapporo.workshop01.page.form.FormPage;


/**
 * WorkShop01Applicationのホームページ.
 *
 * @author Hiroto Yamakawa
 */
public class WS01IndexPage extends WS01TemplatePage {
	private static final long serialVersionUID = 708514269973162129L;

	public WS01IndexPage() {

		add(new Label("helloMessage") {
			private static final long serialVersionUID = -6880598407276577387L;

			@Override
			protected void onInitialize() {
				super.onInitialize();
				setDefaultModel(new ResourceModel(getId()));
			}
		});

		add(new ResouceBookmarkablePageLink<>("toSimplePage", SimplePage.class));
		add(new ResouceBookmarkablePageLink<>("toFormPage", FormPage.class));
	}


	/**
	 * id を元に 要素の値を ResourceModel からの取得結果に置き換える BookmarkablePageLink.
	 *
	 * @param <T>
	 *          type of page
	 *
	 * @author Hiroto Yamakawa
	 */
	public class ResouceBookmarkablePageLink<T> extends BookmarkablePageLink<T> {
		private static final long serialVersionUID = 1L;

		public <C extends Page> ResouceBookmarkablePageLink(String id, Class<C> pageClass){
			super(id, pageClass);
		}

		@Override
		protected void onInitialize() {
			super.onInitialize();
			setBody(new ResourceModel(getId()));
		}
	}

}
