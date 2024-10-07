package com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request;

import lombok.Data;

/*
@author YANPIER
 */
@Data
public class CoordinatorEditAccountWithStatusRequest {
    
      private Long    accountId;
    private String  code;
    private String  username; //
    private String  password;  // ""
    private Integer status;
    
}
