package com.getbullish.centralProcessingEngine.Entities;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@TypeDefs({@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)})
@JsonIgnoreProperties()
public class EntityIdentity implements Serializable {


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
