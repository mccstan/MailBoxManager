/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upsay.ejb;

import java.util.List;
import javax.ejb.Remote;
import javax.persistence.EntityManager;

/**
 *
 * @author mccstan
 */
@Remote
public interface AbstractFacadeRemote<T> {
    abstract EntityManager getEntityManager();
    public void create(T entity);
    public void edit(T entity);
    public void remove(T entity);
    public T find(Object id);
    public List<T> findAll();
    public List<T> findRange(int[] range);
    public int count() ;
}
