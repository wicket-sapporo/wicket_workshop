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

import java.util.Locale;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import org.wicket_sapporo.workshop01.WS01Application;
import org.wicket_sapporo.workshop01.WS01Session;
import org.wicket_sapporo.workshop01.page.basics.SimplePage;
import org.wicket_sapporo.workshop01.page.form.FormPage;

/**
 * WS01IndexPageのテストクラス
 *
 * @author Hiroto Yamakawa
 */
public class WS01IndexPageTest {
	private WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester(new WS01Application());
		// Localeを日本語に設定（
		WS01Session session = (WS01Session) tester.getSession();
		session.setLocale(Locale.JAPANESE);
	}

	@Test
	public void 初期状態でホームページが表示される() {
		// テストとページの表示のスタート
		tester.startPage(new WS01IndexPage());
		// 最後に表示されたページのassert
		tester.assertRenderedPage(WS01IndexPage.class);
		tester.assertLabel("helloMessage", "こんにちは！ ここから先のページはWicketを使って表示されています！");
	}

	@Test
	public void SimplePageに移動できる() {
		// テストとページの表示のスタート
		tester.startPage(new WS01IndexPage());
		tester.clickLink("toSimplePage", false);
		tester.assertRenderedPage(SimplePage.class);
	}

	@Test
	public void FormPageに移動できる() {
		// テストとページの表示のスタート
		tester.startPage(new WS01IndexPage());
		tester.clickLink("toFormPage", false);
		tester.assertRenderedPage(FormPage.class);
	}

	@Test
	public void 英語環境で初期状態でホームページが表示される() {
		// テストとページの表示のスタート
		tester.startPage(new WS01IndexPage());
		WS01Session session = (WS01Session) tester.getSession();
		session.setLocale(Locale.US);
		tester.assertRenderedPage(WS01IndexPage.class);
		tester.assertLabel("helloMessage", "Hello! These pages have been displayed using Wicket!");
	}

}
