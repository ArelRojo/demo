package com.example.demo.entity.controller;

import com.example.demo.dynamic.catalog.model.DynamicCatalogDTO;
import com.example.demo.entity.factory.ObjectOperatorFactory;
import com.example.demo.entity.interfaces.ObjectOperator;
import com.example.demo.entity.model.EntityDTO;
import com.example.demo.wizard.model.WizardDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/entity")
public class EntityController {

  private final ObjectOperatorFactory factory;

  @PostMapping("/save")
  public ResponseEntity<String> saveEntity(@RequestBody DynamicCatalogDTO dynamicCatalogDTO){
    ObjectOperator ob = factory.getInstance(dynamicCatalogDTO);
    ob.processObject(dynamicCatalogDTO);
    return ResponseEntity.ok("DONE CREATE FROM DYNAMIC CATALOG");
  }

  @PostMapping("/create")
  public ResponseEntity<String> createEntity(@RequestBody WizardDTO wizardDTO){
    ObjectOperator ob = factory.getInstance(wizardDTO);
    ob.processObject(wizardDTO);
    return ResponseEntity.ok("DONE CREATE FROM WIZARD");
  }

}
