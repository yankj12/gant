package com.yan.gant.model;

import java.io.Serializable;

/**
 * 描述项目中都有哪些资源
 * @author Yan
 *
 */
public class PMProjectResource implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	
	private String name;

	private String projectId;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
}