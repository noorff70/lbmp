package com.weblearning.domain.utility.geometry;

import java.util.List;

public class GeometryObject {
	
	List<LineObject> lines;
	List<CircleObject> circles;
	List<LabelObject> labels;
	
	public List<LineObject> getLines() {
		return lines;
	}
	public void setLines(List<LineObject> lines) {
		this.lines = lines;
	}
	public List<CircleObject> getCircles() {
		return circles;
	}
	public void setCircles(List<CircleObject> circles) {
		this.circles = circles;
	}
	public List<LabelObject> getLabels() {
		return labels;
	}
	public void setLabels(List<LabelObject> labels) {
		this.labels = labels;
	}

}
