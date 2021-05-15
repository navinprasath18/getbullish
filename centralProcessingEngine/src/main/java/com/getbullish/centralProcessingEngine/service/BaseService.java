package com.getbullish.centralProcessingEngine.service;

import java.util.UUID;
import com.getbullish.centralProcessingEngine.Entities.EntityIdentity;
import com.getbullish.centralProcessingEngine.repos.Baserepo;

public interface BaseService<E extends EntityIdentity> {



  public E getEntity(UUID id);



  public Boolean exist(UUID id);


  public void delete(UUID id);


  public Baserepo<E, UUID> getBaseRepository();

}
