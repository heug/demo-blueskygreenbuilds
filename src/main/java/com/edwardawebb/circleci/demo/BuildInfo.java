package com.edwardawebb.circleci.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BuildInfo {

    @Value("${CF_INSTANCE_INDEX}")
    private String index;

    @Value("${circle_build_num}")
    private String buildNum;

    @Value("${circle_commit}")
    private String commitHash;

    @Value("${circle_user}")
    private String commitUser;

    @Value("${circle_repo}")
    private String repoName;

    @Value("${CF_INSTANCE_GUID}")
    private String cfGuid;

    @Value("${vcap.application.name}")
    private String applicationName;

    @Value("${circle_workflow_guid}")
    private String workflowGuid;


    protected static final String CCI_URL_PREFIX ="https://circleci.com/workflow-run/";
    protected static final String GH_URL_FORMAT ="https://github.com/%s/%s/commit/%s";

    public BuildInfo() {
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getCfGuid() {
        return cfGuid;
    }

    public void setCfGuid(String guid) {
        this.cfGuid = guid;
    }
    public String getWorkflowGuid() {
        return workflowGuid;
    }

    public void setWorkflowGuid(String workflowGuid) {
        this.workflowGuid = workflowGuid;
    }

    public String getWorkflowUrl(){
        return CCI_URL_PREFIX + workflowGuid;
    }


    public String getCommitHash() {
        return commitHash;
    }

    public void setCommitHash(String commitHash) {
        this.commitHash = commitHash;
    }

    public String getCommitUser() {
        return commitUser;
    }

    public void setCommitUser(String commitUser) {
        this.commitUser = commitUser;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }


    public String getGithubUrl(){
        return formatGithubUrl(commitUser,repoName,commitHash);
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getBuildNum() {
        return buildNum;
    }

    public void setBuildNum(String buildNum) {
        this.buildNum = buildNum;
    }



    protected String formatGithubUrl(String user, String repo, String commitHash){
        return String.format(GH_URL_FORMAT, user, repo, commitHash);
    }
}
