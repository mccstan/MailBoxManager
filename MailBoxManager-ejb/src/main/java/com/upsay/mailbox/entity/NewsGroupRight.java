/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upsay.mailbox.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author mccstan
 */
@Entity
public class NewsGroupRight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private boolean readNewsGroup;
    private boolean writeNewsGroup;

    public NewsGroupRight(boolean readNewsGroup, boolean writeNewsGroup) {
        this.readNewsGroup = readNewsGroup;
        this.writeNewsGroup = writeNewsGroup;
    }
    
    
    
    
    public boolean getReadAccess(){
        return this.readNewsGroup;
    }
    public void setReadAccess(){
        this.readNewsGroup = true;
    }
    public void unsetReadAccess(){
        this.readNewsGroup = false;
    }
    
    public boolean getWriteAccess(){
        return this.writeNewsGroup;
    }
    public void setWriteAccess(){
        this.writeNewsGroup = true;
    }
    public void unsetWriteAccess(){
        this.writeNewsGroup = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.readNewsGroup ? 1 : 0);
        hash = 89 * hash + (this.writeNewsGroup ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NewsGroupRight other = (NewsGroupRight) obj;
        
        if (this.readNewsGroup != other.readNewsGroup) {
            return false;
        }
        return this.writeNewsGroup == other.writeNewsGroup;
    }
    
    
    
    
}
