package com.xiong.service;

import com.xiong.vo.ProjectMember;

import java.util.List;

/**
 * Created by gonghui on 2017/11/27.
 */
public interface ProjectService {
    String createProject(String projectName, String creatorId);
    void addMember(String projectId, String userId, Integer groupId, Integer role);
    void updateMemberProjectInfo(String projectId, String memberId, Integer groupId, Integer role);
    void deleteMemberFromProject(String projectId, String memberId);
    List<ProjectMember> getProjectMember(String projectId);

}
