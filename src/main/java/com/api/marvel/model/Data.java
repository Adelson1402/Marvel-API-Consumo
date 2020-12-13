package com.api.marvel.model;

import java.util.List;

public class Data {
  
	private int offset;
	
	private int limit;
	
	private int count;
	
	private List<Results> results;

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public List<Results> getResults() {
		return results;
	}

	public void setResults(List<Results> results) {
		this.results = results;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int count) {
		this.limit = count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
