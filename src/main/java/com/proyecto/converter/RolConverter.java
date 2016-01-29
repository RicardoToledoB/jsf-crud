package com.proyecto.converter;

import com.proyecto.model.Rol;
import com.proyecto.service.RolService;
import com.proyecto.service.RolServiceImpl;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(value="rolConverter")
public class RolConverter implements Converter{
    @Inject private RolServiceImpl rService;
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return rService.findById(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Rol rol = (Rol) value;
        return String.valueOf(rol.getId());
        
    }

  
    
}
