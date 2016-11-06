package com.upsay.dao;

import com.upsay.dao.JsfUtil.PersistAction;
import com.upsay.directory.entity.FinalMailBoxUser;
import com.upsay.facade.NewsGroupRightFacade;
import com.upsay.mailbox.entity.NewsGroupRight;


import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("newsGroupRightController")
@SessionScoped
public class NewsGroupRightDAO implements Serializable {

    @EJB
    private com.upsay.facade.NewsGroupRightFacade ejbFacade;
    private List<NewsGroupRight> items = null;
    private NewsGroupRight selected;

    public NewsGroupRightDAO() {
    }

    public NewsGroupRight getSelected() {
        return selected;
    }

    public void setSelected(NewsGroupRight selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private NewsGroupRightFacade getFacade() {
        return ejbFacade;
    }

    public NewsGroupRight prepareCreate() {
        selected = new NewsGroupRight();
        initializeEmbeddableKey();
        return selected;
    }
    public void create() {
        persist(PersistAction.CREATE);
        items = null;    // Invalidate list of items to trigger re-query.
    }

    public void update() {
        persist(PersistAction.UPDATE);
    }

    public void destroy() {
        persist(PersistAction.DELETE);
        selected = null; // Remove selection
        items = null;    // Invalidate list of items to trigger re-query.
    }

    public List<NewsGroupRight> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public NewsGroupRight getNewsGroupRight(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<NewsGroupRight> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<NewsGroupRight> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = NewsGroupRight.class)
    public static class NewsGroupRightControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            NewsGroupRightDAO controller = (NewsGroupRightDAO) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "newsGroupRightController");
            return controller.getNewsGroupRight(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof NewsGroupRight) {
                NewsGroupRight o = (NewsGroupRight) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), NewsGroupRight.class.getName()});
                return null;
            }
        }

    }

}
