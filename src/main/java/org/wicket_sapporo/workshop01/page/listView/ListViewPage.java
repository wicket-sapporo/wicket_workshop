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
package org.wicket_sapporo.workshop01.page.listView;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;
import org.wicket_sapporo.workshop01.page.WS01IndexPage;
import org.wicket_sapporo.workshop01.page.listView.bean.SiteBean;

public class ListViewPage extends WebPage {
	private static final long serialVersionUID = -4114266592133705846L;

	public ListViewPage() {
		IModel<List<String>> cityNameListModel = new ListModel<>(getCityNameList());

		ListView<String> cityNameListView = new ListView<String>("cityNameListView", cityNameListModel) {
			private static final long serialVersionUID = -4796396651745769272L;

			@Override
			protected void populateItem(ListItem<String> cityNameListItem) {
				// ListViewは初心者が混乱しやすい代表的なコンポーネントですが、感覚としてはfor文に似ています。
				// populateItemは、繰り返し表示する要素をどう編集するかを決めるためのメソッドです。
				Label cityName = new Label("cityName", cityNameListItem.getModel());
				cityNameListItem.add(cityName);
			}
		};
		add(cityNameListView);

		IModel<List<SiteBean>> siteListModel = new ListModel<>(getSiteBeanList());

		ListView<SiteBean> siteBeanListView = new ListView<SiteBean>("siteListView", siteListModel) {
			private static final long serialVersionUID = 903758171034304037L;

			@Override
			protected void populateItem(final ListItem<SiteBean> siteListItem) {

				ExternalLink siteLink = new ExternalLink("siteLink", Model.of(siteListItem.getModelObject().getUrl())) {
					private static final long serialVersionUID = 228122928335326753L;

					@Override
					protected void onInitialize() {
						super.onInitialize();
						setBody(Model.of(siteListItem.getModelObject().getSiteName()));
					}
				};

				siteListItem.add(siteLink);
			}
		};
		add(siteBeanListView);

		add(new Link<Void>("link") {
			private static final long serialVersionUID = 7204379487998423007L;

			@Override
			public void onClick() {
				setResponsePage(WS01IndexPage.class);
			}
		});

	}

	/**
	 * @return 表示する市の名前のリスト.
	 */
	public List<String> getCityNameList() { 
		List<String> list = new ArrayList<>(3);
		list.add("札幌市");
		list.add("千歳市");
		list.add("江別市");
		return list;
	}

	/**
	 * @return 表示するリンク先を表す SiteBean のリスト.
	 */
	public List<SiteBean> getSiteBeanList() { 
		List<SiteBean> list = new ArrayList<>(3);
		list.add(new SiteBean("Google", "http://google.co.jp/"));
		list.add(new SiteBean("Wicket-Sapporo", "http://wicket-sapporo.org/"));
		return list;
	}

}
