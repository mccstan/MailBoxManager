/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upsay.mailbox.ejb;

import com.upsay.directory.entity.FinalMailBoxUser;
import com.upsay.mailbox.entity.Message;
import java.util.Map;

/**
 *
 * @author mccstan, slimani
 * Mail Box Manager Interface.
 */
public interface IMailBoxManager {
    
    
    public Map<Long,Message> readAUserNewMessages(FinalMailBoxUser user);
    public Map<Long,Message> readAUserAllMessages(FinalMailBoxUser user);
    public boolean deleteAUserMessage(FinalMailBoxUser usr ,Message message);
    public void deleteAUserReadMessages();
    public void sendAMessageToABox(FinalMailBoxUser recever ,Message message);
    public void addUser(FinalMailBoxUser user , String mailBoxName);
    public boolean removeUser(FinalMailBoxUser user);
    public void sendNews();
    
}
