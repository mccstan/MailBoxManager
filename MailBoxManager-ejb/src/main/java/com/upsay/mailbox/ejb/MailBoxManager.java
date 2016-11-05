/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upsay.mailbox.ejb;
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

//import entity.*;
import java.time.LocalDate;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author mccstan
 */


@Stateless(name = "com.upsay.mailbox.ejb/IMailBoxManager")
public class MailBoxManager implements IMailBoxManager {

    @PersistenceContext(unitName = "pu1")
    private EntityManager em;
    private ArrayList<MailBox> mailBoxes;
    private ArrayList<MailBox> newsBoxes;

    private static final String JPQL_SELECT_MAILBOX = "SELECT m FROM MailBox m WHERE u.id=:id";

    @Override
    public Map<Long, Message> readAUserNewMessages(FinalMailBoxUser user) {
        MailBox m = null;
        Query q = em.createQuery(JPQL_SELECT_MAILBOX);
        q.setParameter("id", user.getId());
        m = (MailBox) q.getSingleResult();
        return m.readNewMessages();
    }

    @Override
    public Map<Long, Message> readAUserAllMessages(FinalMailBoxUser user) {
        MailBox m = null;
        Query q = em.createQuery(JPQL_SELECT_MAILBOX);
        q.setParameter("id", user.getId());
        m = (MailBox) q.getSingleResult();
        return m.readAllMessages();
    }

    @Override
    public boolean deleteAUserMessage(FinalMailBoxUser user, Message message) {
        MailBox m = null;
        Query q = em.createQuery(JPQL_SELECT_MAILBOX);
        q.setParameter("id", user.getId());
        m = (MailBox) q.getSingleResult();
        m.deleteAMessage(message);
        return true;

    }

    @Override
    public void deleteAUserReadMessages() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendAMessageToABox(FinalMailBoxUser recever , Message message) {
        MailBox m = null;
        Query q = em.createQuery(JPQL_SELECT_MAILBOX);
        q.setParameter("id", recever.getId());
        m = (MailBox) q.getSingleResult();
        message.setIsRead(false);
        message.setSendingDate(LocalDate.now());
        m.addMessage(message);
    }

    @Override
    public void addUser(FinalMailBoxUser user, String mailBoxName) {
        MailBox mailBox = new MailBox(user, mailBoxName);
        em.persist(mailBox);
        this.mailBoxes.add(mailBox);
    }

    @Override
    public boolean removeUser(FinalMailBoxUser user) {
        MailBox m = null;
        Query q = em.createQuery(JPQL_SELECT_MAILBOX);
        q.setParameter("id", user.getId());
        m = (MailBox) q.getSingleResult();
        FinalMailBoxUser u = em.merge(user);
        em.remove(u);
        this.mailBoxes.remove(user);
        return false;
    }

    @Override
    public void sendNews() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
