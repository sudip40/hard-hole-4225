package com.CMS;

public class CoursPlan {
	private int planId;
	private int batchId;
	private int daynumber;
	private String topic;
	private String status;

//		status:completed/pending
	public CoursPlan(int planId, int batchId, int daynumber, String topic, String status) {
		super();
		this.planId = planId;
		this.batchId = batchId;
		this.daynumber = daynumber;
		this.topic = topic;
		this.status = status;
	}

}
