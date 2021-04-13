package pjatk.socialeventorganizer.SocialEventOrganizer.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.LocationDescriptionItem;

@Repository
public interface LocationDescriptionItemRepository extends CrudRepository<LocationDescriptionItem, String> {

    @Query("INSERT INTO location_description (id_location, description_item_name) VALUES (:id, :description)")
    void insertSingleLocationDescription(@Param("id") Long id, @Param("description") String locationDescription);

     LocationDescriptionItem getLocationDescriptionItemById(String id);
}
