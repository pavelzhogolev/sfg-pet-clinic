package guru.springframework.sfgpetclinic.services.jpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import guru.springframework.sfgpetclinic.services.VisitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@Profile( "jpa" )
public class VisitJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        this.visitRepository.findAll().forEach( visits::add );

        return visits;
    }

    @Override
    public Visit findById( Long id ) {
        return this.visitRepository.findById( id ).orElse( null );
    }

    @Override
    public Visit save( Visit visit ) {
        return this.visitRepository.save( visit );
    }

    @Override
    public void delete( Visit visit ) {
        this.visitRepository.delete( visit );
    }

    @Override
    public void deleteById( Long id ) {
        this.visitRepository.deleteById( id );
    }
}
