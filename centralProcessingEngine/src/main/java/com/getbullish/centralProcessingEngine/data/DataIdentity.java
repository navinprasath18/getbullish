package com.getbullish.centralProcessingEngine.data;

import java.io.Serializable;
import java.util.UUID;
import lombok.Data;

@Data
public class DataIdentity implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private UUID id;

}
