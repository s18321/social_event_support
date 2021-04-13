package pjatk.socialeventorganizer.SocialEventOrganizer.mapper;

import org.springframework.stereotype.Component;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.LocationImage;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.request.ImageRequestDetails;

@Component
public class ImageMapper {

    public LocationImage mapToLocationImageDTO(ImageRequestDetails imageRequestDetails, Integer locationId) {
        return LocationImage.builder()
                .locationId(locationId)
                .image(imageRequestDetails.getImage())
                .alt(imageRequestDetails.getAlt())
                .build();
    }
}
