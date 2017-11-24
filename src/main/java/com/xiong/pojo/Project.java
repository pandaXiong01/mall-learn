package com.xiong.pojo;

/**
 * Created by gonghui on 2017/11/23.
 */
public class Project {

    private String projectId;
    private String projectName;
    private String creatorId;

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getCreatorId() {
        return creatorId;
    }
}
