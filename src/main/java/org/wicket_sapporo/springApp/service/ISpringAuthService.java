package org.wicket_sapporo.springApp.service;

/**
 * 認証サービスのインターフェース（の体で）
 *
 * @author Hiroto Yamakawa
 */
public interface ISpringAuthService {

	public boolean certify(String userId, String passphrase);

}
