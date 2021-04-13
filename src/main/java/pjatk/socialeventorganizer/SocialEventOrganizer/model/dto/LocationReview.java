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
@Table("locationReview")
public class LocationReview implements Serializable{

    @Id
    @Column("id_location_review")
    Long id;

    @Column("title") //valiation needed
    String title;

    @Column("comment") //valiation needed
    String comment;

    @Column("id_customer")
    Long id_customer;

    @Column("id_location")
    Long id_location;



}
