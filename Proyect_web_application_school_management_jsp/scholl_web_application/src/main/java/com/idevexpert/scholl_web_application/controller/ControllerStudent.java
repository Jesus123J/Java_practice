/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.idevexpert.scholl_web_application.controller;

import com.idevexpert.scholl_web_application.data.connectiondb.ConnectionDb;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jesus Gutierrez
 */
@WebServlet(name = "ControllerStudent", urlPatterns = {"/ControllerStudent", "/student"})
public class ControllerStudent extends HttpServlet {

    public void showCurses(HttpServletRequest request, HttpServletResponse response) {
        if (request.getContentType() == null) {
            try {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            } catch (IOException ex) {
            }
        }
        if (request.getContentType().equalsIgnoreCase("application/json")) {
//            // Leer el JSON recibido en la solicitud
//            StringBuilder sb = new StringBuilder();
//            try (BufferedReader reader = request.getReader()) {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    sb.append(line);
//                }
//            } catch (IOException ex) {
//                Logger.getLogger(ControllerStudent.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            // Convertir el cuerpo de la solicitud a JsonObject
//            JsonObject jsonRequest;
//            try (JsonReader jsonReader = Json.createReader(new StringReader(sb.toString()))) {
//                jsonRequest = jsonReader.readObject();
//            }
//
//            // Procesar el JSON (aquí simplemente lo imprimimos)
//            System.out.println("Received JSON: " + jsonRequest.toString());

            // Crear una respuesta JSON
//            JsonObject jsonResponse = Json.createObjectBuilder()
//                    .add("status", "success")
//                    .add("message", "JSON received successfully")
//                    .add("receivedData", "Hola")
//                    .build();
            // Enviar la respuesta JSON
            try (PrintWriter out = response.getWriter()) {
                out.print(Json.createObjectBuilder().add("Name", "El pepe"));
                out.flush();
            } catch (IOException ex) {
                Logger.getLogger(ControllerStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // String formComponent = (String) request.getParameter("action");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String name = "";
//        try {
//            // Configurar la respuesta para que sea JSON
//            Connection cn = ConnectionDb.connectionDb();
//            if (cn != null) {
//
//                PreparedStatement prs = cn.prepareStatement("SELECT  * FROM paginaweb.user;");
//                ResultSet rs = prs.executeQuery();
//                while (rs.next()) {
//                    name = rs.getString("user");
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ControllerStudent.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(ControllerStudent.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//
//        JsonObject jsonResponse = Json.createObjectBuilder()
//                .add("status", "success")
//                .add("message", "GET request received successfully")
//                .add("studentId", "12")
//                .add("nombre", name)
//                .build();
//
//        OutputStream outputStream = response.getOutputStream();
//        outputStream.write(jsonResponse.toString().getBytes());
//        outputStream.flush();
//        outputStream.close();

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        showCurses(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
