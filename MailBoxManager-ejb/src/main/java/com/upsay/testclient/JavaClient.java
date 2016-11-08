/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upsay.testclient;

import com.upsay.facade.MessageFacade;
import com.upsay.mailbox.entity.Message;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author mccstan
 */
public class JavaClient {

    MessageFacade messageFacade;

    public JavaClient() {
        messageFacade = lookupMessageFacadeBean();
    }

    private   MessageFacade lookupMessageFacadeBean() {
        try {
            Hashtable ht=new Hashtable();
		ht.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		ht.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
		ht.put("java.naming.provider.url", "localhost:8080");
            Context c = new InitialContext(ht);
            return (MessageFacade) c.lookup("messageFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    public static  void main(String[] args){
        
        Message message = new Message("Subject", "body");
        JavaClient jc =new JavaClient();
        jc.lookupMessageFacadeBean();
        jc.messageFacade.create(message);
        
    }
    
}
