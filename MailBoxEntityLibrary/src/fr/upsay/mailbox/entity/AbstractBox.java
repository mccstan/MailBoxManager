/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upsay.mailbox.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

/**
 *
 * @author mccstan, slimani
 */
@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_BOX")
public abstract class AbstractBox implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToMany
    private Map<Long, Message> allMessages;

    public AbstractBox() {
        this.allMessages = new HashMap<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<Long, Message> getAllMessages() {
        return allMessages;
    }

    public void setAllMessages(Map<Long, Message> allMessages) {
        this.allMessages = allMessages;
    }
    
     
    public  boolean addMessage(Message message){
        this.allMessages.put(message.getId(), message);
        return true;
    }
    
    public  boolean  deleteAMessage(Message message){
        this.allMessages.remove(message.getId(),message);
        return true;
    }
    public  boolean  deleteReadMessages(){
        for(Map.Entry<Long, Message> entry : this.allMessages.entrySet()) {
             Long key = entry.getKey();
             Message value = entry.getValue();
             if(value.isRead()==true){
                 this.allMessages.remove(key);
             }
        }
        return true;
    }
    
    public  boolean  deleteAllMessages(){
        this.allMessages.clear();
        return true;
    }
    
    public  Map<Long, Message>  readNewMessages(){
       Map<Long,Message> newMessages = this.allMessages;
       for(Entry<Long, Message> entry : this.allMessages.entrySet()) {
             Long key = entry.getKey();
             Message value = entry.getValue();
             if(value.isRead()==true){
                 newMessages.remove(key);
             }
        }
       return newMessages;
    }   
    
    public  Map<Long, Message>  readAllMessages(){
        return this.allMessages;
    }
    
    
}
