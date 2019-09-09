package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity @Table( name = "specialties" )
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Specialty extends BaseEntity {

    @Column( name = "description" )
    private String description;
}
