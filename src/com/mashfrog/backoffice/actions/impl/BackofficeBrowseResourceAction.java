package com.mashfrog.backoffice.actions.impl;

import java.util.List;

import org.opencms.file.CmsObject;

import com.mashfrog.backoffice.CmsBackofficeActionElement;
import com.mashfrog.backoffice.project.beans.TabbedContentBean;

public class BackofficeBrowseResourceAction extends com.mashfrog.backoffice.actions.BackofficeNavMenuAction implements com.mashfrog.backoffice.actions.BackofficeTabbedContentAction {
    protected List<TabbedContentBean> contents;

    public void execute(CmsBackofficeActionElement backofficeActionElement){
    }

    public void setAdditonalConfigurationFilePath(String filePath, CmsObject cmsObject){
    }

    public List<TabbedContentBean> getTabbedContents(){
        return null;
    }

    public void setTabbedContents(List<TabbedContentBean> contents){
    }

    public void addTabbedContent(TabbedContentBean content){
    }

}
