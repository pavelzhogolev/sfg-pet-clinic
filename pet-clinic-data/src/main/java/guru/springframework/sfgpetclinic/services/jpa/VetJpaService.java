package guru.springframework.sfgpetclinic.services.jpa;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.VetRepository;
import guru.springframework.sfgpetclinic.services.VetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@Profile( "jpa" )
public class VetJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetJpaService( VetRepository vetRepository ) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        this.vetRepository.findAll().forEach( vets::add );

        return vets;
    }

    @Override
    public Vet findById( Long id ) {
        return this.vetRepository.findById( id ).orElse( null );
    }

    @Override
    public Vet save( Vet vet ) {
        return this.vetRepository.save( vet );
    }

    @Override
    public void delete( Vet vet ) {
        this.vetRepository.delete( vet );
    }

    @Override
    public void deleteById( Long id ) {
        this.vetRepository.deleteById( id );
    }
}
