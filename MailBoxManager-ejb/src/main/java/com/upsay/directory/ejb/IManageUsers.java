/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upsay.directory.ejb;

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