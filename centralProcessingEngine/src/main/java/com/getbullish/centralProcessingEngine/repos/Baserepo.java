package com.getbullish.centralProcessingEngine.repos;

import java.io.Serializable;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import com.getbullish.centralProcessingEngine.Entities.EntityIdentity;

@NoRepositoryBean
public interface Baserepo<T extends EntityIdentity, I extends Serializable>
    extends JpaRepository<T, I> {
  int countById(UUID id);

}
