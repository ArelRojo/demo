package com.example.demo.entity.events;

import com.example.demo.entity.entity.Entity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class GenericEntityEventPublisher {

  private final ApplicationEventPublisher applicationEventPublisher;

  public void publishGenericEvent(final Entity entity, final String event){
    log.info("PUBLISHER: Evento publicado {}",event);
    final GenericEntityEvent genericEntityEvent = new GenericEntityEvent(entity,event);
    applicationEventPublisher.publishEvent(genericEntityEvent);
  }

}
