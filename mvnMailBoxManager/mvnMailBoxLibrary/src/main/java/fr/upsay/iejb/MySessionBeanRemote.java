/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upsay.iejb;

import javax.ejb.Remote;

/**
 *
 * @author mccstan
 */
@Remote
public interface MySessionBeanRemote {

    String getResult();
    
}
