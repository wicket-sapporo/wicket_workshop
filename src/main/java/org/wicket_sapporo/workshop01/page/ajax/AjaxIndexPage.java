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
package org.wicket_sapporo.workshop01.page.ajax;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.wicket_sapporo.workshop01.page.WS01TemplatePage;
import org.wicket_sapporo.workshop01.page.ajax.event.EventSamplePage;
import org.wicket_sapporo.workshop01.page.ajax.event.NoEventSamplePage;
import org.wicket_sapporo.workshop01.page.ajax.indicating.IndicatingPage;
import org.wicket_sapporo.workshop01.page.ajax.lazy.LazyLoadPage;
import org.wicket_sapporo.workshop01.page.ajax.link.VisibleChangePage;
import org.wicket_sapporo.workshop01.page.ajax.progress.AjaxProgressPage;
import org.wicket_sapporo.workshop01.page.ajax.timer.AjaxTimerPage;
import org.wicket_sapporo.workshop01.page.ajax.tree.AjaxTreePage;
import org.wicket_sapporo.workshop01.page.ajax.updating.FormUpdatingPage;

/**
 * 各Ajaxのデモページへのリンク.
 *
 * @author Hiroto Yamakawa
 */
public class AjaxIndexPage extends WS01TemplatePage {
	private static final long serialVersionUID = -2592415551533703614L;

	/**
	 * Construct.
	 */
	public AjaxIndexPage() {
		add(new BookmarkablePageLink<Void>("toVisibleChangePage", VisibleChangePage.class));
		add(new BookmarkablePageLink<Void>("toIndicatingPage", IndicatingPage.class));
		add(new BookmarkablePageLink<Void>("toLazyLoadPage", LazyLoadPage.class));
		add(new BookmarkablePageLink<Void>("toAjaxProgressPage", AjaxProgressPage.class));
		add(new BookmarkablePageLink<Void>("toAjaxTreePage", AjaxTreePage.class));

		add(new BookmarkablePageLink<Void>("toAjaxTimerPage", AjaxTimerPage.class));
		add(new BookmarkablePageLink<Void>("toFormUpdatingPage", FormUpdatingPage.class));

		add(new BookmarkablePageLink<Void>("toEventSamplePage", EventSamplePage.class));
		add(new BookmarkablePageLink<Void>("toNoEventSamplePage", NoEventSamplePage.class));
	}

}
