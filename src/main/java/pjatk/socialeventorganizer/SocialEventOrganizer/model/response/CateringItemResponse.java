package pjatk.socialeventorganizer.SocialEventOrganizer.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CateringItemResponse {

    private Long id;
    private String name;
    private BigDecimal price;
    private String type;
}
