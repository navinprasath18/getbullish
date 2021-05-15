package com.getbullish.centralProcessingEngine.service;

import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import com.getbullish.centralProcessingEngine.Entities.EntityIdentity;
import com.getbullish.centralProcessingEngine.repos.Baserepo;

public abstract class BaseServiceImpl<E extends EntityIdentity> implements BaseService<E> {



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



  public Baserepo<E, UUID> getBaseRepository() {

    return null;
  }


}
