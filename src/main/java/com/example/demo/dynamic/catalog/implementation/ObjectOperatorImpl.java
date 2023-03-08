package com.example.demo.dynamic.catalog.implementation;

import com.example.demo.entity.enums.TypeEvents;
import com.example.demo.entity.events.GenericEntityEventPublisher;
import com.example.demo.entity.interfaces.ObjectOperator;
import com.example.demo.entity.mapper.EntityMapper;
import com.example.demo.entity.model.EntityDTO;
import com.example.demo.entity.service.EntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("objectOperatorDynamic")
@RequiredArgsConstructor
public class ObjectOperatorImpl implements ObjectOperator {

  private final GenericEntityEventPublisher genericEntityEventPublisher;
  private final EntityService entityService;
  private final EntityMapper entityMapper;

  @Override
  public void processObject(Object o) {
    log.info("DYNAMIC CATALOG: Objeto Procesado");
    EntityDTO entityDTO = new EntityDTO();
    validateObject(entityDTO);
    //SAVE: evento síncrono
    genericEntityEventPublisher.publishGenericEvent(entityMapper.convertDTOToEntity(entityDTO),
        TypeEvents.SAVE.name());
    log.info("DYNAMIC CATALOG: Ejecutando asincronos");
    asyncThreadExecutor(entityDTO,
        genericEntityEventPublisher, entityMapper);
    log.info("DYNAMIC CATALOG: Terminado asincronos");
  }

  @Override
  public void validateObject(EntityDTO entityDTO) {
    log.info("DYNAMIC CATALOG: Objeto validado");
  }
}
