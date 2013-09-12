/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wicket_sapporo.workshop01.page.basics;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.wicket_sapporo.workshop01.page.WS01IndexPage;

/**
 * Wicketの基本的な使い方の解説ページ
 *
 * @author Hiroto Yamakawa
 */
public class SimplePage extends WebPage {
	private static final long serialVersionUID = -1907292494724474104L;

	/**
	 * デフォルトコンストラクタ.
	 */
	public SimplePage() {
		// 1. 表示したいデータ（オブジェクト）を用意する.
		String message1 = "こんにちは！";

		// 2. 表示したいオブジェクトをModelオブジェクトでラップします
		IModel<String> model1 = new Model<>(message1);

		// 3. Modelを、対応するHTMLのwicket:id用のコンポーネントにセットします
		Label label1 = new Label("label1", model1);

		// 4. コンポーネントをページにaddします
		add(label1);


		// 上記の2〜4をワンライナーっぽく。
		add(new Label("label2", new Model<>("本日は wicket-sapporo へようこそ！")));


		// 例えば、コンポーネントを切り替える事で、どの様にページに表示されるかを変更できます。
		String message3 = "皆さん、是非Wicketを使ってみてください。\n開発がスピードアップしますよ（当社比）。";

		IModel<String> model3 = new Model<>(message3);

		Label label3a = new Label("label3a", model3);

		add(label3a);

		MultiLineLabel label3b = new MultiLineLabel("label3b", model3);

		add(label3b);


		// コンポーネントを独自に拡張することもできます。
		String message4 = "この文字は緑色になっていますか？";

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


		// ほかのページへのリンクも、Javaプログラムで制御できます。
		// コンポーネントの設定や拡張は、このように無名クラスを使って行うか、コンポーネントのサブクラスを作成します。
		Link<Void> link = new Link<Void>("link") {
			private static final long serialVersionUID = 7204379487998423007L;

			@Override
			public void onClick() {
				// setResponsePage(ページクラス) もしくは setResponsePage(ページクラスのオブジェクト)で、
				// 新しいWebPageのオブジェクトを作成し、遷移先を設定します
				setResponsePage(WS01IndexPage.class);
			}
		};

		add(link);

	}

}
