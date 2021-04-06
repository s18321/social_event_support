package pjatk.socialeventorganizer.SocialEventOrganizer.model.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
/*
NAMING AS IN DB (tables and attributes)
 or with annotation @Column("column_name)/@Table("table_name)
 */
public class Catering implements Serializable {

    @Id
    @Column("id_catering")
    Long id;

    String name;

    String city;

    @Column("street_name")
    String streetName;

    @Column("street_number")
    int streetNumber;

    @Column("contact_email")
    String email;

    @Column("contact_phone_number")
    BigInteger phoneNumber;

    @Column("service_cost")
    BigDecimal serviceCost;

    String description;

    @Column("id_business")
    int businessId;

    @MappedCollection(idColumn = "id_catering")
    Set<CateringItem> cateringItemSet = new HashSet<>();

}
