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
package org.wicket_sapporo.workshop01.page.ajax.event;

import java.util.Date;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.datetime.PatternDateConverter;
import org.apache.wicket.datetime.markup.html.basic.DateLabel;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.wicket_sapporo.workshop01.page.WS01TemplatePage;
import org.wicket_sapporo.workshop01.page.ajax.event.payload.RefreshPayload;
import org.wicket_sapporo.workshop01.page.ajax.event.payload.SubmitPayload;

/**
 * Wicketのイベントシステムのサンプルページ.<br>
 * Ajaxで更新されるコンポーネント側に更新タイミングを記載できるので、従来型に比べて自由度が広がる.
 * 
 * @author Hiroto Yamakawa
 */
public class EventSamplePage extends WS01TemplatePage {
	private static final long serialVersionUID = -8381704404012784418L;

	/**
	 * Construct.
	 */
	public EventSamplePage() {

		Form<Void> form = new Form<Void>("form");
		add(form);

		IModel<String> textAreaModel = Model.of("");

		form.add(new TextArea<String>("textarea", textAreaModel) {
			private static final long serialVersionUID = -8724815930687640141L;

			@Override
			protected void onInitialize() {
				super.onInitialize();

				// ブラウザの onChange イベントが発生したときの処理
				add(new OnChangeAjaxBehavior() {
					private static final long serialVersionUID = -2824058881808964021L;

					@Override
					protected void onUpdate(AjaxRequestTarget target) {
						// Wicketのイベントシステムを使って、ページ以下のコンポーネントに RefreshPayload を送信
						send(getPage(), Broadcast.BREADTH, new RefreshPayload(target));
					}
				});

				// ブラウザの onBlur イベントが発生したときの処理
				add(new AjaxFormComponentUpdatingBehavior("onBlur") {
					private static final long serialVersionUID = -2986152039086854324L;

					@Override
					protected void onUpdate(AjaxRequestTarget target) {
						// Wicketのイベントシステムを使って、ページ以下のコンポーネントに SubmitPayload を送信
						send(getPage(), Broadcast.BREADTH, new SubmitPayload(target));
					}
				});

			}
		});

		add(new Label("count", textAreaModel) {
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

			@Override
			public void onEvent(IEvent<?> event) {
				super.onEvent(event);
				// Wicketのイベントシステムで、RefreshPayloadを受け取ったときだけ、コンポーネントを更新する.
				if (event.getPayload() instanceof RefreshPayload) {
					((RefreshPayload) event.getPayload()).getTarget().add(this);
				}
			}
		});

		IModel<Date> dateModel = new AbstractReadOnlyModel<Date>() {
			private static final long serialVersionUID = 2850479475884196200L;

			@Override
			public Date getObject() {
				return new Date();
			}
		};

		add(new DateLabel("date", dateModel, new PatternDateConverter("yyyy/MM/dd HH:mm:ss", true)) {
			private static final long serialVersionUID = -6269277593299745233L;

			@Override
			protected void onInitialize() {
				super.onInitialize();
				setOutputMarkupId(true);
			}

			@Override
			public void onEvent(IEvent<?> event) {
				super.onEvent(event);
				// Wicketのイベントシステムで、SubmitPayloadを受け取ったときだけ、コンポーネントを更新する.
				if (event.getPayload() instanceof SubmitPayload) {
					((SubmitPayload) event.getPayload()).getTarget().add(this);
				}
			}
		});

	}

}
