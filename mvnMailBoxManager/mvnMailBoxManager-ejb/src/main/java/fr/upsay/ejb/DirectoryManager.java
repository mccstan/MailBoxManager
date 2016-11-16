/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upsay.ejb;

import fr.upsay.directory.entity.AbstractFinalUser;
import fr.upsay.directory.entity.FinalMailBoxUser;
import fr.upsay.iejb.AbstractFacadeRemote;
import fr.upsay.iejb.IManageUsers;
import fr.upsay.mailbox.entity.MailBox;
import fr.upsay.mailbox.entity.NewsGroupRight;
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
@Remote(IManageUsers.class)
public class DirectoryManager implements IManageUsers{
    
    @Resource(mappedName = "mailBoxFacade")
    AbstractFacadeRemote mailBoxFacade;
    
    @Resource(mappedName = "finalMailBoxUserFacade")
    AbstractFacadeRemote finalMailBoxUserFacade;

    @Override
    public boolean addUser(FinalMailBoxUser finalUser) {
        NewsGroupRight groupRight = new NewsGroupRight(true, false);
        finalUser.updateUserRight(groupRight);
        MailBox mailBox = new MailBox(finalUser, finalUser.getUsername()+"MainBox");
        mailBoxFacade.create(mailBox);
        return true;
    }

    @Override
    public boolean removeUser(FinalMailBoxUser finalUser) {
        finalMailBoxUserFacade.remove(finalUser);
        return true;
    }

    @Override
    public List<AbstractFinalUser> lookupAllUsers() {
        return finalMailBoxUserFacade.findAll();
    }

    @Override
    public NewsGroupRight lookupAUserRights(FinalMailBoxUser finalUser) {
        return finalUser.getNewsGroupRight();
    }

    @Override
    public boolean updateAUserRights(FinalMailBoxUser finalUser, NewsGroupRight newsGroupRight) {
        finalUser.updateUserRight(newsGroupRight);
        return true;
    }
}
