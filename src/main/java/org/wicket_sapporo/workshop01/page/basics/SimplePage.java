package org.wicket_sapporo.workshop01.page.basics;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class SimplePage extends WebPage {

	public SimplePage() {
		// 1. ページに表示したいオブジェクトを用意する.
		String message1 = "こんにちは！";

		// 2. 表示したいオブジェクトをModelオブジェクトでラップする
		IModel<String> model1 = new Model<>(message1);

		// 3. Modelをコンポーネントにセットする
		Label leabel1 = new Label("label1", model1);

		// 4. コンポーネントをページにaddする
		add(leabel1);


		// 上記の2〜4をワンライナーで。
		add(new Label("label2", new Model<>("本日は wicket-sapporo へようこそ！")));


		// 例えば、コンポーネントを切り替える事で、表示を変更することが可能です。
		String message3 = "皆さん、是非Wicketを使ってみてください。\n開発がスピードアップしますよ（当社比）。";

		IModel<String> model3 = new Model<>(message3);

		Label label3a = new Label("label3a", model3);

		add(label3a);

		MultiLineLabel label3b = new MultiLineLabel("label3b", model3);

		add(label3b);


		// コンポーネントを独自に拡張することも可能です。
		String message4 = "緑色になっていますか。";

		IModel<String> model4 = new Model<>(message4);

		Label label4 = new Label("label4", model4) {
			private static final long serialVersionUID = 4710432194688962393L;

			@Override
			protected void onInitialize() {
				super.onInitialize();
				add(AttributeModifier.append("style", "color:#090"));
			}
		};

		add(label4);

	}

}
