/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upsay.ejb;

import fr.upsay.directory.entity.FinalMailBoxUser;
import fr.upsay.iejb.AbstractFacadeRemote;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mccstan
 */
@Stateless(mappedName = "finalMailBoxUserFacade")
@Remote(AbstractFacadeRemote.class)
public class FinalMailBoxUserFacade extends AbstractFacade<FinalMailBoxUser> {

    @PersistenceContext(unitName = "MailBoxPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public FinalMailBoxUserFacade() {
        super(FinalMailBoxUser.class);
    }
}
