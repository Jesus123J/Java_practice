package com.idevexpert.scholl_web_application.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControllerDashboard", urlPatterns = {"/dashboard"})
public class ControllerDashboard extends HttpServlet {

    private void pathDashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession() != null){
            request.getSession().invalidate();
        }
        request.setAttribute("pages", "views/dashboard/Dashboard.jsp");
        request.setAttribute("path", request.getServletPath());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        pathDashboard(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "gotToLogin":

                break;
            default:

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
