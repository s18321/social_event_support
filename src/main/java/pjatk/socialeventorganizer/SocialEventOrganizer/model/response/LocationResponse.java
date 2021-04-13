package pjatk.socialeventorganizer.SocialEventOrganizer.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationResponse {

    private Long id;
    private boolean servesFood;
//    private Set<String> locationDescription;
}
