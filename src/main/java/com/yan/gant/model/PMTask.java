package com.yan.gant.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 描述项目中都有哪些任务
 * @author Yan
 *
 */
public class PMTask implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private Integer progress;
	private boolean progressByWorklog;
	private Integer relevance;
	private String type;
	private String typeId;
	private String description;
	private String code;
	private Integer level;
	private String status;
	private String depends;
	private boolean canWrite;
	private Date start;
	private Integer duration;
	private Date end;
	private boolean startIsMilestone;
	private boolean endIsMilestone;
	private boolean collapsed;
	private List<String> assigs;
	private boolean hasChild;
	
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
	public Integer getProgress() {
		return progress;
	}
	public void setProgress(Integer progress) {
		this.progress = progress;
	}
	public boolean isProgressByWorklog() {
		return progressByWorklog;
	}
	public void setProgressByWorklog(boolean progressByWorklog) {
		this.progressByWorklog = progressByWorklog;
	}
	public Integer getRelevance() {
		return relevance;
	}
	public void setRelevance(Integer relevance) {
		this.relevance = relevance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDepends() {
		return depends;
	}
	public void setDepends(String depends) {
		this.depends = depends;
	}
	public boolean isCanWrite() {
		return canWrite;
	}
	public void setCanWrite(boolean canWrite) {
		this.canWrite = canWrite;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public boolean isStartIsMilestone() {
		return startIsMilestone;
	}
	public void setStartIsMilestone(boolean startIsMilestone) {
		this.startIsMilestone = startIsMilestone;
	}
	public boolean isEndIsMilestone() {
		return endIsMilestone;
	}
	public void setEndIsMilestone(boolean endIsMilestone) {
		this.endIsMilestone = endIsMilestone;
	}
	public boolean isCollapsed() {
		return collapsed;
	}
	public void setCollapsed(boolean collapsed) {
		this.collapsed = collapsed;
	}
	public List<String> getAssigs() {
		return assigs;
	}
	public void setAssigs(List<String> assigs) {
		this.assigs = assigs;
	}
	public boolean isHasChild() {
		return hasChild;
	}
	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
}
