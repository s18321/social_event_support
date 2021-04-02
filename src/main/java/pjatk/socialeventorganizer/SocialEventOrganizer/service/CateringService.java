package pjatk.socialeventorganizer.SocialEventOrganizer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pjatk.socialeventorganizer.SocialEventOrganizer.repository.CateringRepository;

@Slf4j
@Service
@AllArgsConstructor
public class CateringService {

    private final CateringRepository repository;

}
