package pjatk.socialeventorganizer.SocialEventOrganizer.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.Catering;

import java.util.List;

@Repository
public interface CateringRepository extends CrudRepository<Catering, Long> {

    List<Catering> findAll();

    @Query("SELECT * FROM catering c WHERE c.city = :city")
    List<Catering> findByCity(@Param("city") String city);

}
