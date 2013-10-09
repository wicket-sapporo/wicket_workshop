package org.wicket_sapporo.workshop01.page.CleanUrl;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wicket_sapporo.workshop01.page.WS01TemplatePage;

public class idReceiptPage extends WS01TemplatePage {
	private static final long serialVersionUID = 7014206773512011373L;

	/**
	 * Construct.
	 */
	public idReceiptPage() {
		this(null);
	}

	/**
	 * Construct.
	 * 
	 * @param pageParameters
	 *          パラメータ.
	 */
	public idReceiptPage(PageParameters pageParameters) {
		IModel<String> paramaterModel = Model.of("ありません");
		if (pageParameters != null) {
			paramaterModel.setObject(pageParameters.get("foo").toString());
		}
		this.add(new Label("paramater", paramaterModel));
	}

}
