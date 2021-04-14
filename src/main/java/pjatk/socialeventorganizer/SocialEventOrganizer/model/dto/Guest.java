package pjatk.socialguestorganizer.SocialEventOrganizer.model.dto;

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
@Table("guest")
public class Guest implements Serializable{

    @Id
    @Column("id_guest")
    Long id;

    @Column("first_name") //valiation needed
    String firstName;

    @Column("last_name") //valiation needed
    String lastName;

    @Column("email") //valiation needed
    String email;

    @Column("id_customer")
    Long idCustomer;


}
