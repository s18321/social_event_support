package pjatk.socialeventorganizer.SocialEventOrganizer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.CateringItem;

@Repository
public interface CateringItemRepository extends CrudRepository<CateringItem, Long> {



}
