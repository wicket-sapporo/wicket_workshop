/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wicket_sapporo.springApp.service;

import org.slf4j.LoggerFactory;
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
		LoggerFactory.getLogger(this.getClass()).info("#certify(String, String) is called.");
		return passphrase.equals("spring1234");
	}

}
