/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upsay.iejb;

import fr.upsay.directory.entity.FinalMailBoxUser;
import fr.upsay.mailbox.entity.Message;
import java.util.List;

/**
 *
 * @author mccstan, slimani
 * Mail Box Manager Interface.
 */
public interface IMailBoxManager {
    
    
    public List<Message> readAUserNewMessages(FinalMailBoxUser user);
    public List<Message> readAUserAllMessages(FinalMailBoxUser user);
    public boolean deleteAUserMessage(FinalMailBoxUser user ,Message message);
    public void deleteAUserReadMessages(FinalMailBoxUser user);
    public void sendAMessageToABox(FinalMailBoxUser sender, FinalMailBoxUser receiver ,Message message);
    public String sendNews(FinalMailBoxUser sender, Message message);
    
}
