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
package org.wicket_sapporo.workshop01.page.bookmarkable;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wicket_sapporo.workshop01.page.WS01TemplatePage;

public class IdReceiptPage extends WS01TemplatePage {
	private static final long serialVersionUID = 7014206773512011373L;

	/**
	 * Construct.
	 */
	public IdReceiptPage() {
		this(null);
	}

	/**
	 * Construct.
	 *
	 * @param params
	 *          クエリパラメータ.
	 */
	public IdReceiptPage(PageParameters params) {
		IModel<String> param1Model = Model.of("パラメータが送信されていません");
		IModel<String> param2Model = Model.of("パラメータが送信されていません");
		if (params != null) {
			// URLクエリパラメータを取得する。toStringメソッドの引数はパラメータの値が無いときの初期値.
			// BookmaekablePageLinkでアクセスされた場合のURLやパラメータ文字列形式の設定は WebApplication クラスのサブクラスで行います.
			param1Model.setObject(params.get("param1").toString("パラメータがありません"));
			param2Model.setObject(params.get("param2").toString("パラメータがありません"));
		}
		add(new Label("param1", param1Model));
		add(new Label("param2", param2Model));
	}

}
