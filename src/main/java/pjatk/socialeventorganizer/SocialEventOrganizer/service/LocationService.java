package pjatk.socialeventorganizer.SocialEventOrganizer.service;

import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.Location;
import pjatk.socialeventorganizer.SocialEventOrganizer.repository.LocationRepository;

import java.util.List;

@Service
@Value
@AllArgsConstructor
@Slf4j
public class LocationService {

    LocationRepository repository;

    public ImmutableList<Location> findAll() {
        final List<Location> locationList = (List<Location>) repository.findAll();
        return ImmutableList.copyOf(locationList);
    }

}
