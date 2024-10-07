/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response;

import lombok.Data;
import lombok.ToString;

/**
 *
 * @author Terminal G
 */
@Data
@ToString
public class GenericErrorResponse {
    
    private String timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
    
}
