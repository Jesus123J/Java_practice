package com.idevexpert.schoolnotes_fts3096_desktop.data.entity;


import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.*;
import com.idevexpert.schoolnotes_fts3096_desktop.data.entity.AccountTb;
import lombok.Data;

/*
@author YANPIER
 */

@Data
public class CoordinatorEditAccountWithStatusResponse {
    
   private Integer code;
    private String message;
    private AccountTb account;
    
}
