package pjatk.socialeventorganizer.SocialEventOrganizer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.LocationDescriptionItem;

@Repository
public interface LocationDescriptionItemRepository extends CrudRepository<LocationDescriptionItem, String> {


}
