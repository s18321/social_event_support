package pjatk.socialeventorganizer.SocialEventOrganizer.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.Catering;

import java.util.List;
import java.util.Optional;

@Repository
public interface CateringRepository extends CrudRepository<Catering, Long> {

    /*
    IF A METHOD NEEDS A CUSTOM IMPLEMENTATION OR IT DOES NOT EXITS IN CrudRepository interface => it needs to be written here.
    Otherwise you dont need to, just call the method from ServiceImpl
     */
    @Query("SELECT * FROM catering c WHERE c.city = :city")
    List<Catering> findByCity(String city);

    @Query("SELECT * FROM catering c WHERE c.name = :name")
    Optional<Catering> findByName(String name);
}
