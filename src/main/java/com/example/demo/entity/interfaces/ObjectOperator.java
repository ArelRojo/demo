package com.example.demo.entity.interfaces;

import com.example.demo.entity.enums.TypeEvents;
import com.example.demo.entity.events.GenericEntityEventPublisher;
import com.example.demo.entity.mapper.EntityMapper;
import com.example.demo.entity.model.EntityDTO;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public interface ObjectOperator{

  void processObject(Object o) ;

  void validateObject(EntityDTO entityDTO);

  default void asyncThreadExecutor(EntityDTO entityDTO,
      GenericEntityEventPublisher genericEntityEventPublisher, EntityMapper entityMapper) {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    CompletableFuture<Void> futureAudit = CompletableFuture.runAsync(() -> genericEntityEventPublisher.publishGenericEvent(
        entityMapper.convertDTOToEntity(entityDTO), TypeEvents.AUDIT.name()), executorService);
    CompletableFuture<Void> futureIndex = CompletableFuture.runAsync(() -> genericEntityEventPublisher.publishGenericEvent(
        entityMapper.convertDTOToEntity(entityDTO),TypeEvents.INDEX.name()), executorService);
    CompletableFuture.allOf(futureAudit,futureIndex).join();
  }
}
