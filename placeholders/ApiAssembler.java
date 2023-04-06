/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.automatool.poc;

import java.lang.reflect.Field;
import org.springframework.stereotype.Component;


@Component
class ApiAssembler {
    
    public <T> T convertModelToResource(Object model, Class<T> ResourceClass) throws IllegalAccessException, InstantiationException {

        T resource = ResourceClass.newInstance();

        Field[] dtoFields = model.getClass().getDeclaredFields();

        Field[] modelFields = ResourceClass.getDeclaredFields();

        for (Field dtoField : dtoFields) {

            for (Field modelField : modelFields) {

                if (dtoField.getName().equals(modelField.getName())) {

                    dtoField.setAccessible(true);

                    modelField.setAccessible(true);

                    Object dtoFieldValue = dtoField.get(model);

                    if (dtoFieldValue != null) {

                        if (dtoField.getType().equals(modelField.getType())) {

                            modelField.set(model, dtoFieldValue);

                        } else {

                            Object nestedModel = convertModelToResource(dtoFieldValue, modelField.getType());

                            modelField.set(model, nestedModel);

                        }
                    }
                }
            }
        }
        return resource;
    }
    
}
