/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upsay.iejb;

import fr.upsay.directory.entity.AbstractFinalUser;
import fr.upsay.directory.entity.FinalMailBoxUser;
import fr.upsay.mailbox.entity.NewsGroupRight;
import java.util.List;

/**
 *
 * @author mccstan
 */
public interface IManageUsers {
    
    public boolean addUser(FinalMailBoxUser finalUser);
    public boolean removeUser(FinalMailBoxUser finalUser);
    public List<FinalMailBoxUser> lookupAllUsers();
    public NewsGroupRight lookupAUserRights( FinalMailBoxUser finalMailBoxUser);
    public boolean updateAUserRights(FinalMailBoxUser finalUser, NewsGroupRight newsGroupRight);
}
