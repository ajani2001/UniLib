package org.ajani2001.back;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface RCRUDRepository<EntryClass, EntryRepresentationClass, IdClass> extends CrudRepository<EntryClass, IdClass> {
    public Iterable<EntryRepresentationClass> getRepresentationAll();
    public Optional<EntryRepresentationClass> getRepresentationById(IdClass id);
}