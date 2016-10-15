package org.learn.bookpub.utils;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class CopyBeanValues {

	public static <T> T copyBeanValues(Object sourceObj, T t) {
		try {
			BeanUtils.copyProperties(t, sourceObj);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}	
		return t;
	}
}
