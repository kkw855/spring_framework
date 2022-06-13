package org.example.ch6;

import java.io.Serializable;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Album implements Serializable {
  private int id;
  private int singerId;
  private String title;
  private Date releaseDate;
}
