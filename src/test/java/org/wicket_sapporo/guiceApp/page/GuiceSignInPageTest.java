package org.wicket_sapporo.guiceApp.page;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.apache.wicket.guice.GuiceComponentInjector;
import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import org.wicket_sapporo.guiceApp.GuiceApplication;
import org.wicket_sapporo.guiceApp.GuiceSession;
import org.wicket_sapporo.guiceApp.service.IGuiceAuthService;

import com.google.inject.Binder;
import com.google.inject.Module;

public class GuiceSignInPageTest {
	private WicketTester tester;

	@Before
	public void setUp() {

		tester = new WicketTester(new GuiceApplication() {
			@Override
			protected void initGuice() {
				getComponentInstantiationListeners().add(new GuiceComponentInjector(this, getModule()));
			}

			protected Module getModule() {
				return new Module() {
					@Override
					public void configure(Binder binder) {
						// 以下、Mockito関係のクラスををstatic importしているのでメソッドのみ呼び出し
						// IAuthServiceのモックオブジェクトが作成される
						IGuiceAuthService mAuthService = mock(IGuiceAuthService.class);
						// certify メソッドにどんな値が来ても、falseを返す（認証失敗の体で）
						when(mAuthService.certify(anyString(), anyString())).thenReturn(false);
						// ただし、certify メソッドに"abcd", 1234 が来たときは、trueを返す（認証成功の体で）
						when(mAuthService.certify("abcd", "1234")).thenReturn(true);
						binder.bind(IGuiceAuthService.class).toInstance(mAuthService);
					}
				};
			}
		});

	}

	@Test
	public void ページが表示される() {
		tester.startPage(GuiceSignInPage.class);
		tester.assertRenderedPage(GuiceSignInPage.class);
	}

	@Test
	public void 認証に成功するとSessionが変更され認証後の画面に遷移される() {
		tester.startPage(GuiceSignInPage.class);
		FormTester formTester = tester.newFormTester("form");
		formTester.setValue("userId", "abcd");
		formTester.setValue("passphrase", "1234");
		formTester.submit();

		// Sessionオブジェクトを呼び出す
		GuiceSession session = (GuiceSession) tester.getSession();
		assertThat(session.isSigned(), is(true));
		tester.assertRenderedPage(GuiceSignedPage.class);
	}

	@Test
	public void 認証に失敗するとサインイン失敗と表示される() {
		tester.startPage(GuiceSignInPage.class);
		FormTester formTester = tester.newFormTester("form");
		formTester.setValue("userId", "abcd");
		formTester.setValue("passphrase", "12345");
		formTester.submit();
		tester.assertFeedback("form:feedback", "サインイン失敗.");
		tester.assertRenderedPage(GuiceSignInPage.class);
	}
}
