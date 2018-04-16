package com.yan.gant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yan.common.util.SchameCopyUtil;
import com.yan.gant.dao.PMProjectMongoDaoUtil;
import com.yan.gant.dao.PMProjectResourceMongoDaoUtil;
import com.yan.gant.dao.PMProjectRoleMongoDaoUtil;
import com.yan.gant.dao.PMTaskMongoDaoUtil;
import com.yan.gant.dao.PMTaskResourceMongoDaoUtil;
import com.yan.gant.model.PMProject;
import com.yan.gant.model.PMProjectResource;
import com.yan.gant.model.PMProjectRole;
import com.yan.gant.model.PMTask;
import com.yan.gant.vo.PMProjectVo;
import com.yan.gant.vo.PMResourceVo;
import com.yan.gant.vo.PMRoleVo;
import com.yan.gant.vo.PMTaskVo;

@Service
public class PMProjectService {

	@Autowired
	private PMProjectMongoDaoUtil pmProjectMongoDaoUtil;
	
	@Autowired
	private PMProjectResourceMongoDaoUtil pmProjectResourceMongoDaoUtil;
	
	@Autowired
	private PMProjectRoleMongoDaoUtil pmProjectRoleMongoDaoUtil;
	
	@Autowired
	private PMTaskMongoDaoUtil pmTaskMongoDaoUtil;
	
	@Autowired
	private PMTaskResourceMongoDaoUtil pmTaskResourceMongoDaoUtil;
	
	public String savePMProject(PMProjectVo pmProjectVo){
		
		//TODO 将 PMProjectVo 转换为 PMProject, PMProjectResource, PMProjectRole, PMTask
		PMProject pmProject = this.assemblePMProject(pmProjectVo);
		List<PMProjectResource> pmProjectResources = this.assemblePMProjectResources(pmProjectVo);
		List<PMProjectRole> pmProjectRoles = this.assemblePMProjectRoles(pmProjectVo);
		List<PMTask> pmTasks = this.assemblePMTasks(pmProjectVo);
		
		//TODO 保存 PMProject 并生成id
		String projectId = pmProjectMongoDaoUtil.insertPMProject(pmProject);
		if(pmProjectResources != null){
			for(PMProjectResource resource: pmProjectResources){
				resource.setProjectId(projectId);
			}
		}
		if(pmProjectRoles != null){
			for(PMProjectRole role: pmProjectRoles){
				role.setProjectId(projectId);
			}
		}
		if(pmTasks != null){
			for(PMTask task: pmTasks){
				task.setProjectId(projectId);
			}
		}
		
		//TODO 处理 PMProjectResource
		pmProjectResourceMongoDaoUtil.insertPMProjectResourceList(pmProjectResources);
		
		//TODO 处理 PMProjectRole
		pmProjectRoleMongoDaoUtil.insertPMProjectRoleList(pmProjectRoles);
		
		//TODO 处理 PMTask
		pmTaskMongoDaoUtil.insertPMTaskList(pmTasks);
		
		//TODO 处理 PMTaskResource
		//pmTaskResourceMongoDaoUtil.insertPMTaskResourceList(pmTaskResources);
		
		return projectId;
	}
	
