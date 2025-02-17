package guru.springframework.sfgpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter @Setter
@Entity @Table( name = "pets" )
public class Pet extends BaseEntity {

    @Column( name = "name" )
    private String name;

    @ManyToOne
    @JoinColumn( name = "type_id" )
    private PetType petType;

    @ManyToOne
    @JoinColumn( name = "owner_id" )
    private Owner owner;

    @Column( name = "birth_date")
    private LocalDate birthDate;

    @OneToMany( cascade = CascadeType.ALL, mappedBy = "pet" )
    private Set<Visit> visits;
}
