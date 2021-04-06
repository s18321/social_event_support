package pjatk.socialeventorganizer.SocialEventOrganizer.model.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Table("catering_item")
public class CateringItem implements Serializable {

    @Id
    @Column("id_catering_item")
    Long id;

    String name;

    String description;

    @Column("serving_price")
    BigDecimal servingPrice;

    @Column("is_vegan")
    boolean isVegan;

    @Column("is_vegetarian")
    boolean isVegetarian;

    @Column("is_gluten_free")
    boolean isGlutenFree;

    @Column("type")
    String itemType;

    @Column("id_catering")
    int cateringId;

}


