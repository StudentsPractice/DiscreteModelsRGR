package edu.lpnu.discretemodels.rgr.model;

import java.io.Serializable;

public class Node implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id = "n0";
	private String label = "";
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getJsonString() {
		return String.format("{\"id\": \"%s\",\"label\": \"%s\",\"size\": 3}", id, label);
	}
}
