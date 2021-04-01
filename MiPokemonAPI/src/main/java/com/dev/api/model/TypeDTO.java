package com.dev.api.model;

public class TypeDTO {
	
	private String name;
	private String url;
	
	public TypeDTO(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Type [name=" + name + ", url=" + url + "]";
	}
	
}
