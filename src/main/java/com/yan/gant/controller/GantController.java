package com.yan.gant.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yan.gant.dao.PMProjectMongoDaoUtil;
import com.yan.gant.model.PMProject;
import com.yan.gant.model.PMProjectRole;
import com.yan.gant.model.PMProjectRresource;
import com.yan.gant.model.PMTask;
import com.yan.gant.vo.PMProjectVo;
import com.yan.gant.vo.PMRoleVo;
import com.yan.gant.vo.PMRresourceVo;
import com.yan.gant.vo.PMTaskVo;

@Controller
public class GantController {

	@Autowired
	private PMProjectMongoDaoUtil pmProjectMongoDaoUtil;
	
    @RequestMapping("/getProject")
    @ResponseBody
    public PMProjectVo getProject(){
    	PMProjectVo project = null;
    	
    	project = new PMProjectVo();
    	List<PMTaskVo> tasks = new ArrayList<>();
    	PMTaskVo task1 = new PMTaskVo();
    	task1.setId("-1");
    	task1.setName("Gantt editor");
    	task1.setProgress(0);
    	task1.setProgressByWorklog(false);
    	task1.setRelevance(0);
    	task1.setType("");
    	task1.setTypeId("");
    	task1.setDescription("");
    	task1.setCode("");
    	task1.setLevel(0);
    	task1.setStatus("STATUS_ACTIVE");
    	task1.setDepends("");
    	task1.setCanWrite(true);
    	task1.setStart(new Date(1396994400000L));
    	task1.setDuration(20);
    	task1.setEnd(new Date(1399586399999L));
    	task1.setStartIsMilestone(false);
    	task1.setEndIsMilestone(false);
    	task1.setCollapsed(false);
    	task1.setAssigs(new ArrayList<>(0));
    	task1.setHasChild(true);
    	
    	tasks.add(task1);
    	project.setTasks(tasks);

    	project.setSelectedRow(2);
    	project.setDeletedTaskIds(new ArrayList<>(0));
    	
    	List<PMRresourceVo> resources = new ArrayList<>();
    	PMRresourceVo resource1 = new PMRresourceVo();
    	resource1.setId("tmp_1");
    	resource1.setName("Resource 1");
    	resources.add(resource1);
    	project.setResources(resources);
    	
    	List<PMRoleVo> roles = new ArrayList<>();
    	PMRoleVo role1 = new PMRoleVo();
    	role1.setId("tmp_1");
    	role1.setName("Project Manager");
    	roles.add(role1);
    	project.setRoles(roles);
    	
        project.setCanWrite(true);
        project.setCanDelete(true);
        project.setCanWriteOnParent(true);
        project.setCanAdd(true);
    	
        return project;
    }
    
    @RequestMapping("/saveProject")
    @ResponseBody
    public PMProject saveProject(){
    	PMProject project = null;
    	
    	project = new PMProject();
    	List<PMTask> tasks = new ArrayList<>();
    	PMTask task1 = new PMTask();
    	//task1.setId("-1");
    	task1.setName("Gantt editor");
    	task1.setProgress(0);
    	task1.setProgressByWorklog(false);
    	task1.setRelevance(0);
    	task1.setType("");
    	task1.setTypeId("");
    	task1.setDescription("");
    	task1.setCode("");
    	task1.setLevel(0);
    	task1.setStatus("STATUS_ACTIVE");
    	task1.setDepends("");
    	task1.setCanWrite(true);
    	task1.setStart(new Date(1396994400000L));
    	task1.setDuration(20);
    	task1.setEnd(new Date(1399586399999L));
    	task1.setStartIsMilestone(false);
    	task1.setEndIsMilestone(false);
    	task1.setCollapsed(false);
    	task1.setAssigs(new ArrayList<>(0));
    	task1.setHasChild(true);
    	
    	tasks.add(task1);
    	project.setTasks(tasks);

    	project.setSelectedRow(2);
    	project.setDeletedTaskIds(new ArrayList<>(0));
    	
    	List<PMProjectRresource> resources = new ArrayList<>();
    	PMProjectRresource resource1 = new PMProjectRresource();
    	//resource1.setId("tmp_1");
    	resource1.setName("Resource 1");
    	resources.add(resource1);
    	project.setResources(resources);
    	
    	List<PMProjectRole> roles = new ArrayList<>();
    	PMProjectRole role1 = new PMProjectRole();
    	//role1.setId("tmp_1");
    	role1.setName("Project Manager");
    	roles.add(role1);
    	project.setRoles(roles);
    	
        project.setCanWrite(true);
        project.setCanDelete(true);
        project.setCanWriteOnParent(true);
        project.setCanAdd(true);
    	
        pmProjectMongoDaoUtil.insertPMProject(project);
        
        return project;
    }
}