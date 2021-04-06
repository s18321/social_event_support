package pjatk.socialeventorganizer.SocialEventOrganizer.model.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table("catering_item_type_dictionary")
public class CateringItemType implements Serializable {

    @Id
    @Column("type")
    String id;

    String description;

    @MappedCollection(idColumn = "type")
    Set<CateringItem> cateringItemSet = new HashSet<>();

}
