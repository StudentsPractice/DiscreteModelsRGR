package edu.lpnu.discretemodels.rgr.model;

import java.io.Serializable;

public class Edge implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id = "e1";
	private String source = "n1";
	private String target = "n2";
	private String label = "";
	
	public Edge() {
	}
	
	
	
	public Edge(String id, String source, String target, String label) {
		super();
		this.id = id;
		this.source = source;
		this.target = target;
		this.label = label;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getJsonString() {
		return String.format("{\"id\": \"%s\","
				+ "\"source\": \"%s\","
				+ "\"target\": \"%s\","
				+ "\"label\": \"%s\"}" , id, source, target, label);
	}
}
