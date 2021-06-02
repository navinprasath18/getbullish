package com.getbullish.centralProcessingEngine.Entities.Books.QuarterResultEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.getbullish.centralProcessingEngine.Entities.EntityIdentity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "calculations")
@Getter
@Setter
@ToString(includeFieldNames = true)
@Entity
public class Calculations extends EntityIdentity {
  /**
  * 
  */
  private static final long serialVersionUID = 1L;

}
