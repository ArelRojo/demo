package com.example.demo.excel.implementation;

import com.example.demo.entity.enums.TypeEvents;
import com.example.demo.entity.events.GenericEntityEventPublisher;
import com.example.demo.entity.interfaces.ObjectOperator;
import com.example.demo.entity.mapper.EntityMapper;
import com.example.demo.entity.model.EntityDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("objectOperatorExcel")
@RequiredArgsConstructor
public class ObjectOperatorImpl implements ObjectOperator {

  private final GenericEntityEventPublisher genericEntityEventPublisher;
  private final EntityMapper entityMapper;

  @Override
  public void processObject(Object o){
    log.info("EXCEL: Objeto Procesado");
    EntityDTO entityDTO = new EntityDTO();
    //Método de validación , depende de donde viene la implementación varia
    validateObject(entityDTO);
    //SAVE: evento síncrono
    genericEntityEventPublisher.publishGenericEvent(entityMapper.convertDTOToEntity(entityDTO),TypeEvents.SAVE.name());
    log.info("EXCEL: Ejecutando asincronos");
    //Ejecutamos auditoría e indexación de manera asíncrona y esperamos a que terminen
    asyncThreadExecutor(entityDTO,
        genericEntityEventPublisher, entityMapper);
    log.info("EXCEL: Terminado asincronos");
  }

  @Override
  public void validateObject(EntityDTO entityDTO) {
    log.info("EXCEL: Objeto validado");
  }
}
