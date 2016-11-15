/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upsay.ejb;
import fr.upsay.directory.entity.FinalMailBoxUser;
import fr.upsay.iejb.AbstractFacadeRemote;
import fr.upsay.iejb.IMailBoxManager;
import fr.upsay.mailbox.entity.Message;
import java.util.Map;
import javax.annotation.Resource;
import javax.ejb.EJB;

/**
 *
 * @author mccstan, slimani
 */


public class MailBoxManager implements IMailBoxManager {

    @Resource(mappedName = "finalMailBoxUserFacade")
    AbstractFacadeRemote finalMailBoxUserFacade;

    @Override
    public Map<Long, Message> readAUserNewMessages(FinalMailBoxUser user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public Map<Long, Message> readAUserAllMessages(FinalMailBoxUser user) {
        FinalMailBoxUser userf = (FinalMailBoxUser) finalMailBoxUserFacade.find(user.getId());
        return userf.getMailBox().getAllMessages();
    }

    @Override
    public boolean deleteAUserMessage(FinalMailBoxUser usr, Message message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAUserReadMessages() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendAMessageToABox(FinalMailBoxUser recever, Message message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addUser(FinalMailBoxUser user, String mailBoxName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeUser(FinalMailBoxUser user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendNews() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   

}
