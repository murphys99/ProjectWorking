/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsapp.servlets;

import com.bsapp.dao.UserDAO;
import com.bsapp.dao.ProductDAO;
import com.bsapp.model.Product;
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
 * @author bemerson
 */
public class ProductManagementServlet extends HttpServlet implements IConstants {

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

        String action = request.getParameter("action");
        if (action.equals("List")){
            listProducts(request,response);
        }
        if (action.equals("addInit")){
            addInitProducts(request,response);
        }
        if (action.equals("add")){
            addProduct(request,response);
        }
        else {
        //RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        //rd.forward(request, response);
        }
    }
    
  private void listProducts(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
      ProductDAO productDAO = new ProductDAO();
        Vector<Product> allProductsVect = productDAO.getAllProducts();

        request.setAttribute(IConstants.REQUEST_KEY_ALL_PRODUCTS, allProductsVect);

        RequestDispatcher rd = request.getRequestDispatcher("/productManagement.jsp");
        rd.forward(request, response);
  }
  
  private void addInitProducts(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/addProduct.jsp");
        rd.forward(request, response);
  }
  
  private void addProduct(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {

        String name = request.getParameter("NAME");
        Product newProduct = new Product();
        newProduct.setName(name);
        
        String description = request.getParameter("DESCRIPTION");
        newProduct.setDescription(description);
       
      
        ProductDAO productDAO = new ProductDAO();
        
        productDAO.insertProduct(newProduct);
        
        Vector<Product> allProductsVect = productDAO.getAllProducts();

        request.setAttribute(IConstants.REQUEST_KEY_ALL_PRODUCTS, allProductsVect);

        RequestDispatcher rd = request.getRequestDispatcher("/productManagement.jsp");
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
