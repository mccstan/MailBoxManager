/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upsay.servlet;

import fr.upsay.directory.entity.FinalMailBoxUser;
import fr.upsay.iejb.AbstractFacadeRemote;
import fr.upsay.iejb.MySessionBeanRemote;
import fr.upsay.mailbox.entity.Message;
import fr.upsay.mailbox.entity.NewsBox;
import fr.upsay.mailbox.entity.NewsGroupRight;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mccstan
 */
@WebServlet(name = "TestEJB", urlPatterns = {"/TestEJB"})
public class TestEJB extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Resource(mappedName = "messageFacade")
    AbstractFacadeRemote messageFacade;
    
    @Resource(mappedName = "finalMailBoxUserFacade")
    AbstractFacadeRemote finalMailBoxUserFacade;
    
    @EJB
    MySessionBeanRemote mySessionBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        System.out.println("Call : "+mySessionBean.getResult());
        
        Message message1 = new Message("subject1", "Body1");
        Message message2 = new Message("subject2", "Body2");
        Message message3 = new Message("subject3", "Body3");
        messageFacade.create(message1);
        messageFacade.create(message2);
        messageFacade.create(message3);
        
         /*
            FinalMailBoxUser boxUser = new FinalMailBoxUser("mccstan2", "st@n");
            NewsGroupRight groupRight = new NewsGroupRight(true, true);
            boxUser.updateUserRight(groupRight);
            messageFacade.findAll();
            finalMailBoxUserFacade.create(boxUser);
            */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestEJB</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestEJB  is working " + request.getContextPath() + "</h1>");
            out.println("<h1>This is a bean call " + mySessionBean.getResult() + "</h1>");
            out.println("<h1>Message count : " +messageFacade.count()+ "</h1>");
            
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
