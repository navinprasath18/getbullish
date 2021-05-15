package com.getbullish.centralProcessingEngine.service;

import java.io.Serializable;
import java.util.UUID;
import com.getbullish.centralProcessingEngine.Entities.EntityIdentity;
import com.getbullish.centralProcessingEngine.mapper.BaseIdentityMapper;
import com.getbullish.centralProcessingEngine.repos.Baserepo;

public interface BaseService<E extends EntityIdentity, D extends Serializable> {



  public E getEntity(UUID id);


  public Boolean exist(UUID id);


  public void delete(UUID id);


  public Baserepo<E, UUID> getBaseRepository();


  public BaseIdentityMapper<E, D> getBasedataMapper();

}
