package pjatk.socialeventorganizer.SocialEventOrganizer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {
}
