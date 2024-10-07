package com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request;

import lombok.Data;

/*
@author YANPIER
 */
@Data
public class CoordinatorAssingStudentByProxyRequest {
    private Long proxyAccountId;
    private Long studentAccountId;

}