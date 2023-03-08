package com.example.demo.excel.controller;

import com.example.demo.entity.factory.ObjectOperatorFactory;
import com.example.demo.entity.interfaces.ObjectOperator;
import com.example.demo.entity.model.EntityDTO;
import com.example.demo.excel.model.ExcelDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/excel")
public class ExcelController {

  private final ObjectOperatorFactory factory;

  @PostMapping("/create")
  public ResponseEntity<String> createEntity(@RequestBody ExcelDTO excelDTO){
    ObjectOperator ob = factory.getInstance(excelDTO);
    ob.processObject(excelDTO);
    return ResponseEntity.ok("DONE CREATE FROM EXCEL");
  }
}
