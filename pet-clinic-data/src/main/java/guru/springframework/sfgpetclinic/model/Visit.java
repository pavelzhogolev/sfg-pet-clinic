package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity @Table( name = "visits" )
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Visit extends BaseEntity {

    @Column( name = "date" )
    private LocalDate date;

    @Column( name = "description" )
    private String description;

    @ManyToOne
    @JoinColumn( name = "pet_id" )
    private Pet pet;
}
