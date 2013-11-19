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
package org.wicket_sapporo.workshop01.page.form;

import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import org.wicket_sapporo.workshop01.WS01Application;

/**
 * FormPage のテストクラス（FormTester のサンプル）
 *
 * @author Hiroto Yamakawa
 */
public class FormPageTest {

	private WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester(new WS01Application());
	}

	@Test
	public void ページが表示される() {
		// テストとページの表示のスタート
		tester.startPage(new FormPage());
		// 最後に表示されたページクラスのassert
		tester.assertRenderedPage(FormPage.class);
	}

	@Test
	public void FormをsubmitするとFormConfirmationPageが表示される() {
		// テストとページの表示のスタート
		tester.startPage(new FormPage());
		FormTester formTester = tester.newFormTester("form", false);
		formTester.setValue("name", "foo");
		formTester.setValue("age", "1");
		formTester.setValue("introduction", "bar");
		formTester.submit();
		tester.assertRenderedPage(FormConfirmationPage.class);
	}

}
