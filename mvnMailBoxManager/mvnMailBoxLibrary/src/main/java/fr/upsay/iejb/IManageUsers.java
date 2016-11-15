/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upsay.iejb;

/**
 *
 * @author mccstan
 */
public interface IManageUsers {
    
    public void addUser();
    public boolean removeUser();
    public void lookupAllUsers();
    public void lookupAUserRights();
    public void updateAUserRights();
}
