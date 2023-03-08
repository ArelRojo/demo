package com.example.demo.entity.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AnnotationGenericEntityEventListener {

  @EventListener(condition = "#genericEntityEvent.event eq 'SAVE'")
  public void handleSaveEvent(final GenericEntityEvent genericEntityEvent){
    log.info("Evento capturado - {}",genericEntityEvent.getEvent());
  }

  @EventListener(condition = "#genericEntityEvent.event eq 'AUDIT'")
  public void handleAuditEvent(final GenericEntityEvent genericEntityEvent){
    log.info("Evento capturado - {}",genericEntityEvent.getEvent());
  }

  @EventListener(condition = "#genericEntityEvent.event eq 'INDEX'")
  public void handleIndexEvent(final GenericEntityEvent genericEntityEvent){
    log.info("Evento capturado - {}",genericEntityEvent.getEvent());
  }

}
