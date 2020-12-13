package com.api.marvel.model;

public class Thumbnail {

	private String path;
     
	private String extension;
	
	public String getPath() {
		return path + "." + extension;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getExtension() {
		return extension ;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	
	
	
	
}
