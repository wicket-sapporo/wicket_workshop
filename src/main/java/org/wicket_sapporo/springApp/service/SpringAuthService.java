package org.wicket_sapporo.springApp.service;

import org.springframework.stereotype.Service;



/**
 * 認証サービスの実装クラス（の体で）
 *
 * @author Hiroto Yamakawa
 */
@Service
public class SpringAuthService implements ISpringAuthService {

	@Override
	public boolean certify(String userId, String passphrase) {
		// 本来であれば、DBやディレクトリサービスなどを通じた認証処理が発生する
		System.out.println(this.getClass().getName() + "#certify is called.");
		return passphrase.equals("spring1234");
	}

}
