/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.idevexpert.scholl_web_application.controller;

import com.idevexpert.scholl_web_application.data.dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jesus Gutierrez
 */
@WebServlet(name = "ControllerLogin", urlPatterns = "/login")
public class ControllerLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("pages", "views/auth/Auth.jsp");
        request.setAttribute("path", request.getServletPath());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "loginService":
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                int var = UserDao.user_and_password(username, password);
                if (var == 1) {
                    request.getSession().setAttribute("username", username);
           
                    request.setAttribute("pages", "views/dashboard/Dashboard.jsp");
                    request.setAttribute("path", "/dashboard");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else if (var == 2) {
                    request.setAttribute("pages", "views/auth/Auth.jsp"); //views/auth/Auth.jsp
                    request.setAttribute("path", request.getServletPath());
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                break;
            case "registerUserLogin":
                String nombre = request.getParameter("name");
                String correo = request.getParameter("email");
                String user = request.getParameter("user");
                String passString = request.getParameter("password");

                int varRegister = UserDao.user_register(nombre, correo, user, passString);
                if (varRegister == 1) {
                    request.setAttribute("pages", "views/dashboard/Dashboard.jsp");
                    request.setAttribute("path", "/dashboard");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    request.setAttribute("pages", "views/auth/Auth.jsp"); //views/auth/Auth.jsp
                    request.setAttribute("path", request.getServletPath());
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
