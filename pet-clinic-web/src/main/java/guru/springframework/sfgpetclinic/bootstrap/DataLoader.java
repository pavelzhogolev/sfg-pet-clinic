package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) {

        int petsTypeNumber = petTypeService.findAll().size();

        if( petsTypeNumber == 0 ) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName( "Dog" );
        PetType savedDogPetType = petTypeService.save( dog );

        PetType cat = new PetType();
        cat.setName( "Cat" );
        PetType savedCatPetType = petTypeService.save( cat );

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress( "123 street" );
        owner1.setCity( "New York" );
        owner1.setTelephone( "123456" );

        Pet mikesPet = new Pet();
        mikesPet.setName( "Some Dog" );
        mikesPet.setPetType( savedDogPetType );
        mikesPet.setOwner( owner1 );
        mikesPet.setBirthDate( LocalDate.now() );
        owner1.getPets().add( mikesPet );

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress( "456 street " );
        owner2.setCity( "Miami" );
        owner2.setTelephone( "765890" );

        Pet fionasPet = new Pet();
        fionasPet.setName( "Just Cat" );
        fionasPet.setPetType( savedCatPetType );
        fionasPet.setOwner( owner2 );
        fionasPet.setBirthDate( LocalDate.now() );
        owner2.getPets().add( fionasPet );

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Specialty radiology = new Specialty();
        radiology.setDescription( "Radiology" );
        Specialty savedRadiology = specialtyService.save( radiology );

        Specialty surgery = new Specialty();
        surgery.setDescription( "Surgery" );
        Specialty savedSurgery = specialtyService.save( surgery );

        Specialty dentistry = new Specialty();
        dentistry.setDescription( "Dentistry" );
        Specialty savedDentistry = specialtyService.save( dentistry );


        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add( savedRadiology );
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet1.getSpecialties().add( savedSurgery );
        vet1.getSpecialties().add( savedDentistry );
        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
