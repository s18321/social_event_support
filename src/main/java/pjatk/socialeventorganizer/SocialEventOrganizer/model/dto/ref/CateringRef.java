package pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.ref;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;
@Data
@AllArgsConstructor
@Table("catering_location")
public class CateringRef {

    Long idCatering;
}
