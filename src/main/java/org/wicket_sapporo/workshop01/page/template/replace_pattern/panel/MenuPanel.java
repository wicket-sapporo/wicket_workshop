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
package org.wicket_sapporo.workshop01.page.template.replace_pattern.panel;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.wicket_sapporo.workshop01.page.template.replace_pattern.BasePage;
import org.wicket_sapporo.workshop01.page.template.replace_pattern.Content03Page;
import org.wicket_sapporo.workshop01.page.template.replace_pattern.Content04Page;

public class MenuPanel extends Panel {
	private static final long serialVersionUID = -3774804441628004438L;

	public MenuPanel(String id) {
		super(id);

		add(new Link<Void>("toBasePage") {
			private static final long serialVersionUID = -1750685177996860329L;

			@Override
			public void onClick() {
				setResponsePage(BasePage.class);
			}

		});

		add(new Link<Void>("toContent03Page") {
			private static final long serialVersionUID = 5375534238825665828L;

			@Override
			public void onClick() {
				setResponsePage(Content03Page.class);
			}

		});

		add(new Link<Void>("toContent04Page") {
			private static final long serialVersionUID = 7756105161688137033L;

			@Override
			public void onClick() {
				setResponsePage(Content04Page.class);
			}

		});


	}

}
