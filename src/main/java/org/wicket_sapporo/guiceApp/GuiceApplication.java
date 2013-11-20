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
package org.wicket_sapporo.guiceApp;

import org.apache.wicket.Session;
import org.apache.wicket.core.request.mapper.MountedMapper;
import org.apache.wicket.guice.GuiceComponentInjector;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.resource.DynamicJQueryResourceReference;
import org.wicket_sapporo.guiceApp.page.GuiceSignInPage;
import org.wicket_sapporo.guiceApp.page.GuiceSignedPage;

/**
 * Application object for your web application. If you want to run this application without
 * deploying, run the Start class.
 */
public class GuiceApplication extends WebApplication {
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage() {
		return GuiceSignInPage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();
		// サーバ・クライアント間のリクエスト・レスポンスの文字エンコード
		getRequestCycleSettings().setResponseRequestEncoding("UTF-8");
		// Wicketに取り込まれるHTMLファイルのエンコード
		getMarkupSettings().setDefaultMarkupEncoding("UTF-8");
		// IE6/7/8 は JQuery1, それ以外はJQuery2を利用
		getJavaScriptLibrarySettings().setJQueryReference(new DynamicJQueryResourceReference());
		// MountedMapper
		mount(new MountedMapper("/guice_signin", GuiceSignInPage.class));
		mount(new MountedMapper("/guice_signed", GuiceSignedPage.class));
		// GoogleGuiceのInjectorの初期化
		initGuice();
	}

	/**
	 * GoogleGuice用のInjectorを用意する.
	 */
	protected void initGuice() {
		// Wicketから呼び出されたクラスのインジェクションを実行する
		getComponentInstantiationListeners().add(new GuiceComponentInjector(this));
	}

	@Override
	public Session newSession(Request request, Response response) {
		// 独自に拡張したSessionの利用
		return new GuiceAppSession(request);
	}
}
