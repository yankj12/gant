package com.yan.gant.model;

import java.io.Serializable;

/**
 * 描述项目中都使用了哪些资源，每个资源是什么角色
 * @author Yan
 *
 */
public class PMTaskResource implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	
	private String taskId;
	
	private String resourceId;

	private String resourceName;
	
	private String roleId;
	
	private String roleName;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
