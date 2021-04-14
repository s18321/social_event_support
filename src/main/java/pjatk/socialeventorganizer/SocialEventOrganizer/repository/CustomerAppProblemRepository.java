package pjatk.socialeventorganizer.SocialEventOrganizer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.CustomerAppProblem;

@Repository
public interface CustomerAppProblemRepository extends CrudRepository<CustomerAppProblem, Long> {
}
