package com.yan.gant.model;

import java.io.Serializable;
import java.util.List;

/**
 * 描述项目信息
 * @author Yan
 *
 */
public class PMProject implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	
	private List<PMTask> tasks;
	
	private List<PMProjectRresource> resources;
	
	private List<PMProjectRole> roles;
	
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
	public List<PMTask> getTasks() {
		return tasks;
	}
	public void setTasks(List<PMTask> tasks) {
		this.tasks = tasks;
	}
	public List<PMProjectRresource> getResources() {
		return resources;
	}
	public void setResources(List<PMProjectRresource> resources) {
		this.resources = resources;
	}
	public List<PMProjectRole> getRoles() {
		return roles;
	}
	public void setRoles(List<PMProjectRole> roles) {
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
