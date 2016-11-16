/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upsay.mailbox.entity;

import fr.upsay.directory.entity.FinalMailBoxUser;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;


/**
 *
 * @author mccstan, slimani
 */
@Entity
public class MailBox  extends AbstractBox implements Serializable{
    
    @OneToOne(cascade = CascadeType.PERSIST)
    private FinalMailBoxUser owner;
    
    private String mailBoxName;

    public MailBox() {
    }
    

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
