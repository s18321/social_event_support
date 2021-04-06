package pjatk.socialeventorganizer.SocialEventOrganizer.mapper;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.Catering;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.request.CateringRequest;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.response.NewCateringResponse;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

@Component
@Slf4j
public class CateringMapper {

    public Catering mapToDTO(CateringRequest request) {
        final String requestServiceCost = request.getServiceCost();
        log.info("COST STRING " + requestServiceCost);
        final BigDecimal serviceCost = convertPriceString(requestServiceCost);
        log.info("COST CONVERTED " + serviceCost);

        final String requestPhoneNumber = request.getPhoneNumber();
        final BigInteger phoneNumber = convertPhoneNumberString(requestPhoneNumber);

        final String requestDescription = request.getDescription();
        final String description = convertDescriptionsString(requestDescription);

        return Catering.builder()
                .name(request.getName())
                .city(request.getCity())
                .streetName(request.getStreetName())
                .streetNumber(request.getStreetNumber())
                .email(request.getEmail())
                .phoneNumber(phoneNumber)
                .serviceCost(serviceCost)
                .description(description)
                .businessId(request.getBusinessId())
                .build();
    }

    public Catering mapToDTO(CateringRequest request, Long id) {
        final String requestServiceCost = request.getServiceCost();
        final BigDecimal serviceCost = convertPriceString(requestServiceCost);

        final String requestPhoneNumber = request.getPhoneNumber();
        final BigInteger phoneNumber = convertPhoneNumberString(requestPhoneNumber);

        final String requestDescription = request.getDescription();
        final String description = convertDescriptionsString(requestDescription);

        return Catering.builder()
                .id(id)
                .name(request.getName())
                .city(request.getCity())
                .streetName(request.getStreetName())
                .streetNumber(request.getStreetNumber())
                .email(request.getEmail())
                .phoneNumber(phoneNumber)
                .serviceCost(serviceCost)
                .description(description)
                .businessId(request.getBusinessId())
                .build();
    }


    public NewCateringResponse mapToResponse(Catering catering) {
        return NewCateringResponse.builder()
                .id(catering.getId())
                .name(catering.getName())
                .email(catering.getEmail())
                .build();
    }

    private BigDecimal convertPriceString(String inputPrice) {
        final String format = String.format("%.2f", Double.parseDouble(inputPrice));
        log.info(format);
        return new BigDecimal(format);
    }

    private BigInteger convertPhoneNumberString(String phoneNumber) {
        return new BigInteger(phoneNumber);
    }

    private String convertDescriptionsString(String description) {
        final Optional<String> optional = Optional.ofNullable(description)
                .filter(s -> !s.isEmpty());
        return optional.orElse(null);
    }
}
