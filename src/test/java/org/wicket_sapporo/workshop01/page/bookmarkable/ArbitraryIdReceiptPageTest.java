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
