package com.example.demo.entity.mapper;

import com.example.demo.entity.entity.Entity;
import com.example.demo.entity.model.EntityDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EntityMapper {

  public  Entity convertDTOToEntity(EntityDTO entityDTO){

    return new Entity();
  }

  public Entity convertDTOToEntity(EntityDTO entityDTO,String operacion){
    log.info("Operacion {}",operacion);
    return convertDTOToEntity(entityDTO);
  }
}
