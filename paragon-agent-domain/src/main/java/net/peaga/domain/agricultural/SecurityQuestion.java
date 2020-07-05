/**
 * 
 */
package net.peaga.domain.agricultural;

import net.peaga.domain.base.Repository;

public class SecurityQuestion extends Repository{
	private static final long serialVersionUID = 1L;

	private String question;

	private String language;

	private String info;

	public SecurityQuestion(){
	}

	public SecurityQuestion(String question, String language){
		this.question = question;
		this.language= language; 
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
