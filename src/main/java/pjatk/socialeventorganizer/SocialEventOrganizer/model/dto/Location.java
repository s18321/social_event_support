package pjatk.socialeventorganizer.SocialEventOrganizer.model.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.ref.CateringRef;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.ref.DescriptionItemRef;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;

@Builder
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table("location")
public class Location {

    @Id
    @Column("id_location")
    Long id;

    String name;

    String email;

    @Column("phone_number")
    BigInteger phoneNumber;

    @Column("seating_capacity")
    Integer seatingCapacity;

    @Column("standing_capacity")
    Integer standingCapacity;

    String description;

    @Column("daily_rent_cost")
    BigDecimal dailyRentCost;

    @Column("size_in_sq_meters")
    Integer sizeSqMeters;

    @Column("id_business")
    Integer businessId;

    @Column("id_address")
    Address address;

    @MappedCollection(idColumn = "id_location")
    HashSet<CateringRef> caterings = new HashSet<>();

    @MappedCollection(idColumn = "id_location")
    HashSet<DescriptionItemRef> descriptions = new HashSet<>();

    public void addCatering(Catering catering) {
        caterings.add(new CateringRef(catering.getId()));
    }

    public void addLocationDescription(LocationDescriptionItem item) {
        descriptions.add(new DescriptionItemRef(item.getId()));
    }
}
