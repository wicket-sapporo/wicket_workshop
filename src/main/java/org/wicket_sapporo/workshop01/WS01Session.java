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

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

/**
 * システム独自のWebSession.
 * 
 * @author Hiroto Yamakawa
 */
public class WS01Session extends WebSession {
	private static final long serialVersionUID = 8188342108532514097L;

	// 認証状況
	private boolean signed;

	/**
	 * 
	 * 
	 * @param request
	 *          {@link Request}.
	 */
	public WS01Session(Request request) {
		super(request);
		signed = false;
	}

	public static WS01Session get() {
		return (WS01Session) Session.get();
	}

	/**
	 * 認証処理
	 * 
	 * @param userId
	 *          ユーザid
	 * @param passphrase
	 *          パスフレーズ
	 * @return 認証に成功すれば<code>true</code>, それ以外は<code>false</code>
	 */
	public boolean signIn(String userId, String passphrase) {
		// 認証処理の体で
		if (userId != null && passphrase != null) {
			if (userId.equals(passphrase)) {
				replaceSession();
				setAttribute("userId", userId);
				signed = true;
			}
		}
		return signed;
	}

	/**
	 * 認証解除
	 */
	public void signOut() {
		signed = false;
		removeAttribute("userId");
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
		Object obj = getAttribute("userId");
		return (obj != null) ? obj.toString() : "不明";
	}
}
