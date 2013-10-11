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
package org.wicket_sapporo.workshop01.page.ajax.lazy;

import java.util.Date;

import org.apache.wicket.datetime.markup.html.basic.DateLabel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

/**
 * 現在日時を表示するパネル.
 * 
 * @author Hiroto Yamakawa
 */
public class DatePrintPanel extends Panel {
	private static final long serialVersionUID = -1739999218876270650L;

	/**
	 * Construct.
	 * 
	 * @param id
	 *          the Component id.
	 */
	public DatePrintPanel(String id) {
		super(id);

		add(DateLabel.forDatePattern("date", Model.of(new Date()), "yyyy/MM/dd HH:mm:ss"));

	}

}
