package com.upsay.dao;

import com.upsay.dao.JsfUtil.PersistAction;
import com.upsay.directory.entity.FinalMailBoxUser;
import com.upsay.facade.FinalMailBoxUserFacade;


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

@Named("finalMailBoxUserController")
@SessionScoped
public class FinalMailBoxUserDAO implements Serializable {

    @EJB
    private com.upsay.facade.FinalMailBoxUserFacade ejbFacade;
    private List<FinalMailBoxUser> items = null;
    private FinalMailBoxUser selected;

    public FinalMailBoxUserDAO() {
    }

    public FinalMailBoxUser getSelected() {
        return selected;
    }

    public void setSelected(FinalMailBoxUser selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private FinalMailBoxUserFacade getFacade() {
        return ejbFacade;
    }

    public FinalMailBoxUser prepareCreate() {
        selected = new FinalMailBoxUser();
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

    public List<FinalMailBoxUser> getItems() {
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

    public FinalMailBoxUser getFinalMailBoxUser(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<FinalMailBoxUser> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<FinalMailBoxUser> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = FinalMailBoxUser.class)
    public static class FinalMailBoxUserControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FinalMailBoxUserDAO controller = (FinalMailBoxUserDAO) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "finalMailBoxUserController");
            return controller.getFinalMailBoxUser(getKey(value));
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
            if (object instanceof FinalMailBoxUser) {
                FinalMailBoxUser o = (FinalMailBoxUser) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), FinalMailBoxUser.class.getName()});
                return null;
            }
        }

    }

}
