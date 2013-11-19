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
package org.wicket_sapporo.workshop01.page.ajax.event;

import java.util.Date;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.datetime.PatternDateConverter;
import org.apache.wicket.datetime.markup.html.basic.DateLabel;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.wicket_sapporo.workshop01.page.WS01TemplatePage;

/**
 * EventSamplePage をWicketのイベントシステムを使わずに書いたもの.<br>
 * 更新されるコンポーネントの更新タイミングはスイッチとなるコンポーネントが指定しなくてはいけない。 final句も余計に必要。
 *
 * @author Hiroto Yamakawa
 */
public class NoEventSamplePage extends WS01TemplatePage {
	private static final long serialVersionUID = 3136864952762442212L;

	/**
	 * Construct.
	 */
	public NoEventSamplePage() {

		Form<Void> form = new Form<Void>("form");
		add(form);

		IModel<String> textAreaModel = Model.of("");

		final Label countLabel = new Label("count", textAreaModel) {
			private static final long serialVersionUID = -6522874730737908773L;

			@Override
			protected void onInitialize() {
				super.onInitialize();
				setOutputMarkupId(true);
			}

			@Override
			public void onComponentTagBody(MarkupStream markupStream, ComponentTag openTag) {
				// タグの内容を、textAreaModelの内容ではなく、textAreaModelの内容の長さにする
				replaceComponentTagBody(markupStream, openTag, Integer.toString(getDefaultModelObjectAsString().length()));
			}

		};
		add(countLabel);

		IModel<Date> dateModel = new AbstractReadOnlyModel<Date>() {
			private static final long serialVersionUID = 6131028671074353551L;

			@Override
			public Date getObject() {
				return new Date();
			}
		};

		final Label dateLabel = new DateLabel("date", dateModel, new PatternDateConverter("yyyy/MM/dd HH:mm:ss", true)) {
			private static final long serialVersionUID = 3105270954232202288L;

			@Override
			protected void onInitialize() {
				super.onInitialize();
				setOutputMarkupId(true);
			}

		};
		add(dateLabel);

		form.add(new TextArea<String>("textarea", textAreaModel) {
			private static final long serialVersionUID = -4029463555425282985L;

			@Override
			protected void onInitialize() {
				super.onInitialize();

				// ブラウザの onChange イベントが発生したときの処理
				add(new OnChangeAjaxBehavior() {
					private static final long serialVersionUID = 7052329505898708783L;

					@Override
					protected void onUpdate(AjaxRequestTarget target) {
						// countLabel 変数のコンポーネントを更新
						target.add(countLabel);
					}
				});

				// ブラウザの onBlur イベントが発生したときの処理
				add(new AjaxFormComponentUpdatingBehavior("onBlur") {
					private static final long serialVersionUID = -2982215895565833469L;

					@Override
					protected void onUpdate(AjaxRequestTarget target) {
						// dataLabel 変数のコンポーネントを更新
						target.add(dateLabel);
					}
				});
			}

		});

	}

}
