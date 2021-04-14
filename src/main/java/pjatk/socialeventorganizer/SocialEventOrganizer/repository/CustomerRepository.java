package pjatk.socialeventorganizer.SocialEventOrganizer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
