/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.automatool.poc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Codicef & Orasz
 */
@RestController
public class ApiController {
    
    Logger logger = LoggerFactory.getLogger("API LOGGER");
    
    @Autowired
    ApiFactory factory;
    
    @Autowired
    ApiAssembler assembler;
    
    @Autowired
    BusinessService service;
    
    @PostMapping("/testApi")
    public ResponseEntity<{{Resource}}> convert(@RequestBody {{InputDto}} dto) throws IllegalAccessException, InstantiationException{
        
        {{InputModel}} inputModel = factory.convertDtoToModel(dto, {{InputModel}}.class);
        ObjectMapper om = new ObjectMapper();
        logger.info("Converted model = {}", om.writeValueAsString(inputModel));
        
        {{OutputModel}} outputModel = service.doSomeBusinessLogic(inputModel);
        
        {{Resource}} resource = assembler.convertModelToResource(outputModel, {{Resource}}.class);
        
        return ResponseEntity.ok(resource);
    }
    
}
