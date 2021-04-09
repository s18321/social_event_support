package pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.ref;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Table("location_description")
public class DescriptionItemRef {

    @Column("description_item_name")
    String id;
}
