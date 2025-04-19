package myProject.weatherForecAst.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name = "cities")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "timezone")
    private String timezone;
}
