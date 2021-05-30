package org.ajani2001.back.publishing;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishingRepository extends CrudRepository<Publishing, Long> {
}
