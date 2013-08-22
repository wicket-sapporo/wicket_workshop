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
package org.wicket_sapporo.workshop01.page;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;


/**
 * WorkShop01Applicationのホームページ.
 *
 * @author Hiroto Yamakawa
 */
public class WS01HomePage extends WS01TemplatePage {
	private static final long serialVersionUID = 708514269973162129L;

	public WS01HomePage() {

		this.add(new Label("helloMessage", Model.of("こんにちは！このページはWicketで動いています!")));
	}

}
