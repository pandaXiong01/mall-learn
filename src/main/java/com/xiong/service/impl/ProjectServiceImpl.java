package com.xiong.service.impl;

import com.mmall.common.Const;
import com.xiong.common.exceptions.ValidationException;
import com.xiong.dao.ProjectMapper;
import com.xiong.pojo.XUser;
import com.xiong.service.ProjectService;
import com.xiong.util.Check;
import com.xiong.util.UUIDUtil;
import com.xiong.vo.ProjectMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by gonghui on 2017/11/27.
 */

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper mapper;

//    @Autowired
//    private HttpSession session;

    @Override
    public String createProject(String projectName, String creatorId) {

        boolean checkResult = checkProjectExsit(projectName, creatorId);
        if (checkResult) {
            throw new ValidationException("项目名称不能重复");
        }
        Check.isEmpty(projectName, "项目名称不能为空");
        String uuid = UUIDUtil.getUUID();
        mapper.addProject(projectName,uuid, creatorId);
        return uuid;
    }

    @Override
    public void addMember(String projectId, String memberId, Integer groupId, Integer role) {
        Check.isEmpty(projectId, "项目id不能为空");
        Check.isEmpty(memberId, "人员id不能为空");
//        XUser user = (XUser)session.getAttribute(Const.CURRENT_USER);
//        if (user != null) {
//            if (checkProjectCreator(projectId,user.getUserId())) {
//                mapper.addMemberToProject(memberId, projectId, groupId, role);
//            } else {
//                throw new ValidationException("该用户没有权限给本项目添加用户");
//            }
//        }

    }

    @Override
    public void updateMemberProjectInfo(String projectId, String memberId, Integer groupId, Integer role) {
        Check.isEmpty(projectId, "项目id不能为空");
        Check.isEmpty(memberId, "人员id不能为空");
        mapper.updateMemberToProject(memberId,projectId,groupId,role);
    }

    @Override
    public void deleteMemberFromProject(String projectId, String memberId) {
        Check.isEmpty(projectId, "项目id不能为空");
        Check.isEmpty(memberId, "人员id不能为空");
        mapper.deleteMemberFromProject(memberId, projectId);
    }

    @Override
    public List<ProjectMember> getProjectMember(String projectId) {
        Check.isEmpty(projectId, "项目id不能为空");
        return mapper.getProjectMember(projectId);
    }


    /**
     * 检查project是否重名
     * @param projectName
     * @param creatorId
     * @return
     */
    private boolean checkProjectExsit(String projectName, String creatorId) {
        return mapper.checkProjectCreator(projectName, creatorId)==1 ? true:false;
    }

    /**
     * 检查用户是否是创建者
     * @param projectId
     * @param creatorId
     * @return
     */
    private boolean checkProjectCreator(String projectId, String creatorId) {
        return mapper.checkProjectCreator(projectId, creatorId) == 1 ? true:false;
    }
}
