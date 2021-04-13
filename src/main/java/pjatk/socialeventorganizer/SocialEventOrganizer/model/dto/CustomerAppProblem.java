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
@Table("customer_app_problem")
public class Customer implements Serializable{

    @Id
    @Column("id_customer_app_problem")
    Long id;

    @Column("date") //valiation needed
    Date dateOfReport;

    @Column("time") //valiation needed
    Timestamp timeOfReport;

    @Column("concern") //valiation needed
    String concern;

    @Column("description") //valiation needed
    String description;

    @Column("id_customer") //valiation needed
    Long id_customer;

}
