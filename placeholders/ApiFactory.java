/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.automatool.poc;

import java.lang.reflect.Field;
import org.springframework.stereotype.Component;

@Component
class ApiFactory {

    public <T> T convertDtoToModel(Object dto, Class<T> modelClass) throws IllegalAccessException, InstantiationException {

        T model = modelClass.newInstance();

        Field[] dtoFields = dto.getClass().getDeclaredFields();

        Field[] modelFields = modelClass.getDeclaredFields();

        for (Field dtoField : dtoFields) {

            for (Field modelField : modelFields) {

                if (dtoField.getName().equals(modelField.getName())) {

                    dtoField.setAccessible(true);

                    modelField.setAccessible(true);

                    Object dtoFieldValue = dtoField.get(dto);

                    if (dtoFieldValue != null) {

                        if (dtoField.getType().equals(modelField.getType())) {

                            modelField.set(model, dtoFieldValue);

                        } else {

                            Object nestedModel = convertDtoToModel(dtoFieldValue, modelField.getType());

                            modelField.set(model, nestedModel);

                        }
                    }
                }
            }
        }
        return model;
    }
}
