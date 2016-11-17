/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upsay.mailbox.entity;

import java.io.Serializable;
import javax.persistence.Entity;


/**
 *
 * @author mccstan, slimani
 */
@Entity
public class MailBox  extends AbstractBox implements Serializable{
    
    private String owner;
    
    private String mailBoxName;

    public MailBox() {
        super();
    }
    

    public MailBox(String owner, String mailBoxName) {
        this.owner = owner;
        this.mailBoxName = mailBoxName;
    }
    
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getMailBoxName() {
        return mailBoxName;
    }

    public void setMailBoxName(String mailBoxName) {
        this.mailBoxName = mailBoxName;
    }
    
}
