/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.entity;

import lombok.Data;

@Data
public class AccountTb {
    private Long id;
    private String code;
    private String username;
    private String password;
    private Integer accountType;
    private Integer status;
    private String createTime;
    private String updateTime;
}
