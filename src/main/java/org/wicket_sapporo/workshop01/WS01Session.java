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
package org.wicket_sapporo.workshop01;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;
import org.apache.wicket.util.lang.Args;

/**
 * システム独自のWebSession.
 *
 * @author Hiroto Yamakawa
 */
public class WS01Session extends WebSession {
	private static final long serialVersionUID = 8188342108532514097L;

	// 認証状況
	private boolean signed;
	private String userId;

	/**
	 * Construct.
	 *
	 * @param request
	 *          {@link Request}.
	 */
	public WS01Session(Request request) {
		super(request);
		signed = false;
		userId = null;
	}

	/**
	 * Session取得用のメソッド.
	 *
	 * @return {@link WS01Session}
	 */
	public static WS01Session get() {
		return (WS01Session) Session.get();
	}

	/**
	 * 認証完了処理。フィールド変数に引数の値を格納.
	 *
	 * @param userId
	 *          ユーザid
	 * @param passphrase
	 *          パスフレーズ
	 */
	public void signIn(String userId, String passphrase) {
		Args.notNull(userId, "userId");
		Args.notNull(passphrase, "passphrase");
		replaceSession();
		this.userId = userId;
		this.signed = true;
	}

	/**
	 * 認証解除
	 */
	public void signOut() {
		signed = false;
		userId = null;
		invalidate();
	}

	/**
	 * @return the signed
	 */
	public boolean isSigned() {
		return signed;
	}

	/**
	 * @return signed userId;
	 */
	public String getUserId() {
		return userId != null ? userId : "不明";
	}

}
