package pjatk.socialeventorganizer.SocialEventOrganizer.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageRequestDetails {

    @NotBlank
    String image;

    @NotBlank
    String alt;

}
