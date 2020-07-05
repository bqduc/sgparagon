package net.peaga.domain.client;

import net.peaga.domain.base.Repository;

@SuppressWarnings("serial")
public class Client extends Repository {
	private String code;

	private String name;

	private String email;

	private String description;

	public Client() {
	}

	public Client(String name, String description) {
		this.name = name;
		this.setDescription(description);
	}

	public Client(String code, String name, String email, String description) {
		this.code = code;
		this.name = name;
		this.email = email;
		this.description = description;
	}

	public Client(String code, String name, String description) {
		this.code = code;
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
