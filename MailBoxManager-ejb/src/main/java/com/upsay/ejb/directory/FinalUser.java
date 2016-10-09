/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upsay.ejb.directory;

import java.io.Serializable;
import java.lang.reflect.Array;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author mccstan
 */
@Entity
public class FinalUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String username;
    
    @OneToOne
    private NewsGroupRight newsGroupRight;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    public NewsGroupRight getUserRight(){
        return this.newsGroupRight;
    }
    public void updateUserRight(NewsGroupRight newsGroupRight){
        this.newsGroupRight = newsGroupRight;
    }
    
}
