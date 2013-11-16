package org.wicket_sapporo.workshop01.page.form;

import java.util.Locale;

import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import org.wicket_sapporo.workshop01.WS01Application;
import org.wicket_sapporo.workshop01.WS01Session;

public class FormPageTest {

	private WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester(new WS01Application());
		WS01Session session = (WS01Session) tester.getSession();
		session.setLocale(Locale.JAPANESE);
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
