/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upsay.mailbox.ejb;

import com.upsay.directory.entity.FinalMailBoxUser;
import com.upsay.mailbox.entity.MailBox;
import com.upsay.mailbox.entity.Message;
import java.util.Map;

/**
 *
 * @author mccstan
 * Mail Box Manager Interface.
 */
public interface IMailBoxManager {
    
    
    public Map<Long,Message> readAUserNewMessages(MailBox mailBox);
    public Map<Long,Message> readAUserAllMessages(MailBox mailBox);
    public boolean deleteAUserMessage();
    public void deleteAUserReadMessages();
    public void sendAMessageToABox();
    public void addUser(FinalMailBoxUser user , String mailBoxName);
    public boolean removeUser();
    public void sendNews();
    
}
