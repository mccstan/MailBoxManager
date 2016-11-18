/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upsay.servlet;

import fr.upsay.directory.entity.FinalMailBoxUser;
import fr.upsay.iejb.AbstractFacadeRemote;
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
 * @author mccstan, slimani
 */
@WebServlet(name = "MailBoxManagerSendToBox", urlPatterns = {"/mmsendtobox"})
public class MailBoxManagerSendToBox extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Resource(mappedName = "mailBoxFacade")
    AbstractFacadeRemote mailBoxFacade;
    
    @Resource(mappedName = "finalMailBoxUserFacade")
    AbstractFacadeRemote finalMailBoxUserFacade;
    
    @Resource(mappedName = "mailBoxManager")
     IMailBoxManager mailBoxManager;
    
    @Resource(mappedName = "directoryManager")
    IManageUsers directoryManager;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         
            //recuperation des deux usres
         List<FinalMailBoxUser> boxUsers = directoryManager.lookupAllUsers();
         FinalMailBoxUser user1 = boxUsers.get(0);
         FinalMailBoxUser user2 = boxUsers.get(1);
         
         //creation des messages à envoyer
        Message m1 = new Message ("subject1","body1");
        Message m2 = new Message ("subject2","body2");
        Message m3 = new Message ("subject3","body3");
        Message m4 = new Message ("subject4","body4");
        
        //envoi de messages entre les utilisateur
        mailBoxManager.sendAMessageToABox(user1, user2, m1);
        mailBoxManager.sendAMessageToABox(user1, user2, m2);
        
        mailBoxManager.sendAMessageToABox(user2, user1, m3);
        mailBoxManager.sendAMessageToABox(user2, user1, m4);
        
        //recuperation de la liste des messages pour chaque utilisateur
       List<Message> listMessag2 = mailBoxManager.readAUserAllMessages(user2);
       List<Message> listMessag1 = mailBoxManager.readAUserAllMessages(user1);
         System.out.println("la taille 1 "+listMessag1.size());
         System.out.println("la taille 2 "+listMessag2.size());
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>MailBox Manager Box</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>1- Envoi des message entre utilisateurs</h3>");
            out.println("User1 ---> User2 : m1 = (\"subject1\",\"body1\") | m2 = (\"subject2\",\"body2\")</br>");
            out.println("User2 ---> User1 : m3 = (\"subject3\",\"body3\") | m4 = (\"subject4\",\"body4\")");
            
            out.println("<h3>2- Recuperation de la base de données les message pour chaque utilisateur</h3>");
           
            out.println("<ul style=\"list-style-type:disc\">");
            out.println("<li>Id = "+listMessag1.get(0).getId()+"</li>");
            out.println("<li>subject = "+listMessag1.get(0).getSubject()+"</li>");
            out.println("<li>ReceiverName = "+listMessag1.get(0).getReceiverName()+"</li>");
            out.println("<li>SenderName = "+listMessag1.get(0).getSenderName()+"</li>");
            out.println("<li>Body = "+listMessag1.get(0).getBody()+"</li>");
            out.println("<li>SendingDate = "+listMessag1.get(0).getSendingDate()+"</li>");
            out.println("</ul>");
            
            out.println("<ul style=\"list-style-type:disc\">");
            out.println("<li>Id = "+listMessag1.get(1).getId()+"</li>");
            out.println("<li>subject = "+listMessag1.get(1).getSubject()+"</li>");
            out.println("<li>ReceiverName = "+listMessag1.get(1).getReceiverName()+"</li>");
            out.println("<li>SenderName = "+listMessag1.get(1).getSenderName()+"</li>");
            out.println("<li>Body = "+listMessag1.get(1).getBody()+"</li>");
            out.println("<li>SendingDate = "+listMessag1.get(1).getSendingDate()+"</li>");
            out.println("</ul>");
            
            out.println("<ul style=\"list-style-type:disc\">");
            out.println("<li>Id = "+listMessag2.get(1).getId()+"</li>");
            out.println("<li>subject = "+listMessag2.get(1).getSubject()+"</li>");
            out.println("<li>ReceiverName = "+listMessag2.get(1).getReceiverName()+"</li>");
            out.println("<li>SenderName = "+listMessag2.get(1).getSenderName()+"</li>");
            out.println("<li>Body = "+listMessag2.get(1).getBody()+"</li>");
            out.println("<li>SendingDate = "+listMessag2.get(1).getSendingDate()+"</li>");
            out.println("</ul>");
            
            out.println("<ul style=\"list-style-type:disc\">");
            out.println("<li>Id = "+listMessag2.get(0).getId()+"</li>");
            out.println("<li>subject = "+listMessag2.get(0).getSubject()+"</li>");
            out.println("<li>ReceiverName = "+listMessag2.get(0).getReceiverName()+"</li>");
            out.println("<li>SenderName = "+listMessag2.get(0).getSenderName()+"</li>");
            out.println("<li>Body = "+listMessag2.get(0).getBody()+"</li>");
            out.println("<li>SendingDate = "+listMessag2.get(0).getSendingDate()+"</li>");
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
