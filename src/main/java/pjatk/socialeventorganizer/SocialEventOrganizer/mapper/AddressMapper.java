package pjatk.socialeventorganizer.SocialEventOrganizer.mapper;

import org.springframework.stereotype.Component;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.Address;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.request.AddressRequest;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.response.AddressResponse;

@Component
public class AddressMapper {


    public Address mapToDTO(AddressRequest request) {
        return Address.builder()
                .country(request.getCounty())
                .city(request.getCity())
                .streetName(request.getStreetName())
                .streetNumber(request.getStreetNumber())
                .zipCode(request.getZipCode())
                .build();
    }

    public AddressResponse mapToResponse(Address address) {
        return AddressResponse.builder()
                .id(address.getId())
                .build();
    }

    public Address mapToDTO(AddressRequest request, Integer id) {
        return Address.builder()
                .id(Long.valueOf(id))
                .country(request.getCounty())
                .city(request.getCity())
                .streetName(request.getStreetName())
                .streetNumber(request.getStreetNumber())
                .zipCode(request.getZipCode())
                .build();
    }
}
