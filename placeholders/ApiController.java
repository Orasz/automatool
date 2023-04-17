
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
public class ApiController {{
    
    Logger logger = LoggerFactory.getLogger("API LOGGER");
    
    @Autowired
    ApiFactory factory;
    
    @Autowired
    ApiAssembler assembler;
    
    @Autowired
    BusinessService service;
    
    @PostMapping("/testApi")
    public ResponseEntity<{Resource}> convert(@RequestBody {InputDto} dto) throws IllegalAccessException, InstantiationException{{
        
        {InputModel} inputModel = factory.convertDtoToModel(dto, {InputModel}.class);
        ObjectMapper om = new ObjectMapper();
        logger.info("Converted model = {{}}", om.writeValueAsString(inputModel));
        
        {OutputModel} outputModel = service.doSomeBusinessLogic(inputModel);
        logger.info("randomized model = {{}}", om.writeValueAsString(outputModel));
        logger.info("Service logic completed.");

        
        {Resource} resource = assembler.convertModelToResource(outputModel, {Resource}.class);
        logger.info("Resource assembled.");

        return ResponseEntity.ok(resource);
    }}
    
}}
