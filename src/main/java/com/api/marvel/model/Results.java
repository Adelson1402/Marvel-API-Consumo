package com.api.marvel.model;

import java.util.List;

public class Results {
	
	
	private List<CharactersEntity> results;
	
	private Thumbnail thumbnail;
	
	private String name;
	
	private String resourceURI;
	
	private String description;

	public List<CharactersEntity> getResults() {
		return results;
	}

	public void setResults(List<CharactersEntity> results) {
		this.results = results;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Thumbnail getThumbnail() {
		return thumbnail ;
	}

	public void setThumbnail(Thumbnail thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getResourceURI() {
		return resourceURI;
	}

	public void setResourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
