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
@Table("admin")
public class Admin implements Serializable{

    @Id
    @Column("id_admin")
    Long id;

    @Column("login") //valiation needed
    String login;

    @Column("hashed_password") //valiation needed
    String hashed_password;
}
