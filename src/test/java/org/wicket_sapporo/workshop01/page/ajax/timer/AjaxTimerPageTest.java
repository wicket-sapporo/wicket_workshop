package org.wicket_sapporo.workshop01.page.ajax.timer;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import org.wicket_sapporo.workshop01.WS01Application;

public class AjaxTimerPageTest {

	private WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester(new WS01Application());
	}

	@Test
	public void TimerBehaviorでコンポーネントが更新される() {
		WebPage page = tester.startPage(new AjaxTimerPage());
		tester.executeAllTimerBehaviors(page);
		tester.assertComponentOnAjaxResponse("clock");

	}
}
