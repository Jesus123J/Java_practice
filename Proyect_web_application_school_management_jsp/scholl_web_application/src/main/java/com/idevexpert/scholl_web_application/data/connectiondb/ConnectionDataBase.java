/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idevexpert.scholl_web_application.data.connectiondb;

import java.sql.Connection;

/**
 *
 * @author Jesus Gutierrez
 */
public interface ConnectionDataBase{ 
    Connection connectionDataBase = ConnectionDb.connectionDb();
}
