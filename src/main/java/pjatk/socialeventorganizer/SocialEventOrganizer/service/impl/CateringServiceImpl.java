package pjatk.socialeventorganizer.SocialEventOrganizer.service.impl;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.Catering;
import pjatk.socialeventorganizer.SocialEventOrganizer.repository.CateringRepository;
import pjatk.socialeventorganizer.SocialEventOrganizer.service.CateringService;

import java.util.List;

@Service
@Value
@AllArgsConstructor
public class CateringServiceImpl implements CateringService {

    CateringRepository repository;

    @Override
    public List<Catering> findAll() {
        return repository.findAll();
    }
}
