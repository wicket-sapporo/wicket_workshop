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
package org.wicket_sapporo.workshop01.page.ajax.progress;

import org.apache.wicket.extensions.ajax.markup.html.form.upload.UploadProgressBar;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.util.lang.Bytes;
import org.wicket_sapporo.workshop01.page.WS01TemplatePage;

public class AjaxProgressPage extends WS01TemplatePage {
	private static final long serialVersionUID = 1342054110780482192L;

	// フォームでアップロードできる最大サイズ
	private static final Bytes BYTES = Bytes.megabytes(256);

	public AjaxProgressPage() {

		// コンポーネントにオブジェクトをそのまま渡した場合、自動的にModelでラップされる
		add(new Label("maxSize", BYTES.toString()));

		// ファイルアップフォーム用のコンポーネント.
		final FileUploadField file = new FileUploadField("file");

		Form<Void> form = new Form<Void>("form") {
			private static final long serialVersionUID = -4514666932043732845L;

			@Override
			protected void onInitialize() {
				super.onInitialize();
				// アップロードできる最大サイズの設定
				setMaxSize(BYTES);
			}

			@Override
			protected void onSubmit() {
				super.onSubmit();
				// アップロードされた時は、ファイル名を FeedbackPanel に表示するようにメッセージをセット
				success(file.getFileUpload().getClientFileName());
			}
		};

		add(form);
		form.add(file);
		form.add(new FeedbackPanel("feedback"));

		// ファイルアップロード用のAjaxを使ったプログレスバーコンポーネント
		form.add(new UploadProgressBar("progressBar", form));
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		// プログレスバー用のcssをページに読み込み
		response.render(CssHeaderItem.forUrl("UploadProgressBar.css"));
	}

}
