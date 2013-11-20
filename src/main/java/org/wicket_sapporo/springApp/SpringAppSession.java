package org.wicket_sapporo.springApp;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;
import org.apache.wicket.util.lang.Args;

/**
 * SpringApp用のWebSessionクラス.
 *
 * @author CIST yamakawa
 */
public class SpringAppSession extends WebSession {
	private static final long serialVersionUID = -7905878838938476571L;

	private boolean signed;
	private String userId;

	/**
	 * Construct.
	 *
	 * @param request
	 *          {@link Request}.
	 */
	public SpringAppSession(Request request) {
		super(request);
	}

	/**
	 * Session取得用のメソッド.
	 *
	 * @return {@link SpringAppSession}
	 */
	public static SpringAppSession get() {
		return (SpringAppSession) Session.get();
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
