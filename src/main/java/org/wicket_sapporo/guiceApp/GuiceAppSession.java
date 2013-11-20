package org.wicket_sapporo.guiceApp;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;
import org.apache.wicket.util.lang.Args;

/**
 * GuiceApp用のWebSessionクラス.
 *
 * @author CIST yamakawa
 */
public class GuiceAppSession extends WebSession {
	private static final long serialVersionUID = -3204779817805409361L;

	private boolean signed;
	private String userId;

	/**
	 * Construct.
	 *
	 * @param request
	 *          {@link Request}.
	 */
	public GuiceAppSession(Request request) {
		super(request);
	}

	/**
	 * Session取得用のメソッド.
	 *
	 * @return {@link GuiceAppSession}
	 */
	public static GuiceAppSession get() {
		return (GuiceAppSession) Session.get();
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
