package org.wicket_sapporo.workshop01.page.session;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.internal.util.reflection.Whitebox.*;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import org.wicket_sapporo.workshop01.WS01Application;
import org.wicket_sapporo.workshop01.WS01Session;

public class SignedPageTest {

	private WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester(new WS01Application());
	}

	@Test
	public void ログイン成功したらUserIdが表示される() {
		// Sessionオブジェクトを呼び出す
		WS01Session session = (WS01Session) tester.getSession();
		setInternalState(session, "signed", true);
		setInternalState(session, "userId", "abcd");
		tester.startPage(SignedPage.class);
		tester.assertLabel("userId", "abcd");
	}

	@Test
	public void ログイン失敗したらSimpleSignInPageが表示される() {
		// Sessionオブジェクトを呼び出す
		WS01Session session = (WS01Session) tester.getSession();
		setInternalState(session, "signed", false);
		tester.startPage(SignedPage.class);
		tester.assertRenderedPage(SimpleSignInPage.class);
	}

	@Test
	public void ログアウトしたらSessionが破棄されてSimpleSignInPageが表示される() {
		// Sessionオブジェクトを呼び出す
		WS01Session session = (WS01Session) tester.getSession();
		setInternalState(session, "signed", true);
		setInternalState(session, "userId", "abcd");
		tester.startPage(SignedPage.class);
		tester.clickLink("signOut");
		assertThat(session.isSessionInvalidated(), is(true));
		tester.assertRenderedPage(SimpleSignInPage.class);
	}

}
