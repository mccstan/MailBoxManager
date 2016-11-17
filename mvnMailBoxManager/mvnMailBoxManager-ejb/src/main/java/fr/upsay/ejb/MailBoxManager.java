/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upsay.ejb;
import fr.upsay.directory.entity.FinalMailBoxUser;
import fr.upsay.iejb.AbstractFacadeRemote;
import fr.upsay.iejb.IMailBoxManager;
import fr.upsay.iejb.IManageUsers;
import fr.upsay.mailbox.entity.MailBox;
import fr.upsay.mailbox.entity.Message;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author mccstan, slimani
 */

@Stateless(mappedName = "mailBoxManager")
@Remote(IMailBoxManager.class)
public class MailBoxManager implements IMailBoxManager {
    private List<FinalMailBoxUser> boxUsers;
    private ArrayList<MailBox> mailBoxes;

    @Resource(mappedName = "finalMailBoxUserFacade")
    AbstractFacadeRemote finalMailBoxUserFacade;
    
    @Resource(mappedName = "directoryManager")
    IManageUsers directoryManager;

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
         MailBox box = userf.getMailBox();
         box.deleteAMessage(message);
         mailBoxFacade.edit(box);
        return true ;
    }


    @Override
    public void sendAMessageToABox(FinalMailBoxUser sender, FinalMailBoxUser receiver, Message message) {
        message.setSenderName(sender.getUsername());
        message.setReceiverName(receiver.getUsername());
        message.setSendingDate(LocalDate.now());
        message.setIsRead(false);
        
        MailBox box = receiver.getMailBox();
        
        box.addMessage(message);
        
        mailBoxFacade.edit(box);
        finalMailBoxUserFacade.edit(receiver);
        
        
        
       
        
    }

    @Override
    public void deleteAUserReadMessages(FinalMailBoxUser user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String sendNews(FinalMailBoxUser sender, Message message) {
        FinalMailBoxUser userf = (FinalMailBoxUser) finalMailBoxUserFacade.find(sender.getId());
        System.out.println(sender.getUserRight().getWriteAccess());
        if(sender.getUserRight().getWriteAccess()==true){
        this.boxUsers =  finalMailBoxUserFacade.findAll();
        message.setSenderName(sender.getUsername());
        message.setReceiverName("NewsBox");
        message.setSendingDate(LocalDate.now());
        for(FinalMailBoxUser user:this.boxUsers){
            MailBox box = user.getMailBox();
            box.addMessage(message);
            mailBoxFacade.edit(box);   
        }
        return "Message envoyé";
        }
        return "Accés refusé";
    }
}
