package com.yan.gant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yan.gant.dao.PMProjectMongoDaoUtil;
import com.yan.gant.dao.PMProjectRoleMongoDaoUtil;
import com.yan.gant.dao.PMProjectRresourceMongoDaoUtil;
import com.yan.gant.dao.PMTaskMongoDaoUtil;
import com.yan.gant.model.PMProject;
import com.yan.gant.model.PMProjectRole;
import com.yan.gant.model.PMProjectRresource;
import com.yan.gant.model.PMTask;
import com.yan.gant.vo.PMProjectVo;

@Service
public class PMProjectService {

	@Autowired
	private PMProjectMongoDaoUtil pmProjectMongoDaoUtil;
	
	@Autowired
	private PMProjectRresourceMongoDaoUtil pmProjectRresourceMongoDaoUtil;
	
	@Autowired
	private PMProjectRoleMongoDaoUtil pmProjectRoleMongoDaoUtil;
	
	@Autowired
	private PMTaskMongoDaoUtil pmTaskMongoDaoUtil;
	
	public String savePMProject(PMProjectVo pmProjectVo){
		
		//TODO 将 PMProjectVo 转换为 PMProject, PMProjectResource, PMProjectRole, PMTask
		PMProject pmProject = this.assemblePMProject(pmProjectVo);
		List<PMProjectRresource> pmProjectRresources = this.assemblePMProjectRresources(pmProjectVo);
		List<PMProjectRole> pmProjectRoles = this.assemblePMProjectRoles(pmProjectVo);
		List<PMTask> pmTasks = this.assemblePMTasks(pmProjectVo);
		
		//TODO 保存 PMProject 并生成id
		String projectId = pmProjectMongoDaoUtil.insertPMProject(pmProject);
		if(pmProjectRresources != null && pmProjectRresources.size() > 0){
			for(PMProjectRresource resource: pmProjectRresources){
				resource.setProjectId(projectId);
			}
		}
		if(pmProjectRoles != null && pmProjectRoles.size() > 0){
			for(PMProjectRole role: pmProjectRoles){
				role.setProjectId(projectId);
			}
		}
		if(pmTasks != null && pmTasks.size() > 0){
			for(PMTask task: pmTasks){
				task.setProjectId(projectId);
			}
		}
		
		//TODO 处理 PMProjectResource
		
		//TODO 处理 PMProjectRole
		
		//TODO 处理 PMTask
		
		//TODO 处理 PMTaskResource
		
		return projectId;
	}
	
	public PMProjectVo findPmProject(String projectId){
		
		return null;
	}
	
	
	
	/**
	 * 从 PMProjectVo 对象中组装 PMProject 对象
	 * @param pmProjectVo
	 * @return
	 */
	private PMProject assemblePMProject(PMProjectVo pmProjectVo){
		
		return null;
	}
	
	/**
	 * 从 PMProjectVo 对象中组装 List<PMProjectRresource> 对象
	 * @return
	 */
	private List<PMProjectRresource> assemblePMProjectRresources(PMProjectVo pmProjectVo){
		
		return null;
	}
	
	/**
	 * 从 PMProjectVo 对象中组装 List<PMProjectRole> 对象
	 * @param pmProjectVo
	 * @return
	 */
	private List<PMProjectRole> assemblePMProjectRoles(PMProjectVo pmProjectVo){
		
		return null;
	}
	
	/**
	 * 从 PMProjectVo 对象中组装 List<PMTask> 对象
	 * @param pmProjectVo
	 * @return
	 */
	private List<PMTask> assemblePMTasks(PMProjectVo pmProjectVo){
		
		return null;
	}
	
}
