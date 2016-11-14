/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upsay.directory.entity;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author mccstan, slimani
 */
@Entity
public class FinalManagerUser extends AbstractFinalUser implements Serializable {
    
    private String type;

    public FinalManagerUser() {
        super();
    }
    
    public FinalManagerUser(String username, String password) {
        super(username, password);
    }
    
    public FinalManagerUser(String username, String password, String type) {
        super(username, password);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    

    
}
