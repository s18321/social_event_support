package pjatk.socialeventorganizer.SocialEventOrganizer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.LocationImage;

@Repository
public interface LocationImageRepository extends CrudRepository<LocationImage, Long> {
}
