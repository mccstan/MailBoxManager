/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upsay.mailbox.ejb;
package com.upsay.mailbox.entity;

import com.upsay.directory.entity.FinalMailBoxUser;
import com.upsay.mailbox.entity.MailBox;
import com.upsay.mailbox.entity.Message;
import java.util.ArrayList;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.Collection;
import java.util.List;

import entity.*;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author mccstan
 */
@Stateless(name="com.upsay.mailbox.ejb/IMailBoxManager")
public class MailBoxManager implements IMailBoxManager{
    @PersistenceContext(unitName="pu1")
    private EntityManager em;
    private ArrayList<MailBox> mailBoxes;
    private ArrayList<MailBox> newsBoxes;
    
    private static final String JPQL_SELECT_MAILBOX = "SELECT m FROM MailBox m WHERE u.id=:id";

    @Override
    public Map<Long, Message> readAUserNewMessages(MailBox mailBox) {
        MailBox m = null;
        Query q = em.createQuery( JPQL_SELECT_MAILBOX );
        q.setParameter("id",mailBox.getId());
        m = (MailBox) q.getSingleResult();
        return m.readNewMessages();
        
        
    }

    @Override
    public Map<Long,Message> readAUserAllMessages(MailBox mailBox) {
        MailBox m = null;
        Query q = em.createQuery( JPQL_SELECT_MAILBOX );
        q.setParameter( "id", mailBox.getId());
        m = (MailBox) q.getSingleResult();
        return m.readAllMessages();      
    }

    @Override
    public boolean deleteAUserMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAUserReadMessages() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendAMessageToABox() {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addUser(FinalMailBoxUser user , String mailBoxName) {
        MailBox mailBox = new MailBox(user , mailBoxName);
        em.persist(mailBox);
    }

    @Override
    public boolean removeUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendNews() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
