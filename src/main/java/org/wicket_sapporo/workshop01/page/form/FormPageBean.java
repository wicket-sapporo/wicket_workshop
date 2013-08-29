package org.wicket_sapporo.workshop01.page.form;

import java.io.Serializable;

public class FormPageBean implements Serializable {
	private static final long serialVersionUID = -248637920802468439L;

	private String name;

	private int age;

	private String introduction;

	public FormPageBean() {
		name = "";
		age = 0;
		introduction = "";
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
