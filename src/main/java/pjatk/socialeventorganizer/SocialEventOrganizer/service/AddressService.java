package pjatk.socialeventorganizer.SocialEventOrganizer.service;

import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.Address;
import pjatk.socialeventorganizer.SocialEventOrganizer.repository.AddressRepository;

import java.util.Optional;

@Service
@Value
@AllArgsConstructor
@Slf4j
public class AddressService {

    AddressRepository repository;

    public Address findById(Long id) {
        final Optional<Address> byId = repository.findById(id);
        return byId.get();
    }
}
