/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upsay.mailbox.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author mccstan
 */
@Entity
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Message() {
        id = 0L;
    }
    
    private String senderName; 
    private String receiverName;
    private LocalDate sendingDate;
    private String subject;
    private String body;
    private boolean isAlreadyRead;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public LocalDate getSendingDate() {
        return sendingDate;
    }

    public void setSendingDate(LocalDate sendingDate) {
        this.sendingDate = sendingDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isRead() {
        return isAlreadyRead;
    }

    public void setIsRead(boolean isAlreadyRead) {
        this.isAlreadyRead = isAlreadyRead;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.senderName);
        hash = 83 * hash + Objects.hashCode(this.receiverName);
        hash = 83 * hash + Objects.hashCode(this.sendingDate);
        hash = 83 * hash + Objects.hashCode(this.subject);
        hash = 83 * hash + Objects.hashCode(this.body);
        hash = 83 * hash + (this.isAlreadyRead ? 1 : 0);
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
        final Message other = (Message) obj;
        if (this.isAlreadyRead != other.isAlreadyRead) {
            return false;
        }
        if (!Objects.equals(this.senderName, other.senderName)) {
            return false;
        }
        if (!Objects.equals(this.receiverName, other.receiverName)) {
            return false;
        }
        if (!Objects.equals(this.subject, other.subject)) {
            return false;
        }
        if (!Objects.equals(this.body, other.body)) {
            return false;
        }
        return Objects.equals(this.sendingDate, other.sendingDate);
    }
    
    
    
}
