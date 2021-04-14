package pjatk.socialeventorganizer.SocialEventOrganizer.service;

import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pjatk.socialeventorganizer.SocialEventOrganizer.mapper.ImageMapper;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.LocationImage;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.exception.NotFoundException;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.request.ImageRequestDetails;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.request.LocationImageRequest;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.response.ImageResponse;
import pjatk.socialeventorganizer.SocialEventOrganizer.repository.LocationImageRepository;

import java.util.List;
import java.util.Optional;

@Service
@Value
@AllArgsConstructor
@Slf4j
public class LocationImageService {

    LocationImageRepository repository;

    ImageMapper mapper;

    public ImageResponse addImagesToLocation(LocationImageRequest request) {
        final Integer locationId = request.getLocationId();
        final List<ImageRequestDetails> details = request.getDetails();
        ImageResponse response = new ImageResponse();
        final List<Long> newImageIds = response.getNewImageIds();

        for (ImageRequestDetails detail : details) {
            final LocationImage locationImage = mapper.mapToLocationImageDTO(detail, locationId);
            final LocationImage save = repository.save(locationImage);
            newImageIds.add(save.getId());
        }

        return response;
    }

    public List<LocationImage> findByLocationId(long locationId) {
        final Optional<List<LocationImage>> allByLocationId = repository.findAllByLocationId(locationId);
        if (allByLocationId.isPresent() && !allByLocationId.get().isEmpty()) {
            return allByLocationId.get();
        }
        throw new NotFoundException("There are no images to show");

    }
}
