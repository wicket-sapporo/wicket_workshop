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
package org.wicket_sapporo.springApp.page;

import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicket_sapporo.springApp.SpringAppSession;
import org.wicket_sapporo.springApp.service.ISpringAuthService;

/**
 * サインイン画面の体で.
 *
 * @author Hiroto Yamakawa
 */
public class SpringSignInPage extends SpringAppTemplatePage {
	private static final long serialVersionUID = 709340384703638488L;

	// 認証サービスの体で。SpringによりDIされる。
	@SpringBean
	private ISpringAuthService springAuthService;

	private String userId;
	private String passphrase;

	/**
	 * Construct.
	 */
	public SpringSignInPage() {
		userId = "";
		passphrase = "";

		// 自分のページのフィールド変数とコンポーネントを関連づける様に CompoundPropertyModel を用意.
		IModel<SpringSignInPage> formModel = new CompoundPropertyModel<>(this);

		// ログイン・ログアウトなどのステートフルにしたくない部分には Stateless コンポーネントを利用.
		StatelessForm<SpringSignInPage> form = new StatelessForm<SpringSignInPage>("form", formModel) {
			private static final long serialVersionUID = -4915291457682594278L;

			@Override
			protected void onSubmit() {
				super.onSubmit();
				if (springAuthService.certify(userId, passphrase)) {
					SpringAppSession.get().signIn(userId, passphrase);
					setResponsePage(SpringSignedPage.class);
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
