/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsapp.servlets;


import com.bsapp.dao.UserDAO;
import com.bsapp.model.User;
import com.bsapp.utils.IConstants;
import java.io.IOException;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BEmerson
 */
public class TestPageServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String theString = new String("THIS IS A TEST");
        request.setAttribute("stringKey", theString);
        
        User u1 = new User(1, "email@email.com", "password", "John", "Smith", IConstants.USER_TYPE_ADMIN);
        
        request.setAttribute("UserObjectKey", u1);
        
        User u2 = new User(1, "email@email.com", "password", "John", "Session", IConstants.USER_TYPE_ADMIN);

        
        //Lets put another one on the session
        request.getSession().setAttribute("SessionUserObjectKey", u2);
        
       
        UserDAO userDAO = new UserDAO();
        Vector<User> allUsersVect = userDAO.getAllUsers();

        request.getSession(true).setAttribute(IConstants.REQUEST_KEY_ALL_USERS, allUsersVect);

        RequestDispatcher rd = request.getRequestDispatcher("/testPage.jsp");
        rd.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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
