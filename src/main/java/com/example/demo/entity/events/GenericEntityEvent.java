package com.example.demo.entity.events;

import com.example.demo.entity.entity.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEvent;

@Getter
public class GenericEntityEvent {

  private final Entity entity;
  protected final String event;

  public GenericEntityEvent( final Entity entity, final String event) {

    this.event = event;
    this.entity = entity;
  }
}
