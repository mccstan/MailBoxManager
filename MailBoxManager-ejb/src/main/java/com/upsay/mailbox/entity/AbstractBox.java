/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upsay.mailbox.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/**
 *
 * @author mccstan
 */
@MappedSuperclass
public abstract class AbstractBox implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToMany(mappedBy="abstractBox")
    @MapKey(name="id")
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
        // TODO
        return true;
    }
    public  boolean  deleteReadMessages(){
        // TODO
        return true;
    }
    public  boolean  deleteAllMessages(){
        // TODO
        return true;
    }
    
    public  Map<Long, Message>  readNewMessages(){
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public  Map<Long, Message>  readAllMessages(){
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
