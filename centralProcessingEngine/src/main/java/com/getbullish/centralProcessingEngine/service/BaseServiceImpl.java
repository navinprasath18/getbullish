package com.getbullish.centralProcessingEngine.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import com.getbullish.centralProcessingEngine.Entities.EntityIdentity;
import com.getbullish.centralProcessingEngine.data.DataIdentity;

public abstract class BaseServiceImpl<E extends EntityIdentity, D extends DataIdentity>
    implements BaseService<E, D> {



  public E getEntity(UUID id) {
    return getBaseRepository().findById(id)
        .orElseThrow(() -> new EntityNotFoundException(id.toString()));
  }



  public List<E> list() {
    return this.getBaseRepository().findAll();
  }



  public Boolean exist(UUID id) {

    return null;
  }



  public void delete(UUID id) {


  }

  @Transactional
  public E mapToEntity(D data) {
    return getBasedataMapper().toEntity(data);
  }

  public D mapToData(E entity) {
    return getBasedataMapper().toData(entity);
  }

  public List<D> listData() {
    List<E> list = this.getBaseRepository().findAll();
    return list.stream().map(this::mapToData).collect(Collectors.toList());
  }



}
