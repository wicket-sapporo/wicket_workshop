package org.wicket_sapporo.workshop01.service;

/**
 * 認証サービスの実装クラス（の体で）
 *
 * @author Hiroto Yamakawa
 */
public class AuthService implements IAuthService {

	@Override
	public boolean certify(String userId, String passphrase) {
		// 本来であれば、DBやディレクトリサービスなどを通じた認証処理が発生する
		System.out.println(this.getClass().getName() + "#certify is called.");
		return userId.equals(passphrase);
	}

}
