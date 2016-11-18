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
 * @author slimani
 */
@WebServlet(name = "Test3", urlPatterns = {"/Test3"})
public class Test3 extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            
            //recuperation d'un user
            List<FinalMailBoxUser> boxUsers = directoryManager.lookupAllUsers();
            FinalMailBoxUser u1 = boxUsers.get(0);
            
            Message m = new Message("subject news" , "body news");
            
            System.out.println(mailBoxManager.sendNews(u1, m));
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Test3</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Envoi d'un message à la newsBox</h3>");
            
            out.println("<ul style=\"list-style-type:disc\">");
            out.println("<li>id = "+u1.getId()+"</li>");
            out.println("<li>UserName = "+u1.getUsername()+"</li>");
            out.println("<li>PassWord = "+u1.getPassword()+"</li>");
            out.println("<li>mailBoxName = "+u1.getMailBox().getMailBoxName()+"</li>");
            out.println("<li>Droit en Lecture = "+u1.getNewsGroupRight().getReadAccess()+"</li>");
            out.println("<li>Droit en Ecriture = "+u1.getNewsGroupRight().getWriteAccess()+"</li>");
            out.println("</ul>");
            
            out.println("User1 ---> NewsBox : m = \"subject news\" , \"body news\"</br></br>");
            out.println("Réponse du MailBoxManager : "+mailBoxManager.sendNews(u1, m)+"</br>");
            
            out.println("<h3>Changement des droits pour l'utilisateur</h3>");
            u1.getNewsGroupRight().setWriteAccess();
            finalMailBoxUserFacade.edit(u1);
            
            out.println("<ul style=\"list-style-type:disc\">");
            out.println("<li>id = "+u1.getId()+"</li>");
            out.println("<li>UserName = "+u1.getUsername()+"</li>");
            out.println("<li>PassWord = "+u1.getPassword()+"</li>");
            out.println("<li>mailBoxName = "+u1.getMailBox().getMailBoxName()+"</li>");
            out.println("<li>Droit en Lecture = "+u1.getNewsGroupRight().getReadAccess()+"</li>");
            out.println("<li>Droit en Ecriture = "+u1.getNewsGroupRight().getWriteAccess()+"</li>");
            out.println("</ul>");
            
            out.println("<h3>Renvoi du message à la NewsBox</h3>");
            
            out.println("Réponse du MailBoxManager : "+mailBoxManager.sendNews(u1, m)+"</br>");
            out.println("<h3>Affichage des Messages User1</h3>");
            List<FinalMailBoxUser> list = directoryManager.lookupAllUsers();
            FinalMailBoxUser user1 = boxUsers.get(0);
            FinalMailBoxUser user2 = boxUsers.get(1);
            List<Message> listMessag2 = mailBoxManager.readAUserAllMessages(user2);
            List<Message> listMessag1 = mailBoxManager.readAUserAllMessages(user1);
            
            out.println("<ul style=\"list-style-type:disc\">");
            for(Message message : listMessag1){
                out.println("<li> id = "+message.getId()+"</li>");
                out.println("<li> subject = " +message.getSubject()+"</li>");
                out.println("<li> body = "+message.getBody()+"</li>");
                out.println("</br>");
                
            }
            out.println("</ul>");
            
            out.println("<h3>Affichage des Messages User2</h3>");
            out.println("<ul style=\"list-style-type:disc\">");
            for(Message message : listMessag2){
                out.println("<li> id = "+message.getId()+"</li>");
                out.println("<li> subject = " +message.getSubject()+"</li>");
                out.println("<li> body = "+message.getBody()+"</li>");
                out.println("</br>");
            }
            
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
