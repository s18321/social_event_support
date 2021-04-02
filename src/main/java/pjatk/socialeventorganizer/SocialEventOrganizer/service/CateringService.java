package pjatk.socialeventorganizer.SocialEventOrganizer.service;

import org.springframework.stereotype.Service;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.Catering;

import java.util.List;

@Service
public interface CateringService {

    List<Catering> findAll();
}
