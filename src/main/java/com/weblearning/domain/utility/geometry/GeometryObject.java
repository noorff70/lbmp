package com.weblearning.domain.utility.geometry;

import java.util.List;

public class GeometryObject {
	
	List<LineObject> lines;
	List<CircleObject> circles;
	List<LabelObject> labels;
	List<PatchObject> patches;
	RangeXY rangeXY;
	
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
	public List<PatchObject> getPatches() {
		return patches;
	}
	public void setPatches(List<PatchObject> patches) {
		this.patches = patches;
	}
	public RangeXY getRangeXY() {
		return rangeXY;
	}
	public void setRangeXY(RangeXY rangeXY) {
		this.rangeXY = rangeXY;
	}
	
}
