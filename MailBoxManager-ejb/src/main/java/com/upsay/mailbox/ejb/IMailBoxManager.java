/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upsay.mailbox.ejb;

/**
 *
 * @author mccstan
 * Mail Box Manager Interface.
 */
public interface IMailBoxManager {
    
    
    public void readAUserNewMessages();
    public void readAUserAllMessages();
    public boolean deleteAUserMessage();
    public void deleteAUserReadMessages();
    public void sendAMessageToABox();
    public void addUser();
    public boolean removeUser();
    public void sendNews();
    
}
