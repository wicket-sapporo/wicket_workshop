package org.wicket_sapporo.workshop01.page.ajax.link;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import org.wicket_sapporo.workshop01.WS01Application;

public class VisibleChangePageTest {

	private WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester(new WS01Application());
	}

	@Test
	public void 初期状態でページが表示される() {
		tester.startPage(new VisibleChangePage());
		tester.assertRenderedPage(VisibleChangePage.class);
		tester.assertInvisible("green");
	}

	@Test
	public void link押下でgreenが表示される() {
		tester.startPage(new VisibleChangePage());
		tester.clickLink("link");
		tester.assertComponentOnAjaxResponse("green");
		tester.assertVisible("green");
	}

}
