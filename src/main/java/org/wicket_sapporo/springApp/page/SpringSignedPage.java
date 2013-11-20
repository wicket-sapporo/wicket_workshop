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

import org.apache.wicket.RestartResponseException;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.wicket_sapporo.springApp.SpringAppSession;

/**
 * 認証後のページの体で
 *
 * @author Hiroto Yamakawa
 */
public class SpringSignedPage extends SpringAppTemplatePage {
	private static final long serialVersionUID = 3556063474180638042L;

	/**
	 * Construct.
	 */
	public SpringSignedPage() {

		this.add(new Label("userId", SpringAppSession.get().getUserId()));

		// ログイン・ログアウトなどのステートフルにしたくない部分には Stateless コンポーネントを利用する.
		this.add(new StatelessLink<Void>("signOut") {
			private static final long serialVersionUID = 8031874108141311265L;

			@Override
			public void onClick() {
				SpringAppSession.get().signOut();
				// サインアウトしたら強制的にログイン画面へ.
				throw new RestartResponseException(SpringSignInPage.class);
			}
		});
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		if (!SpringAppSession.get().isSigned()) {
			// ページの生成時にサインインしてない場合は強制的にログイン画面へ.
			throw new RestartResponseException(SpringSignInPage.class);
		}
	}

}
