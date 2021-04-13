package pjatk.socialeventorganizer.SocialEventOrganizer.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;
import pjatk.socialeventorganizer.SocialEventOrganizer.common.RegexConstants;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressRequest implements Serializable {

    @NotBlank(message = "Country is mandatory")
    @Size(min = 2, max = 30, message
            = "The country name should be between 2 and 30 characters")
    @Pattern(regexp = RegexConstants.COUNTRY_REGEX)
    private String county;


    @NotBlank(message = "City is mandatory")
    @Size(min = 2, max = 30, message
            = "The city name should be between 1 and 40 characters")
    @Pattern(regexp = RegexConstants.CITY_REGEX)
    private String city;


    @NotBlank(message = "Street name is mandatory")
    @Size(min = 2, max = 50, message
            = "The street name should be between 1 and 40 characters")
    @Pattern(regexp = RegexConstants.STREET_REGEX)
    private String streetName;


    @NotNull(message = "Street number is mandatory")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private int streetNumber;

    @NotBlank(message = "Zip code is mandatory")
    @Pattern(regexp = RegexConstants.PL_ZIP_REGEX, message = "Should match XX-XXX format")
    String zipCode;

}
