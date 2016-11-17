/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upsay.mailbox.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author mccstan, slimani
 */
@Entity
/*@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_BOX")*/
public abstract class AbstractBox implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Message> allMessages;

    public AbstractBox() {
        this.allMessages = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Message> getAllMessages() {
        return allMessages;
    }

    public void setAllMessages(List<Message> allMessages) {
        this.allMessages = allMessages;
    }
    
     
    public  boolean addMessage(Message message){
        this.allMessages.add(message);
        return true;
    }
    
    public  boolean  deleteAMessage(Message message){
        this.allMessages.remove(message);
        return true;
    }
    public  boolean  deleteReadMessages(){
        allMessages.stream().filter((m) -> (m.isRead()==true)).forEachOrdered((m) -> {
            this.allMessages.remove(m);
        });
        return true;
    }
    
    public  boolean  deleteAllMessages(){
        this.allMessages.clear();
        return true;
    }
    
    public  List<Message>  readNewMessages(){
       List<Message> newMessages = this.allMessages;
        allMessages.stream().filter((m) -> (m.isRead()==true)).forEachOrdered((m) -> {
            this.allMessages.remove(m);
        });
       return newMessages;
    }   
    
    public  List<Message>  readAllMessages(){
        return this.allMessages;
    }
    
    
}
