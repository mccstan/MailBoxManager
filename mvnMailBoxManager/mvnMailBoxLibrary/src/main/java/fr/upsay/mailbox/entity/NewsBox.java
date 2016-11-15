/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upsay.mailbox.entity;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author mccstan, slimani
 */
@Entity
public class NewsBox  extends AbstractBox implements Serializable{
    private static final long serialVersionUID = 1L;
    public static enum newsBoxTypes {BROADCAST, MULTICAST};    
    private String newsBoxName;
    private String newsBoxType;

    public String getNewsBoxName() {
        return newsBoxName;
    }

    public void setNewsBoxName(String newsBoxName) {
        this.newsBoxName = newsBoxName;
    }

    public String getNewsBoxType() {
        return newsBoxType;
    }

    public void setNewsBoxType(String newsBoxType) {
        this.newsBoxType = newsBoxType;
    }
    
    
    public NewsBox() {
        super();
        this.newsBoxType = NewsBox.newsBoxTypes.BROADCAST.name();
    }
    
    public NewsBox(String name, String type) {
        super();
        this.newsBoxName = name;
        this.newsBoxType = type;
    }
    
}
