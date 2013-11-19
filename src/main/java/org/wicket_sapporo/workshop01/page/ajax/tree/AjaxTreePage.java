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
package org.wicket_sapporo.workshop01.page.ajax.tree;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.markup.html.repeater.tree.ITreeProvider;
import org.apache.wicket.extensions.markup.html.repeater.tree.NestedTree;
import org.apache.wicket.extensions.markup.html.repeater.tree.content.Folder;
import org.apache.wicket.extensions.markup.html.repeater.tree.theme.WindowsTheme;
import org.apache.wicket.extensions.markup.html.repeater.util.TreeModelProvider;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.wicket_sapporo.workshop01.page.WS01TemplatePage;

/**
 * AJAXによるツリーを表示するサンプル.
 *
 * @author Hiroto Yamakawa
 */
public class AjaxTreePage extends WS01TemplatePage {
	private static final long serialVersionUID = -6325140112961112579L;

	private IModel<String> clickedTerminatory;

	public AjaxTreePage() {
		clickedTerminatory = Model.of("");

		final Label clickedTerminatoryLabel = new Label("clickedTerminatory", clickedTerminatory) {
			private static final long serialVersionUID = -4224953169066901644L;

			@Override
			protected void onInitialize() {
				super.onInitialize();
				setOutputMarkupId(true);
			}
		};
		add(clickedTerminatoryLabel);

		// 1. TreeModelを用意
		TreeModel treeModel = new DefaultTreeModel(getTreeNode());
		// 2. TreeModelProviderを用意
		ITreeProvider<DefaultMutableTreeNode> treeProvider = new TreeModelProvider<DefaultMutableTreeNode>(treeModel) {
			private static final long serialVersionUID = 3376187721454642989L;

			@Override
			public IModel<DefaultMutableTreeNode> model(DefaultMutableTreeNode arg0) {
				return Model.of(arg0);
			}
		};

		// 3. Treeコンポーネントに喰わせる
		add(new NestedTree<DefaultMutableTreeNode>("tree", treeProvider) {
			private static final long serialVersionUID = 5671307285170480665L;

			@Override
			protected void onInitialize() {
				super.onInitialize();
				add(new WindowsTheme());
			}

			@Override
			protected Component newContentComponent(String id, IModel<DefaultMutableTreeNode> model) {
				// 類似コンポーネントにCheckFolderもある。
				return new Folder<DefaultMutableTreeNode>(id, this, model) {
					private static final long serialVersionUID = -6100530316563823499L;

					@Override
					protected MarkupContainer newLinkComponent(String id, IModel<DefaultMutableTreeNode> model) {
						// 子があれば通常のコンポーネントが提供するフォルダリンク、子が無ければ終端用のリンク
						if (getProvider().hasChildren(model.getObject())) {
							return super.newLinkComponent(id, model);
						}
						return new AjaxLink<DefaultMutableTreeNode>(id, model) {
							private static final long serialVersionUID = -7710712071051731986L;

							@Override
							public void onClick(AjaxRequestTarget target) {
								clickedTerminatory.setObject(getDefaultModelObjectAsString());
								target.add(clickedTerminatoryLabel);
							}
						};
					}

				};
			}
		});
	}

	public DefaultMutableTreeNode getTreeNode() {
		// 本来はDBや再帰処理などでツリーを作る
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("目次");
		DefaultMutableTreeNode first = new DefaultMutableTreeNode("1章");
		first.add(new DefaultMutableTreeNode("1.1"));
		first.add(new DefaultMutableTreeNode("1.2"));
		first.add(new DefaultMutableTreeNode("1.3"));
		DefaultMutableTreeNode second = new DefaultMutableTreeNode("2章");
		second.add(new DefaultMutableTreeNode("2.1"));
		second.add(new DefaultMutableTreeNode("2.2"));
		root.add(first);
		root.add(second);
		return root;
	}
}
