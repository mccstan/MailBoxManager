/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upsay.ejb.mailbox;

/**
 *
 * @author mccstan
 */
public interface IMailBox {
    public boolean  deleteAMessage();
    public boolean  deleteReadMessages();
    public boolean  deleteAllMessages();
    public void  readNewMessages();
    
}
