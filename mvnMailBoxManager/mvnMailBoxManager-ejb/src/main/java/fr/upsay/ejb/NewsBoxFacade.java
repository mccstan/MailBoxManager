/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upsay.ejb;

import fr.upsay.iejb.AbstractFacadeRemote;
import fr.upsay.mailbox.entity.NewsBox;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mccstan
 */
@Stateless(mappedName = "newsBoxFacade")
@Remote(AbstractFacadeRemote.class)
public class NewsBoxFacade extends AbstractFacade<NewsBox> {

    @PersistenceContext(unitName = "MailBoxPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public NewsBoxFacade() {
        super(NewsBox.class);
    }
}
