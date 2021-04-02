package pjatk.socialeventorganizer.SocialEventOrganizer.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.CateringDTO;

import java.util.List;

@Repository
public interface CateringRepository extends CrudRepository<CateringDTO, Long> {

    List<CateringDTO> findAll();

    @Query("SELECT * FROM catering c WHERE c.city = :city")
    List<CateringDTO> findByCity(@Param("city") String city);

}
