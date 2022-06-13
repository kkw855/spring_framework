package org.example.ch6;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Singer implements Serializable {
  private Long id;
  private String firstName;
  private String lastName;
  private Date birthDate;
  private List<Album> albums;
}