	public PMProjectVo findPmProject(String projectId){
		
		
		//TODO 根据projectId查找 PMProject
		PMProject pmProject = pmProjectMongoDaoUtil.findPMProjectById(projectId);
		
		//TODO 组装成vo
		PMProjectVo pmProjectVo = null;
		if(pmProject != null) {
			//TODO 根据projectId查找 PMProjectResource
			List<PMProjectResource> pmProjectResources = pmProjectResourceMongoDaoUtil.findPMProjectResourceListByProjectId(projectId);
			
			//TODO 根据projectId查找 PMProjectRole
			List<PMProjectRole> pmProjectRoles = pmProjectRoleMongoDaoUtil.findPMProjectRoleListByProjectId(projectId);
			
			//TODO 根据projectId查找 PMTask
			List<PMTask> pmTasks = pmTaskMongoDaoUtil.findPMTaskListByProjectId(projectId);
			
			pmProjectVo = (PMProjectVo)SchameCopyUtil.simpleCopy(pmProject, PMProjectVo.class);
			
			// 处理资源
			List<PMResourceVo> pmResourceVos = null;
			if(pmProjectVo != null && pmProjectResources != null) {
				pmResourceVos = new ArrayList<>();
				for(PMProjectResource pmProjectResource : pmProjectResources) {
					PMResourceVo pmResourceVo = (PMResourceVo)SchameCopyUtil.simpleCopy(pmProjectResource, PMResourceVo.class);
					pmResourceVos.add(pmResourceVo);
				}
			}
			pmProjectVo.setResources(pmResourceVos);
			
			// 处理角色
			List<PMRoleVo> pmRoleVos = null;
			if(pmProjectVo != null && pmProjectRoles != null) {
				pmRoleVos = new ArrayList<>();
				for(PMProjectRole pmProjectRole : pmProjectRoles) {
					PMRoleVo pmRoleVo = (PMRoleVo)SchameCopyUtil.simpleCopy(pmProjectRole, PMRoleVo.class);
					pmRoleVos.add(pmRoleVo);
				}
			}
			pmProjectVo.setRoles(pmRoleVos);
			
			// 处理任务
			List<PMTaskVo> pmTaskVos = null;
			if(pmProjectVo != null && pmTasks != null) {
				pmTaskVos = new ArrayList<>();
				for(PMTask pmTask : pmTasks) {
					PMTaskVo pmTaskVo = (PMTaskVo)SchameCopyUtil.simpleCopy(pmTask, PMTaskVo.class);
					pmTaskVos.add(pmTaskVo);
				}
			}
			pmProjectVo.setTasks(pmTaskVos);
			
		}
		
		return pmProjectVo;
	}
	
	
	
	/**
	 * 从 PMProjectVo 对象中组装 PMProject 对象
	 * @param pmProjectVo
	 * @return
	 */
	private PMProject assemblePMProject(PMProjectVo pmProjectVo){
		PMProject pmProject = (PMProject)SchameCopyUtil.simpleCopy(pmProjectVo, PMProject.class);
		return pmProject;
	}
	
	/**
	 * 从 PMProjectVo 对象中组装 List<PMProjectRresource> 对象
	 * @return
	 */
	private List<PMProjectResource> assemblePMProjectResources(PMProjectVo pmProjectVo){
		List<PMProjectResource> pmProjectResources = null;
		if(pmProjectVo != null && pmProjectVo.getResources() != null) {
			pmProjectResources = new ArrayList<>();
			List<PMResourceVo> pmResourceVos = pmProjectVo.getResources();
			for(PMResourceVo pmResourceVo : pmResourceVos) {
				PMProjectResource pmProjectResource = (PMProjectResource)SchameCopyUtil.simpleCopy(pmResourceVo, PMProjectResource.class);
				pmProjectResources.add(pmProjectResource);
			}
		}
		return pmProjectResources;
	}
	
	/**
	 * 从 PMProjectVo 对象中组装 List<PMProjectRole> 对象
	 * @param pmProjectVo
	 * @return
	 */
	private List<PMProjectRole> assemblePMProjectRoles(PMProjectVo pmProjectVo){
		List<PMProjectRole> pmProjectRoles = null;
		if(pmProjectVo != null && pmProjectVo.getRoles() != null) {
			pmProjectRoles = new ArrayList<>();
			List<PMRoleVo> pmRoleVos = pmProjectVo.getRoles();
			for(PMRoleVo pmRoleVo : pmRoleVos) {
				PMProjectRole pmProjectRole = (PMProjectRole)SchameCopyUtil.simpleCopy(pmRoleVo, PMProjectRole.class);
				pmProjectRoles.add(pmProjectRole);
			}
		}
		return pmProjectRoles;
	}
	
	/**
	 * 从 PMProjectVo 对象中组装 List<PMTask> 对象
	 * @param pmProjectVo
	 * @return
	 */
	private List<PMTask> assemblePMTasks(PMProjectVo pmProjectVo){
		List<PMTask> pmTasks = null;
		if(pmProjectVo != null && pmProjectVo.getTasks() != null) {
			pmTasks = new ArrayList<>();
			List<PMTaskVo> pmTaskVos = pmProjectVo.getTasks();
			for(PMTaskVo pmTaskVo : pmTaskVos) {
				PMTask pmTask = (PMTask)SchameCopyUtil.simpleCopy(pmTaskVo, PMTask.class);
				pmTasks.add(pmTask);
			}
		}
		return pmTasks;
	}
	
}
