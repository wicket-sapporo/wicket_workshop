/**
 *
 */
package org.wicket_sapporo.workshop01.page;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import org.wicket_sapporo.workshop01.WS01Application;

/**
 * @author CIST yamakawa
 *
 */
public class WS01IndexPageTest {
	private WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester(new WS01Application());
	}

	@Test
	public void 初期状態でホームページが表示される() {
		tester.startPage(WS01IndexPage.class);
		tester.assertRenderedPage(WS01IndexPage.class);
	}

}
