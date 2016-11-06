package com.upsay.dao;

import com.upsay.dao.JsfUtil.PersistAction;
import com.upsay.directory.entity.FinalMailBoxUser;
import com.upsay.directory.entity.FinalManagerUser;
import com.upsay.facade.FinalManagerUserFacade;

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

@Named("finalManagerUserController")
@SessionScoped
public class FinalManagerUserDAO implements Serializable {

    @EJB
    private com.upsay.facade.FinalManagerUserFacade ejbFacade;
    private List<FinalManagerUser> items = null;
    private FinalManagerUser selected;

    public FinalManagerUserDAO() {
    }

    public FinalManagerUser getSelected() {
        return selected;
    }

    public void setSelected(FinalManagerUser selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private FinalManagerUserFacade getFacade() {
        return ejbFacade;
    }

    public FinalManagerUser prepareCreate() {
        selected = new FinalManagerUser();
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

    public List<FinalManagerUser> getItems() {
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

    public FinalManagerUser getFinalManagerUser(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<FinalManagerUser> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<FinalManagerUser> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = FinalManagerUser.class)
    public static class FinalManagerUserControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FinalManagerUserDAO controller = (FinalManagerUserDAO) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "finalManagerUserController");
            return controller.getFinalManagerUser(getKey(value));
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
            if (object instanceof FinalManagerUser) {
                FinalManagerUser o = (FinalManagerUser) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), FinalManagerUser.class.getName()});
                return null;
            }
        }

    }

}
