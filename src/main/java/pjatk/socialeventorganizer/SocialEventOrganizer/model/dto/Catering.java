package pjatk.socialeventorganizer.SocialEventOrganizer.model.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

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
@Table("catering")
public class Catering implements Serializable {

    @Id
    @Column("id_catering")
    Long id;

    String name;


    String email;

    @Column("phone_number")
    BigInteger phoneNumber;

    @Column("service_cost")
    BigDecimal serviceCost;

    String description;

    @Column("id_business")
    int businessId;

    //TODO: add address to request

    @Column("id_address")
    Address address;

    @MappedCollection(idColumn = "id_catering", keyColumn = "id_catering_iten")
    Set<CateringItem> cateringItems = new HashSet<>();

}
