/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upsay.facade;

import com.upsay.directory.entity.FinalManagerUser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mccstan
 */
@Stateless
public class FinalManagerUserFacade extends AbstractFacade<FinalManagerUser> {

    @PersistenceContext(unitName = "MailBoxPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FinalManagerUserFacade() {
        super(FinalManagerUser.class);
    }
    
}
