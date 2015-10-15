package org.vidyq.client;


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Clase utilizada por las clases QClase para comprobar que los campos coincidan
 * con los de la clase. Se ignoran los campos staticos y serialVersionUID
 * 
 * @author ggefaell
 *
 */
public class QChecker {

	public static void checkQ(Object qObject, Class dtoClazz) {
		for (Field field : qObject.getClass().getDeclaredFields()) {
			if (Modifier.isStatic(field.getModifiers())) {
				continue;
			}
			field.setAccessible(true);
			ClientQueryField queryField;
			try {
				queryField = (ClientQueryField) field.get(qObject);
				Field dtoField = dtoClazz.getDeclaredField(field.getName());
				if (!queryField.getType().equals(dtoField.getType())) {
					throw new RuntimeException("CAMPOS NO CONCIDEN EN CLASES: ".concat(qObject.getClass().getSimpleName()).concat(" ").concat(dtoClazz.getSimpleName()));
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
