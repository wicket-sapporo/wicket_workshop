package org.wicket_sapporo.workshop01.page.basics.minimal;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.wicket_sapporo.workshop01.page.WS01IndexPage;

/**
 * SimplePage のコードを極力簡潔に書いたページ.
 *
 * @author Hiroto Yamakawa
 */
public class MinimalSimplePage extends WebPage {
	private static final long serialVersionUID = 1556716255512948829L;

	/**
	 * Construct.
	 */
	public MinimalSimplePage() {
		add(new Label("label1", Model.of("こんにちは！")));

		add(new Label("label2", Model.of("本日は wicket-sapporo へようこそ！")));

		IModel<String> model3 = Model.of("皆さん、是非Wicketを使ってみてください。\n開発がスピードアップしますよ（当社比）。");

		add(new Label("label3a", model3));

		add(new MultiLineLabel("label3b", model3));

		add(new Label("label4", Model.of("この文字は緑色になっていますか？")) {
			private static final long serialVersionUID = 4710432194688962393L;

			@Override
			protected void onInitialize() {
				super.onInitialize();
				add(AttributeModifier.append("style", "color:#090"));
			}
		});

		add(new Link<Void>("link") {
			private static final long serialVersionUID = 7204379487998423007L;

			@Override
			public void onClick() {
				setResponsePage(WS01IndexPage.class);
			}
		});

	}

}
