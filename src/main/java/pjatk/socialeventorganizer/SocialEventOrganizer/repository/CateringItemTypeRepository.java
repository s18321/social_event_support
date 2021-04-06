package pjatk.socialeventorganizer.SocialEventOrganizer.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.CateringItemType;

@Repository
public interface CateringItemTypeRepository extends CrudRepository<CateringItemType, Long> {

    @Query("SELECT citd.type from catering_item_type_dictionary citd " +
            "WHERE citd.id_catering_item_type_dictionary = :?")
    String findTypeById(@Param("?") Long id);
}

