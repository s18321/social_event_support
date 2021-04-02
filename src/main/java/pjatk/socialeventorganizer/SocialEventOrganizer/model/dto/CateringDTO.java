package pjatk.socialeventorganizer.SocialEventOrganizer.model.dto;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

@Builder
@Value
public class CateringDTO implements Serializable {
    @Id
    Long id_catering;

    String name;

    String city;

    String street_name;

    int street_number;

    String contact_email;

    BigInteger contact_phone_number;

    BigDecimal service_cost;

    String description;

    int id_business;

}