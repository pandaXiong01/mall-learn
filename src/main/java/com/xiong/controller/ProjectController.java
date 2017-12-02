package com.xiong.controller;

import com.mmall.common.Const;
import com.xiong.common.exceptions.ValidationException;
import com.xiong.pojo.XUser;
import com.xiong.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gonghui on 2017/11/27.
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @RequestMapping("create")
    @ResponseBody
    public Map<String,String > createProject(String projectName, HttpSession session) {
        XUser user = (XUser)session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            throw new ValidationException("用户未登录", -99);
        }
        String uuid = projectService.createProject(projectName, user.getUserId());
        Map<String, String> map = new HashMap<String, String>();
        map.put("projectUuid",uuid);
        return map;
    }

    @RequestMapping("addMember")
    @ResponseBody
    public void addMemberToProject(String projectId, String memberId, Integer groupId, Integer role) {
        projectService.addMember(projectId, memberId, groupId, role);
    }

    @RequestMapping("deleteMember")
    @ResponseBody
    public void deleteMemberFromProject(String projectId, String memberId) {
        projectService.deleteMemberFromProject(projectId,memberId);
    }

    @RequestMapping("getMember")
    @ResponseBody
    public List getProjectMember(String projectId) {

        return projectService.getProjectMember(projectId);
    }
}
