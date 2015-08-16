package com.ordrd.model;

import java.util.List;

public class WebObject<E> {

	private long totalCount;
	private List<E> modelList;

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public List<E> getModelList() {
		return modelList;
	}

	public void setModelList(List<E> modelList) {
		this.modelList = modelList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getName()).append(" \n\t{\n\t\ttotalCount: ").append(totalCount)
				.append("\n\t\tmodelList: ").append(modelList).append("\n\t}");
		return builder.toString();
	}

}
