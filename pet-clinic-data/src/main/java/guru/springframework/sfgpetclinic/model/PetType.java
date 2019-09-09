package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity @Table( name = "types" )
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class PetType extends BaseEntity {

    @Column( name = "name" )
    private String name;
}
