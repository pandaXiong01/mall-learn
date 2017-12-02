package com.xiong.dao;

import com.xiong.vo.ProjectMember;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by gonghui on 2017/11/23.
 */
public interface ProjectMapper {

    int addProject(@Param("projectName")String projectName, @Param("projectId")String projectId,
                   @Param("creatorId")String creatorId);

    int checkProjectCreator(@Param("projectId")String projectId, @Param("creatorId")String creatorId);

    int addMemberToProject(@Param("memberId")String memberId, @Param("projectId")String projectId,
                           @Param("groupId")Integer groupId,@Param("role")Integer role);

    int updateMemberToProject(@Param("memberId")String memberId, @Param("projectId")String projectId,
                              @Param("groupId")Integer groupId, @Param("role")Integer role);

    int deleteMemberFromProject(@Param("memberId")String memberId, @Param("projectId")String projectId);

    int checkProjectExsit(@Param("projectName")String projectName, @Param("creatorId")String creatorId);

    List<ProjectMember> getProjectMember(@Param("projectId")String projectId);



}
