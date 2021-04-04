package pjatk.socialeventorganizer.SocialEventOrganizer.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewCateringResponse {

    private Long id;
    private String name;
    private String email;
}
