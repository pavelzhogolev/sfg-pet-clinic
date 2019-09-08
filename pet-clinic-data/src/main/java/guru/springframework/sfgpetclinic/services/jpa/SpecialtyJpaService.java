package guru.springframework.sfgpetclinic.services.jpa;

import guru.springframework.sfgpetclinic.model.Specialty;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile( "jpa" )
public class SpecialtyJpaService implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        this.specialtyRepository.findAll().forEach( specialties::add );

        return specialties;
    }

    @Override
    public Specialty findById( Long id ) {
        return this.specialtyRepository.findById( id ).orElse( null );
    }

    @Override
    public Specialty save( Specialty specialty ) {
        return this.specialtyRepository.save( specialty );
    }

    @Override
    public void delete( Specialty specialty ) {
        this.specialtyRepository.delete( specialty );
    }

    @Override
    public void deleteById( Long id ) {
        this.specialtyRepository.deleteById( id );
    }
}
