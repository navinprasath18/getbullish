package com.getbullish.centralProcessingEngine.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(includeFieldNames = true)
@Table(name = "filingdata")
public class QuarterlyResultsURLEntity extends EntityIdentity {
  /**
  * 
  */
  private static final long serialVersionUID = 1L;

  @Column(name = "consolidated")
  String Consolidated;

  @Column(name = "audited")
  String Audited;

  @Column(name = "cumulative")
  String Cumulative;

  @Column(name = "period")
  String period;


  @Column(name = "indas")
  String indOrNon;

  @Column(name = "periodended")
  String periodEnded;

  @Column(name = "relatingtto")
  String relatingto;

  @Column(name = "url")
  String url;

  @Column(name = "isprocessed")
  boolean processed;

  @Column(name = "companyname", nullable = false)
  String companyname;

}
