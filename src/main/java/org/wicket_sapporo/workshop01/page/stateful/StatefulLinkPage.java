/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements. See the NOTICE
 * file distributed with this work for additional information regarding copyright ownership. The ASF licenses this file
 * to You under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.wicket_sapporo.workshop01.page.stateful;

import java.util.Random;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.wicket_sapporo.workshop01.page.WS01TemplatePage;

/**
 * Wicketのステートフルな動作を確認するページ
 *
 * @author Hiroto Yamakawa
 */
public class StatefulLinkPage extends WS01TemplatePage {
	private static final long serialVersionUID = -4026528656562498981L;

	/**
	 * Construct.
	 */
	public StatefulLinkPage() {
		this(Model.of(0));
	}

	/**
	 * Construct.
	 *
	 * @param previewModel
	 *          前のページの合計値を持ったModel
	 */
	public StatefulLinkPage(IModel<Integer> previewModel) {

		// ページIDを取得して表示
		add(new Label("pageId", Model.of(getPageId())));

		// 前ページの合計値を表示
		add(new Label("preview", previewModel));

		// このページで足す乱数を生成（0〜999）
		IModel<Integer> addToModel =
				Model.of(new Random(System.currentTimeMillis()).nextInt(999));

		// 乱数を表示
		add(new Label("addTo", addToModel));

		// このページの合計値（前ページの合計値と乱数の和）を計算
		IModel<Integer> makesModel =
				Model.of(previewModel.getObject() + addToModel.getObject());

		// このページの合計値を表示
		add(new Label("makes", makesModel));

		// 次ページとして、StatefulDemo のインスタンスを作成、引数にはこのページの合計値を渡す
		add(new Link<Integer>("link", makesModel) {
			private static final long serialVersionUID = -7597194960284804475L;

			@Override
			public void onClick() {
				// コンポーネントに渡されたモデルは、コンポーネント内部で getModel() メソッドで呼び出せる
				setResponsePage(new StatefulLinkPage(getModel()));
			}
		});

	}

}
