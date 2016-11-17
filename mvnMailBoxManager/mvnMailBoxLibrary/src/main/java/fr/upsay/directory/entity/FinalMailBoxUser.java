/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upsay.directory.entity;

import fr.upsay.mailbox.entity.MailBox;
import fr.upsay.mailbox.entity.NewsGroupRight;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author mccstan, slimani
 */
@Entity
public class FinalMailBoxUser extends AbstractFinalUser implements Serializable {
   
    @ManyToOne(cascade = CascadeType.PERSIST)
    private NewsGroupRight newsGroupRight;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    private MailBox mailBox;

    

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

    public NewsGroupRight getNewsGroupRight() {
        return newsGroupRight;
    }

    public MailBox getMailBox() {
        return mailBox;
    }
    
    public void setMailBox(MailBox mailBox) {
        this.mailBox = mailBox;
    }
    
}
