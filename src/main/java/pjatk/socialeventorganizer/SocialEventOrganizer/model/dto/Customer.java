package pjatk.socialguestorganizer.SocialEventOrganizer.model.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table("customer")
public class Customer implements Serializable{

    @Id
    @Column("id_customer")
    Long id;

    @Column("first_name") //valiation needed
    String first_name;

    @Column("last_name") //valiation needed
    String last_name;

    @Column("email") //valiation needed
    String email;

    @Column("hashed_password") //valiation needed
    String hashed_password;

    @Column("phone_number") //valiation needed
    String phone_number;

}
