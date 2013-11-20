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
package org.wicket_sapporo.guiceApp.page;

import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.wicket_sapporo.guiceApp.GuiceAppSession;
import org.wicket_sapporo.guiceApp.service.IGuiceAuthService;

import com.google.inject.Inject;

/**
 * サインイン画面の体で.
 *
 * @author Hiroto Yamakawa
 */
public class GuiceSignInPage extends GuiceAppTemplatePage {
	private static final long serialVersionUID = -1368746343101480225L;

	// 認証サービスの体で。GuiceによりDIされる。
	@Inject
	private IGuiceAuthService guiceAuthService;

	private String userId;
	private String passphrase;

	/**
	 * Construct.
	 */
	public GuiceSignInPage() {
		userId = "";
		passphrase = "";

		// 自分のページのフィールド変数とコンポーネントを関連づける様に CompoundPropertyModel を用意.
		IModel<GuiceSignInPage> formModel = new CompoundPropertyModel<>(this);

		// ログイン・ログアウトなどのステートフルにしたくない部分には Stateless コンポーネントを利用.
		StatelessForm<GuiceSignInPage> form = new StatelessForm<GuiceSignInPage>("form", formModel) {
			private static final long serialVersionUID = -4915291457682594278L;

			@Override
			protected void onSubmit() {
				super.onSubmit();
				if (guiceAuthService.certify(userId, passphrase)) {
					GuiceAppSession.get().signIn(userId, passphrase);
					setResponsePage(GuiceSignedPage.class);
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
