/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upsay.ejb;

import fr.upsay.directory.entity.FinalManagerUser;
import fr.upsay.iejb.AbstractFacadeRemote;
import fr.upsay.mailbox.entity.NewsGroupRight;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mccstan, slimani
 */
@Stateless(mappedName = "newsGroupRightFacade")
@Remote(AbstractFacadeRemote.class)
public class NewsGroupRightFacade extends AbstractFacade<NewsGroupRight> {

    @PersistenceContext(unitName = "MailBoxPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public NewsGroupRightFacade() {
        super(NewsGroupRight.class);
    }
}
