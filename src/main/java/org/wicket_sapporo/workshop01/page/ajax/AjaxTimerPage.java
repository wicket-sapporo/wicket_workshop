package org.wicket_sapporo.workshop01.page.ajax;

import java.util.Date;

import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
import org.apache.wicket.datetime.PatternDateConverter;
import org.apache.wicket.datetime.markup.html.basic.DateLabel;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.time.Duration;
import org.wicket_sapporo.workshop01.page.WS01TemplatePage;

public class AjaxTimerPage extends WS01TemplatePage {

	private IModel<Integer> timerModel;

	public AjaxTimerPage() {

		IModel<Integer> timerModel = new Model<Integer>(0) {
			@Override
			public Integer getObject() {
				setObject(super.getObject() + 1);
				return super.getObject();
			}
		};

		IModel<Date> clockModel = new AbstractReadOnlyModel<Date>() {

			@Override
			public Date getObject() {
				return new Date();
			}
		};

		add(new DateLabel("clock", clockModel, new PatternDateConverter("yyyy/MM/dd HH:mm:ss", true)) {
			@Override
			protected void onInitialize() {
				super.onInitialize();
				add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(1)));
			}
		});

		add(new Label("timer", timerModel) {

			@Override
			protected void onInitialize() {
				super.onInitialize();
				add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(1)));
			}

		});

	}
}
