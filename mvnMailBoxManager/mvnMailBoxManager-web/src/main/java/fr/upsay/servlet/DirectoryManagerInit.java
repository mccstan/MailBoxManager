/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upsay.servlet;

import fr.upsay.directory.entity.FinalMailBoxUser;
import fr.upsay.iejb.IMailBoxManager;
import fr.upsay.iejb.IManageUsers;
import fr.upsay.mailbox.entity.Message;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mccstan
 */
@WebServlet(name = "DirectoryManagerInit", urlPatterns = {"/dminit"})
public class DirectoryManagerInit extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Resource(mappedName = "mailBoxManager")
     IMailBoxManager mailBoxManager;
    
    @Resource(mappedName = "directoryManager")
    IManageUsers directoryManager;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        //test creation de deux user
        FinalMailBoxUser user1 = new FinalMailBoxUser("yacine","1234");
        directoryManager.addUser(user1);
        
        FinalMailBoxUser user2 = new FinalMailBoxUser("Maturin","1234");
        directoryManager.addUser(user2);
        
        //recuperation des deux users créé precedement
        List<FinalMailBoxUser> boxUsers = directoryManager.lookupAllUsers();
        
        FinalMailBoxUser u1 = boxUsers.get(0);
        FinalMailBoxUser u2 = boxUsers.get(1);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Premier Use Case : Accès Directory Manager</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>1- Insertion de deux utilisateurs dans la base de donnée avec le directory Manager</h3>");
            out.println("<p>");
            out.println("User1 :  UserName=yacine  | Password=1234");
            out.println("</p>");
            out.println("<p>");
            out.println("User2 :  UserName=Maturin  | Password=1234");
            out.println("</p>");
            
            out.println("<h3>2- Récupération des deux users avec la fonction lookupAllUsers du directory Manager</h3>");
            out.println("<ul style=\"list-style-type:disc\">");
            out.println("<li>id = "+u1.getId()+"</li>");
            out.println("<li>UserName = "+u1.getUsername()+"</li>");
            out.println("<li>PassWord = "+u1.getPassword()+"</li>");
            out.println("<li>mailBoxName = "+u1.getMailBox().getMailBoxName()+"</li>");
            out.println("<li>Droit en Lecture = "+u1.getNewsGroupRight().getReadAccess()+"</li>");
            out.println("<li>Droit en Ecriture = "+u1.getNewsGroupRight().getWriteAccess()+"</li>");
            out.println("</ul>");
            
            out.println("<ul style=\"list-style-type:disc\">");
            out.println("<li>id = "+u2.getId()+"</li>");
            out.println("<li>UserName = "+u2.getUsername()+"</li>");
            out.println("<li>PassWord = "+u2.getPassword()+"</li>");
            out.println("<li>mailBoxName = "+u2.getMailBox().getMailBoxName()+"</li>");
            out.println("<li>Droit en Lecture = "+u2.getNewsGroupRight().getReadAccess()+"</li>");
            out.println("<li>Droit en Ecriture = "+u2.getNewsGroupRight().getWriteAccess()+"</li>");
            out.println("</ul>");
            
            
            out.println("</body>");
            out.println("</html>");
        }
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
