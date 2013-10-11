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
package org.wicket_sapporo.workshop01.page.ajax.timer;

import java.util.Date;

import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.datetime.PatternDateConverter;
import org.apache.wicket.datetime.markup.html.basic.DateLabel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.time.Duration;
import org.wicket_sapporo.workshop01.page.WS01TemplatePage;

/**
 * Ajaxを使って指定されたタイミングでコンポーネントを更新するサンプル.
 * 
 * @author Hiroto Yamakawa
 */
public class AjaxTimerPage extends WS01TemplatePage {
	private static final long serialVersionUID = -5835757903211756489L;

	/**
	 * Construct.
	 */
	public AjaxTimerPage() {
		// コンポーネントがgetObject()を行うたびに、実行結果を返すModel
		IModel<Date> clockModel = new AbstractReadOnlyModel<Date>() {
			private static final long serialVersionUID = -8248564653483203932L;

			@Override
			public Date getObject() {
				return new Date();
			}
		};

		// 日付を整形して表示できる DateLabelを利用（wicket-datetime.jarが必要）
		add(new DateLabel("clock", clockModel, new PatternDateConverter("yyyy/MM/dd HH:mm:ss", true)) {
			private static final long serialVersionUID = -1197321688780742456L;

			@Override
			protected void onInitialize() {
				// onInitialize()には、コンポーネントの初期設定を記述できる
				super.onInitialize();
				// 1秒ごとにコンポーネント部分のみを更新する TimerBehavior
				add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(1)));
			}
		});

	}
}
