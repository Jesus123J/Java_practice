/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idevexpert.managementwarehousestore.data;

import java.sql.Connection;

/**
 *
 * @author Jesus Gutierrez
 */
public interface ConnectionDataBase {
    Connection connectionMysql = ConnectionDb.connectionMySQL();
    Connection connectionSqlServer = ConnectionDb.connectionSQLServer();
}
