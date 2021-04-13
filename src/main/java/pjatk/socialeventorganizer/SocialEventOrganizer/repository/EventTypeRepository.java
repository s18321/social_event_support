package pjatk.socialeventorganizer.SocialEventTypeOrganizer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.EventType;

@Repositor
public interface EventTypeRepository extends CrudRepository<EventType, String> {
}
