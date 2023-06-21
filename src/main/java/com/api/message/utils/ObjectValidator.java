package com.api.message.utils;

import java.lang.reflect.Field;

public class ObjectValidator {
    public static void validateObject(Object obj) {
        Class<?> clazz = obj.getClass();

        // Obter todos os campos declarados na classe, incluindo campos herdados
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            try {
                Object value = field.get(obj);

                if (value == null || (value instanceof String && ((String) value).isEmpty())) {
                    field.set(obj, ""); // Define o atributo como uma string vazia
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
