/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upsay.mailbox.entity;

import com.upsay.directory.entity.FinalMailBoxUser;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.OneToOne;


/**
 *
 * @author mccstan
 */
public class MailBox  extends AbstractBox{
    
    @OneToOne
    private FinalMailBoxUser owner;
    private String mailBoxName;
    

    public MailBox(FinalMailBoxUser owner, String mailBoxName) {
        this.owner = owner;
        this.mailBoxName = mailBoxName;
    }
    
    public FinalMailBoxUser getOwner() {
        return owner;
    }

    public void setOwner(FinalMailBoxUser owner) {
        this.owner = owner;
    }

    public String getMailBoxName() {
        return mailBoxName;
    }

    public void setMailBoxName(String mailBoxName) {
        this.mailBoxName = mailBoxName;
    }
    
}
