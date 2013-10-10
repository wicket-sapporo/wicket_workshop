package org.wicket_sapporo.workshop01.page.bookmarkable;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wicket_sapporo.workshop01.page.WS01TemplatePage;

public class IdReceiptPage extends WS01TemplatePage {
	private static final long serialVersionUID = 7014206773512011373L;

	/**
	 * Construct.
	 */
	public IdReceiptPage() {
		this(null);
	}

	/**
	 * Construct.
	 *
	 * @param pageParameters
	 *          URLクエリパラメータ.
	 */
	public IdReceiptPage(PageParameters pageParameters) {
		IModel<String> param1Model = Model.of("パラメータが送信されていません");
		IModel<String> param2Model = Model.of("パラメータが送信されていません");
		if (pageParameters != null) {
			// URLクエリパラメータを取得する。toStringメソッドの引数はパラメータの値が無いときの初期値.
			param1Model.setObject(pageParameters.get("param1").toString("パラメータがありません"));
			param2Model.setObject(pageParameters.get("param2").toString("パラメータがありません"));
		}
		this.add(new Label("param1", param1Model));
		this.add(new Label("param2", param2Model));
	}

}
