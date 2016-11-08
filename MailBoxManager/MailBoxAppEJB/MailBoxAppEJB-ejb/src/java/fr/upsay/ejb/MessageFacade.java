/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upsay.ejb;

import com.upsay.mailbox.entity.Message;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mccstan
 */
@Stateless
@Remote(AbstractFacadeRemote.class)
public class MessageFacade extends AbstractFacade<Message> {

    @PersistenceContext(unitName = "MailBoxPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public MessageFacade() {
        super(Message.class);
    }
}
