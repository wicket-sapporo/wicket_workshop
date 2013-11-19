package org.wicket_sapporo.workshop01.service;

/**
 * 認証サービスのインターフェース（の体で）
 *
 * @author Hiroto Yamakawa
 */
public interface IAuthService {

	public boolean certify(String userId, String passphrase);

}
