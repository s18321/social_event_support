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
@Table("event_type")
public class EventType implements Serializable {

    @Id
    @Column("type")
    String id;

    @Column("description")
    String description;

}
