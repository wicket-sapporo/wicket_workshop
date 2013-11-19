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
package org.wicket_sapporo.workshop01.page.bookmarkable;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import org.wicket_sapporo.workshop01.WS01Application;

/**
 * ArbitraryIdReceiptPage のJUnitテスト
 *
 * @author Hiroto Yamakawa
 */
public class ArbitraryIdReceiptPageTest {

	private WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester(new WS01Application());
	}

	@Test
	public void パラメータなしのCleanURLでページが表示される() {
		tester.executeUrl("./arbitrary_receipt");
		tester.assertRenderedPage(ArbitraryIdReceiptPage.class);
		tester.assertLabel("param1", "パラメータが送信されていません");
		tester.assertLabel("param2", "パラメータが送信されていません");
	}

	@Test
	public void パラメータありのCleanURLでページが表示される() {
		tester.executeUrl("./arbitrary_receipt/param1/1000/param2/2000");
		tester.assertRenderedPage(ArbitraryIdReceiptPage.class);
		tester.assertLabel("param1", "1000");
		tester.assertLabel("param2", "2000");
	}

}
