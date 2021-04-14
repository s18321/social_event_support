package pjatk.socialeventorganizer.SocialEventOrganizer.model.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.ref.GuestRef;

import java.io.Serializable;
import java.util.HashSet;

@Builder
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table("organized_event")
public class Event implements Serializable{

    @Id
    @Column("id_organized_event")
    Long id;

    @Column("start_date")
    Timestamp startDate;

    @Column("end_date")
    Timestamp endDate;

    @Column("is_predefined")
    boolean isPredefined;

    @Column("event_status")
    EventStatusEnum eventStatus;

    @Column("event_type")
    EventTypeEnum eventType;

    @Column("id_customer")
    Long idCustomer;


    @MappedCollection(idColumn = "id_organized_event")
    HashSet<GuestRef> guests = new HashSet<>();

    public void addGuest(Guest guest) {
        guests.add(new GuestRef(guest.getId()));
    }


}
