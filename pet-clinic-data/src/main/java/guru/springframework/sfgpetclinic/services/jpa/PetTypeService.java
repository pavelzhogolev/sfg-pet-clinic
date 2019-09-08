package guru.springframework.sfgpetclinic.services.jpa;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile( "jpa" )
public class PetTypeService implements guru.springframework.sfgpetclinic.services.PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        this.petTypeRepository.findAll().forEach( petTypes::add );

        return petTypes;
    }

    @Override
    public PetType findById( Long id ) {
        return this.petTypeRepository.findById( id ).orElse( null );
    }

    @Override
    public PetType save( PetType petType ) {
        return this.petTypeRepository.save( petType );
    }

    @Override
    public void delete( PetType petType ) {
        this.petTypeRepository.delete( petType );
    }

    @Override
    public void deleteById( Long id ) {
        this.petTypeRepository.deleteById( id );
    }
}
