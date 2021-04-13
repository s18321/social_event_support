package pjatk.socialeventorganizer.SocialEventOrganizer.mapper;

import org.springframework.stereotype.Component;
import pjatk.socialeventorganizer.SocialEventOrganizer.convertors.Converter;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.Location;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.request.LocationRequest;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.response.LocationResponse;

import java.util.HashSet;

@Component
public class LocationMapper {

    public Location mapToDTO(LocationRequest request, long addressId) {
        return Location.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phoneNumber(Converter.convertPhoneNumberString(request.getPhoneNumber()))
                .seatingCapacity(request.getSeatingCapacity())
                .standingCapacity(request.getStandingCapacity())
                .description(Converter.convertDescriptionsString(request.getDescription()))
                .dailyRentCost(Converter.convertPriceString(request.getDailyRentCost()))
                .sizeSqMeters(request.getSizeSqMeters())
                .addressId((int) addressId)
                .businessId(request.getBusinessId())
                .descriptions(new HashSet<>())
                .images(new HashSet<>())
                .build();
    }

    public LocationResponse mapToResponse(Location location, boolean servesFood) {
        return LocationResponse.builder()
                .id(location.getId())
                .servesFood(servesFood)
                .build();
    }
}
