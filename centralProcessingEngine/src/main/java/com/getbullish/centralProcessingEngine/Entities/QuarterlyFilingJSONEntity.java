package com.getbullish.centralProcessingEngine.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "quarterlyfilings")
public class QuarterlyFilingJSONEntity extends EntityIdentity {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;



  @ManyToOne
  @JoinColumn(name = "stock", nullable = false)
  Stock stock;

  @Column(name = "json")
  @Type(type = "jsonb")
  String json;


  @Column(name = "filename")
  @Type(type = "string")
  String xmlfilename;


}
