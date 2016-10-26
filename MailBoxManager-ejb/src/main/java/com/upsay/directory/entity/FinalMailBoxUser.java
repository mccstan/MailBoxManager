/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upsay.directory.entity;

import com.upsay.mailbox.entity.NewsGroupRight;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author mccstan
 */
@Entity
public class FinalMailBoxUser extends AbstractFinalUser implements Serializable {
   
    @OneToOne
    private NewsGroupRight newsGroupRight;

    public FinalMailBoxUser() {
        super();
    }

    public FinalMailBoxUser(String username, String password) {
        super(username, password);
    }
    
    public NewsGroupRight getUserRight(){
        return this.newsGroupRight;
    }
    public void updateUserRight(NewsGroupRight newsGroupRight){
        this.newsGroupRight = newsGroupRight;
    }
    
}
