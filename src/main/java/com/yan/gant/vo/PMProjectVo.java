package com.yan.gant.vo;

import java.io.Serializable;
import java.util.List;

public class PMProjectVo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	
	private List<PMTaskVo> tasks;
	
	private List<PMResourceVo> resources;
	
	private List<PMRoleVo> roles;
	
	private Integer selectedRow;
	private List<String> deletedTaskIds;
	private boolean canWrite;
	private boolean canDelete;
	private boolean canWriteOnParent;
	private boolean canAdd;
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
	public List<PMTaskVo> getTasks() {
		return tasks;
	}
	public void setTasks(List<PMTaskVo> tasks) {
		this.tasks = tasks;
	}
	public List<PMResourceVo> getResources() {
		return resources;
	}
	public void setResources(List<PMResourceVo> resources) {
		this.resources = resources;
	}
	public List<PMRoleVo> getRoles() {
		return roles;
	}
	public void setRoles(List<PMRoleVo> roles) {
		this.roles = roles;
	}
	public Integer getSelectedRow() {
		return selectedRow;
	}
	public void setSelectedRow(Integer selectedRow) {
		this.selectedRow = selectedRow;
	}
	public List<String> getDeletedTaskIds() {
		return deletedTaskIds;
	}
	public void setDeletedTaskIds(List<String> deletedTaskIds) {
		this.deletedTaskIds = deletedTaskIds;
	}
	public boolean isCanWrite() {
		return canWrite;
	}
	public void setCanWrite(boolean canWrite) {
		this.canWrite = canWrite;
	}
	public boolean isCanDelete() {
		return canDelete;
	}
	public void setCanDelete(boolean canDelete) {
		this.canDelete = canDelete;
	}
	public boolean isCanWriteOnParent() {
		return canWriteOnParent;
	}
	public void setCanWriteOnParent(boolean canWriteOnParent) {
		this.canWriteOnParent = canWriteOnParent;
	}
	public boolean isCanAdd() {
		return canAdd;
	}
	public void setCanAdd(boolean canAdd) {
		this.canAdd = canAdd;
	}
	
}
