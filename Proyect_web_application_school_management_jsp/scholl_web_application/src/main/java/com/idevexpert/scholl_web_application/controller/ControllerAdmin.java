package com.idevexpert.scholl_web_application.controller;

import com.google.gson.Gson;
import com.idevexpert.scholl_web_application.data.dao.PagosDao;
import com.idevexpert.scholl_web_application.data.dto.PagosDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(name = "ControllerAdmin", urlPatterns = {"/admin"})
public class ControllerAdmin extends HttpServlet {

    private final PagosDao pagosDAO = new PagosDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (request.getContentType() != null) {
            List<PagosDto> pagosList = pagosDAO.getAllPagos();
            
            Map<String, List<PagosDto>> responseData = new HashMap<>();
            responseData.put("ingresos", pagosList);
            responseData.put("egresos", pagosList);

            String json = new Gson().toJson(responseData);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
            
        } else {
            
            request.setAttribute("pages", "views/admin/Admin.jsp");
            request.setAttribute("path", request.getServletPath());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            try {
                switch (action) {
                    case "createIngreso":
                        createIngreso(request, response);
                        break;
                    case "createEgreso":
                        createEgreso(request, response);
                        break;
                    case "update":
                        updatePago(request, response);
                        break;
                    case "delete":
                        deletePago(request, response);
                        break;
                    default:
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
                }
            } catch (SQLException e) {
                throw new ServletException("Database error", e);
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action parameter is missing");
        }
    }

    private void createIngreso(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String valor = request.getParameter("valor");
        String description = request.getParameter("description");
        int idUser = Integer.parseInt(request.getParameter("idUser"));

        PagosDto pago = new PagosDto(0, valor, description, idUser);
        pagosDAO.insertPago(pago);

        response.getWriter().write("{\"success\":true}");
    }

    private void createEgreso(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String valor = request.getParameter("valor");
        String description = request.getParameter("description");
        int idUser = Integer.parseInt(request.getParameter("idUser"));

        PagosDto pago = new PagosDto(0, valor, description, idUser);
        pagosDAO.insertPago(pago);

        response.getWriter().write("{\"success\":true}");
    }

    private void updatePago(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idpagos = Integer.parseInt(request.getParameter("idpagos"));
        String valor = request.getParameter("valor");
        String description = request.getParameter("description");
        int idUser = Integer.parseInt(request.getParameter("idUser"));

        PagosDto pago = new PagosDto(idpagos, valor, description, idUser);
        pagosDAO.updatePago(pago);

        response.getWriter().write("{\"success\":true}");
    }

    private void deletePago(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int idpagos = Integer.parseInt(request.getParameter("idpagos"));
        pagosDAO.deletePago(idpagos);

        response.getWriter().write("{\"success\":true}");
    }
}
