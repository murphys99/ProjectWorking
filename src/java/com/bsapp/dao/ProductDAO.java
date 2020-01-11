/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsapp.dao;

import com.bsapp.model.User;
import com.bsapp.model.Product;
import com.bsapp.utils.DBManager;
import static com.sun.xml.ws.security.impl.policy.Constants.logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;

/**
 *
 * @author bemerson
 */
public class ProductDAO {

    
    public Vector<Product> getAllProducts() {

        DBManager dbmgr = new DBManager();
        Connection con = dbmgr.getConnection();
        int productId = 0;
        String name = null;
        String description = null;
       
        Vector<Product> productData = new Vector();

        String query = "SELECT * FROM PRODUCTDATA";
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                productId = (rs.getInt(1));
                name = (rs.getString(2));
                description = (rs.getString(3));
                Product tempProduct = new Product();
                tempProduct.setName(name);
                tempProduct.setId(productId);
                tempProduct.setDescription(description);
                productData.add(tempProduct);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

      
        return productData;
        
        

    }
    public void insertProduct(Product newProduct){
        
        String stmtNewProduct = "INSERT INTO PRODUCTDATA(NAME,DESCRIPTION)\n VALUES('" + newProduct.getName() + "', '" + newProduct.getDescription() + "')";
        DBManager dbmgr = new DBManager();
        Statement currentStatement = null;
        Connection con = dbmgr.getConnection();
        try {
            // Execute statement
            currentStatement = con.createStatement();
            currentStatement.execute(stmtNewProduct);
        } catch (SQLException sqlExcept) {
            logger.log(Level.SEVERE, null, sqlExcept);
        }
    }
            
        

}
