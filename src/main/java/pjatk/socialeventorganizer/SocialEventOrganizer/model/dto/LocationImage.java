package pjatk.socialeventorganizer.SocialEventOrganizer.model.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table("location_image")
public class LocationImage implements Serializable {

    @Id
    @Column("id_location_image")
    Long id;

    String image;

    String alt;

    @Column("id_location")
    Integer locationId;
}
