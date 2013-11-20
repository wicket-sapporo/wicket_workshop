package org.wicket_sapporo.guiceApp.service;

import com.google.inject.ImplementedBy;

/**
 * 認証サービスのインターフェース（の体で）
 *
 * @author Hiroto Yamakawa
 */
@ImplementedBy(GuiceAuthService.class)
public interface IGuiceAuthService {

	public boolean certify(String userId, String passphrase);

}
