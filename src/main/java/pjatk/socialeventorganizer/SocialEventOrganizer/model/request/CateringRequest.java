package pjatk.socialeventorganizer.SocialEventOrganizer.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
/*
FIELDS NAMES AND TYPES  MUST MATCH THE KEY VALUES IN JSON BODY.
 */
public class CateringRequest implements Serializable {

    @NotBlank(message = "Name is mandatory")
    @Size(min = 1, max = 100, message
            = "The name should be between 1 and 100 characters")
    @Pattern(regexp = "^(?=\\s*\\S).*$")
    private String name;


    @NotBlank(message = "City is mandatory")
    @Size(min = 1, max = 40, message
            = "The city name should be between 1 and 40 characters")
    @Pattern(regexp = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$")
    private String city;


    @NotBlank(message = "Street name is mandatory")
    @Size(min = 1, max = 40, message
            = "The street name should be between 1 and 40 characters")
    @Pattern(regexp = "[\\w\\s]+")
    private String streetName;


    @NotNull(message = "Street number is mandatory")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private int streetNumber;


    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    @Size(min = 5, max = 100, message
            = "Email should be between 5 and 100 characters")
    private String email;


    @NotBlank(message = "Phone number is mandatory")
    @Size(min = 9, max = 9, message
            = "phone number should be 9 characters long")
    @Pattern(regexp = "^\\d{9}$", message = "should contain only digits")
    private String phoneNumber;


    @NotBlank(message = "If there no are service cost, please enter 0")
    @Pattern(regexp = "^\\d+(.\\d{1,2})?$", message = "should contain only digits or digits separated by a dot sign (1.23)")
    private String serviceCost;


    private String description;

    @NotNull
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private int businessId;


}


