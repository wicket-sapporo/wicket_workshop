/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wicket_sapporo.workshop01.page.session;

import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.wicket_sapporo.workshop01.WS01Session;
import org.wicket_sapporo.workshop01.page.WS01TemplatePage;
import org.wicket_sapporo.workshop01.service.AuthService;
import org.wicket_sapporo.workshop01.service.IAuthService;

/**
 * サインイン画面の体で.
 *
 * @author Hiroto Yamakawa
 */
public class SimpleSignInPage extends WS01TemplatePage {
	private static final long serialVersionUID = -8371810037545557093L;

	// 認証サービスの体で
	private IAuthService authService;

	private String userId;
	private String passphrase;

	/**
	 * Construct.
	 */
	public SimpleSignInPage() {
		this(new AuthService());
	}

	/**
	 * Construct.
	 * フィールド変数を参照する無名クラスなどが含まれるページを
	 * 正常にユニットテストするには、インスタンス時にフィールド変数が
	 * 初期化されている必要がある（後からMockなどで上書きできない）.
	 * このためやむなく引数付きコンストラクタを作成している.
	 * DIコンテナなどを利用すれば、よりスマートなコードにできる.
	 *
	 * @param the
	 *          {@link IAuthService}.
	 */
	public SimpleSignInPage(IAuthService service) {
		authService = service;
		userId = "";
		passphrase = "";

		// 自分のページのフィールド変数とコンポーネントを関連づける様に CompoundPropertyModel を用意.
		IModel<SimpleSignInPage> formModel = new CompoundPropertyModel<>(this);

		// ログイン・ログアウトなどのステートフルにしたくない部分には Stateless コンポーネントを利用.
		StatelessForm<SimpleSignInPage> form = new StatelessForm<SimpleSignInPage>("form", formModel) {
			private static final long serialVersionUID = -4915291457682594278L;

			@Override
			protected void onSubmit() {
				super.onSubmit();
				if (authService.certify(userId, passphrase)) {
					WS01Session.get().signIn(userId, passphrase);
					setResponsePage(SignedPage.class);
				}
				// 失敗したら FeedBackPanel がエラーメッセージを表示する様に、メッセージをセット.
				error("サインイン失敗.");
			}
		};
		add(form);

		form.add(new FeedbackPanel("feedback"));
		form.add(new RequiredTextField<String>("userId") {
			private static final long serialVersionUID = 1651429085939866494L;

			@Override
			protected void onInitialize() {
				super.onInitialize();
				// コンポーネントの名称をセット
				setLabel(Model.of("ユーザID"));
			}
		});

		form.add(new PasswordTextField("passphrase") {
			private static final long serialVersionUID = 5908552907006076177L;

			@Override
			protected void onInitialize() {
				super.onInitialize();
				// コンポーネントの名称をセット
				setLabel(Model.of("パスフレーズ"));
			}
		});
	}

}
