/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upsay.ejb;
import fr.upsay.directory.entity.FinalMailBoxUser;
import fr.upsay.iejb.AbstractFacadeRemote;
import fr.upsay.iejb.IMailBoxManager;
import fr.upsay.mailbox.entity.MailBox;
import fr.upsay.mailbox.entity.Message;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author mccstan, slimani
 */

@Stateless(mappedName = "directoryManager")
@Remote(IMailBoxManager.class)
public class MailBoxManager implements IMailBoxManager {
    private ArrayList<FinalMailBoxUser> boxUsers;
    private ArrayList<MailBox> mailBoxes;

    @Resource(mappedName = "finalMailBoxUserFacade")
    AbstractFacadeRemote finalMailBoxUserFacade;

    @Resource(mappedName = "mailBoxFacade")
    AbstractFacadeRemote mailBoxFacade;

    @Override
    public List<Message> readAUserNewMessages(FinalMailBoxUser user) {
        FinalMailBoxUser userf = (FinalMailBoxUser) finalMailBoxUserFacade.find(user.getId());
        return userf.getMailBox().readNewMessages();
        
    }

    @Override
    public List<Message> readAUserAllMessages(FinalMailBoxUser user) {
        FinalMailBoxUser userf = (FinalMailBoxUser) finalMailBoxUserFacade.find(user.getId());
        return userf.getMailBox().getAllMessages();
    }

    @Override
    public boolean deleteAUserMessage(FinalMailBoxUser user, Message message) {
        FinalMailBoxUser userf = (FinalMailBoxUser) finalMailBoxUserFacade.find(user.getId());
        return userf.getMailBox().deleteAMessage(message);
        
    }


    @Override
    public void sendAMessageToABox(FinalMailBoxUser sender, FinalMailBoxUser receiver, Message message) {
        FinalMailBoxUser userf = (FinalMailBoxUser) finalMailBoxUserFacade.find(receiver.getId());
        userf.getMailBox().addMessage(message);
    }

    @Override
    public void deleteAUserReadMessages(FinalMailBoxUser user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendNews(FinalMailBoxUser sender, Message message) {
        this.boxUsers = (ArrayList<FinalMailBoxUser>) finalMailBoxUserFacade.findAll();
        message.setSenderName(sender.getUsername());
        message.setReceiverName("NewsBox");
        for(FinalMailBoxUser user:this.boxUsers){
            MailBox box = user.getMailBox();
            box.addMessage(message);
            mailBoxFacade.edit(box);
        }
    }
}
