package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @EqualsAndHashCode.Exclude
  @ToString.Exclude
  private Integer id;

  @EqualsAndHashCode.Exclude
  private String name;

  @EqualsAndHashCode.Include
  @Column(unique = true)
  private String dni;

  @EqualsAndHashCode.Exclude
  private String city;
  @EqualsAndHashCode.Exclude
  private String number;
}
