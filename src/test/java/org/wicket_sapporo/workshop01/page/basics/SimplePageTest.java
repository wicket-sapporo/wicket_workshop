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
package org.wicket_sapporo.workshop01.page.basics;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.apache.wicket.util.tester.TagTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import org.wicket_sapporo.workshop01.WS01Application;

/**
 * SimplePage のテストクラス（TagTesterのサンプル）
 *
 * @author Hiroto yamakawa
 */
public class SimplePageTest {

	private WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester(new WS01Application());
	}

	@Test
	public void label4のstyleが変更される() {
		tester.startPage(new SimplePage());
		TagTester tagTester = tester.getTagByWicketId("label4");
		assertThat(tagTester.getAttribute("style"), is("color:#090"));
	}

}
