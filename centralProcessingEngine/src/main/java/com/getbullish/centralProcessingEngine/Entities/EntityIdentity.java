package com.getbullish.centralProcessingEngine.Entities;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class EntityIdentity implements Serializable {

  // primary key as regex so that ur process and keep in memory

  // STOCK-000001-SETCORCODE

  /**
   * 
   */
  private static final long serialVersionUID = 1L;


  @Id
  @Column(name = "id")
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  public UUID id;

}
