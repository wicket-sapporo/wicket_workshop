package org.wicket_sapporo.springApp.page;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.spring.test.ApplicationContextMock;
import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;
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
				// 以下、Mockito関係のクラスををstatic importしているのでメソッドのみ呼び出し
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
}
