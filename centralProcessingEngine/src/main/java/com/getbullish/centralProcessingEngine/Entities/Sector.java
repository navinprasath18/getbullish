package com.getbullish.centralProcessingEngine.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "sector")
@Getter
@Setter
@ToString(includeFieldNames = true)
public class Sector extends EntityIdentity {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Column(name = "name", nullable = false, unique = true)
  String name;

  @Column(name = "symbol", nullable = false, unique = true)
  String symbol;

}
