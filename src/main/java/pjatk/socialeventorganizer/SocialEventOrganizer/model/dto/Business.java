package pjatk.socialeventorganizer.SocialEventOrganizer.model.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor

@Table("business")
public class Business {

    //TODO: validation for business

    @Id
    @Column("id_business")
    Long id;

    @Column("first_name")
    String firstName;

    @Column("last_name")
    String lastName;

    @Column("business_name")
    String businessName;

    String email;

    @Column("phone_number")
    BigInteger phoneNumber;

    @Column("hashed_password")
    String password;

    @Column("verification_status")
    String verificationStatus;

    @Column("id_address")
    Address address;

    @MappedCollection(idColumn = "id_business")
    Set<Catering> caterings = new HashSet<>();
}
