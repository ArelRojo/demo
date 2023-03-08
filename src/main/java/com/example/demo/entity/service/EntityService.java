package com.example.demo.entity.service;

import com.example.demo.entity.model.EntityDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EntityService {

  public void getEntityById(String id){
    /** Sacar entity por id **/
  }

  public void audit(EntityDTO entityDTO){
    log.info("ENTITY SERVICE: Aquí se audita el objeto");
  }

  public void index(EntityDTO entityDTO){
    log.info("ENTITY SERVICE: Aquí se indexa el objeto");
  }

}
