package com.getbullish.centralProcessingEngine.mapper;

import java.io.Serializable;
import com.getbullish.centralProcessingEngine.Entities.EntityIdentity;

public interface BaseIdentityMapper<E extends EntityIdentity, M extends Serializable> {

  public E toEntity(final M model);

  public M toData(final E entity);


}
