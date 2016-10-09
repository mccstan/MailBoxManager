/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upsay.ejb.directory;

/**
 *
 * @author mccstan
 */
public class NewsGroupRight {
    
    private boolean readNewsGroup = false;
    private boolean writeNewsGroup = false;
    
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
    
}
