package org.wicket_sapporo.workshop01.page.form.bean;

import java.io.Serializable;

/**
 * フォームの入力値を格納するためのBean.
 *
 * @author Hiroto Yamakawa
 */
public class FormPageBean implements Serializable {
	private static final long serialVersionUID = -248637920802468439L;

	// 名前を格納する変数
	private String name;

	// 年齢を格納する変数
	private int age;

	// 自己紹介を格納する変数
	private String introduction;

	/**
	 * デフォルトコンストラクタ.
	 */
	public FormPageBean() {
		name = "";
		age = 0;
		introduction = "";
	}

	/**
	 * フィールド変数の値を確認出来るようにOverride.
	 */
	@Override
	public String toString() {
		return name + ", " + age + ", " + introduction;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public final int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public final void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the introduction
	 */
	public final String getIntroduction() {
		return introduction;
	}

	/**
	 * @param introduction the introduction to set
	 */
	public final void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

}
