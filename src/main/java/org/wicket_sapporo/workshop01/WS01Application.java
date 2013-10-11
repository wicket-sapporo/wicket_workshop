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
package org.wicket_sapporo.workshop01;

import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.core.request.mapper.MountedMapper;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.request.mapper.parameter.UrlPathPageParametersEncoder;
import org.apache.wicket.resource.DynamicJQueryResourceReference;
import org.wicket_sapporo.workshop01.page.WS01IndexPage;
import org.wicket_sapporo.workshop01.page.bookmarkable.ArbitraryIdReceiptPage;
import org.wicket_sapporo.workshop01.page.bookmarkable.MountedIdReceiptPage;
import org.wicket_sapporo.workshop01.page.bookmarkable.NamedIdReceiptPage;
import org.wicket_sapporo.workshop01.page.session.SignedPage;
import org.wicket_sapporo.workshop01.page.session.SimpleSignInPage;

/**
 * Wicketアプリケーションの全体の設定などを記述するクラス.
 * 
 * @author Hiroto Yamakawa
 */
public class WS01Application extends WebApplication {

	@Override
	protected void init() {
		super.init();
		// サーバ・クライアント間のリクエスト・レスポンスの文字エンコード
		getRequestCycleSettings().setResponseRequestEncoding("UTF-8");

		// Wicketに取り込まれるHTMLファイルのエンコード
		getMarkupSettings().setDefaultMarkupEncoding("UTF-8");

		// IE6/7/8 は JQuery1, それ以外はJQuery2を利用
		getJavaScriptLibrarySettings().setJQueryReference(new DynamicJQueryResourceReference());

		// AjaxProgressPageの様に、UploadProgressを利用するときの設定項目.
		getApplicationSettings().setUploadProgressUpdatesEnabled(true);

		mountPage();
	}

	/**
	 * ページのURLマッピング情報を設定する
	 */
	private void mountPage() {
		// クラスへのアクセスをどのURLファイルパスにマッピングするか。第3引数は、クエリパラメータの整形方法の設定.
		mount(new MountedMapper("/query_receipt", MountedIdReceiptPage.class));
		mount(new MountedMapper("/arbitrary_receipt", ArbitraryIdReceiptPage.class, new UrlPathPageParametersEncoder()));
		mount(new MountedMapper("/named_receipt/${param1}/${param2}", NamedIdReceiptPage.class));


		mount(new MountedMapper("/SignIn", SimpleSignInPage.class));
		mount(new MountedMapper("/Signed", SignedPage.class));
	}

	@Override
	public Class<? extends Page> getHomePage() {
		// 最初に表示するページを設定.
		return WS01IndexPage.class;
	}

	@Override
	public Session newSession(Request request, Response response) {
		// このアプリケーション用に独自に拡張したSessionを作成.
		return new WS01Session(request);
	}
}
