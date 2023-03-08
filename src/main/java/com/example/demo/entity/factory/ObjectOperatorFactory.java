package com.example.demo.entity.factory;

import com.example.demo.dynamic.catalog.model.DynamicCatalogDTO;
import com.example.demo.entity.interfaces.ObjectOperator;
import com.example.demo.entity.mapper.EntityMapper;
import com.example.demo.entity.service.EntityService;
import com.example.demo.excel.model.ExcelDTO;
import com.example.demo.wizard.model.WizardDTO;
import com.sun.istack.internal.NotNull;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ObjectOperatorFactory {

  private final ApplicationContext applicationContext;

  private static @NonNull EntityMapper entityMapper;
  private static @NonNull EntityService entityService;
  public ObjectOperator getInstance(Object o){
    if(o instanceof WizardDTO){
      return applicationContext.getBean(com.example.demo.wizard.implementation.ObjectOperatorImpl.class);
    }else if(o instanceof ExcelDTO){
      return applicationContext.getBean(com.example.demo.excel.implementation.ObjectOperatorImpl.class);
    }else if(o instanceof DynamicCatalogDTO) {
      return applicationContext.getBean(com.example.demo.dynamic.catalog.implementation.ObjectOperatorImpl.class);
    }else return null;
  }

}
