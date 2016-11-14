/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upsay.ejb;

import fr.upsay.iejb.MySessionBeanRemote;
import javax.ejb.Stateless;

/**
 *
 * @author mccstan
 */
@Stateless
public class MySessionBean implements MySessionBeanRemote {

    @Override
    public String getResult() {
        return "This my BEAN";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
