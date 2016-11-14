/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upsay.client;

import fr.upsay.mailbox.entity.Message;
import javax.ejb.EJB;

/**
 *
 * @author mccstan
 */
public class Main {

    @EJB
    private static AbstractFacadeRemote messageFacade;

    @EJB
    private static MySessionBeanRemote mySessionBean;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Call : "+mySessionBean.getResult());
        Message message1 = new Message("subject1", "Body1");
        Message message2 = new Message("subject2", "Body2");
        Message message3 = new Message("subject3", "Body3");
        messageFacade.create(message1);
        messageFacade.create(message2);
        messageFacade.create(message3);
    }
    
}
