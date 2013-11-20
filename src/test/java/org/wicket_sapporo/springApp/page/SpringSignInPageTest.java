/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wicket_sapporo.springApp.page;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.spring.test.ApplicationContextMock;
import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.wicket_sapporo.springApp.SpringAppSession;
import org.wicket_sapporo.springApp.SpringApplication;
import org.wicket_sapporo.springApp.service.ISpringAuthService;

public class SpringSignInPageTest {
	private WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester(new SpringApplication() {
			@Override
			protected void initSpring() {
				// 以下、Mockito関係のクラスをstatic importしているのでメソッドのみ呼び出し
				// ISpringAuthService のモックオブジェクトが作成される
				ISpringAuthService mAuthService = mock(ISpringAuthService.class);
				// certify メソッドにどんな値が来ても、falseを返す（認証失敗の体で）
				// ただし、certify メソッドに"abcd", 1234 が来たときは、trueを返す（認証成功の体で）
				when(mAuthService.certify(anyString(), anyString())).thenReturn(false);
				when(mAuthService.certify("abcd", "1234")).thenReturn(true);

				// モックを使ったテスト用のApplicationContextを作成
				ApplicationContextMock ctxm = new ApplicationContextMock();
				// ISpringAuthService に mAuthService をbindする
				ctxm.putBean("springAuthService", mAuthService);
				getComponentInstantiationListeners().add(new SpringComponentInjector(this, ctxm));
			}
		});
	}

	@Test
	public void ページが表示される() {
		tester.startPage(SpringSignInPage.class);
		tester.assertRenderedPage(SpringSignInPage.class);
	}

	@Test
	public void 認証に成功するとSessionが変更され認証後の画面に遷移される() {
		tester.startPage(SpringSignInPage.class);
		FormTester formTester = tester.newFormTester("form");
		formTester.setValue("userId", "abcd");
		formTester.setValue("passphrase", "1234");
		formTester.submit();

		// Sessionオブジェクトを呼び出す
		SpringAppSession session = (SpringAppSession) tester.getSession();
		assertThat(session.isSigned(), is(true));
		tester.assertRenderedPage(SpringSignedPage.class);
	}

	@Test
	public void 認証に失敗するとサインイン失敗と表示される() {
		tester.startPage(SpringSignInPage.class);
		FormTester formTester = tester.newFormTester("form");
		formTester.setValue("userId", "abcd");
		formTester.setValue("passphrase", "12345");
		formTester.submit();
		tester.assertFeedback("form:feedback", "サインイン失敗.");
		tester.assertRenderedPage(SpringSignInPage.class);
	}

	@After
	public void tearDown() {
		tester.destroy();
	}
}
