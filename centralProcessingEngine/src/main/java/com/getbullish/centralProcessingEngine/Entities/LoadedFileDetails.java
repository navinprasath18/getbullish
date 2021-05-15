package com.getbullish.centralProcessingEngine.Entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "history")
@Getter
@Setter
@ToString(includeFieldNames = true)
@Entity
public class LoadedFileDetails extends EntityIdentity {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Column(name = "filename", nullable = false)
  String filename;

  @Column(name = "dateloaded", nullable = false)
  Date dateloaded;

  @Column(name = "isLoaded", nullable = false)
  Boolean isLoaded;

}
