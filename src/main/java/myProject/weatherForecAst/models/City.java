package myProject.weatherForecAst.models;

import lombok.*;


@Entity
@Table(name = "cities")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class City {

    @Id
    private Long id;

    @Column("name")
    private String name;

    @Column("timezone")
    private String timezone;
}
