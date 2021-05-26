package com.getbullish.centralProcessingEngine.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "stock")
@Getter
@Setter
@ToString(includeFieldNames = true)
public class Stock extends EntityIdentity {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;



  @OneToOne
  @JoinColumn(name = "sector", nullable = false)
  Sector sector;

  @Column(name = "symbol")
  String symbol;

  @Column(name = "security")
  String security;

  @Column(name = "series")
  String Series;

  @Column(name = "isincode")
  String isincode;
}
