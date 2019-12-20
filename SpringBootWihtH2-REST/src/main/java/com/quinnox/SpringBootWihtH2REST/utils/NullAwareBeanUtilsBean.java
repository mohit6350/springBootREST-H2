package com.quinnox.SpringBootWihtH2REST.utils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.stereotype.Component;



@Component
public class NullAwareBeanUtilsBean extends BeanUtilsBean{

	
	@Override
    public void copyProperty(Object dest, String name, Object value)
            throws IllegalAccessException, InvocationTargetException {
        if(value==null)return;
        super.copyProperty(dest, name, value);
    }
	
	@Override
    public void copyProperties(Object dest,  Object value)
            throws IllegalAccessException, InvocationTargetException {
        if(value==null)return;
        super.copyProperties(dest, value);
    }
}
