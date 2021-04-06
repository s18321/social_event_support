package pjatk.socialeventorganizer.SocialEventOrganizer.service;

import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.CateringItem;
import pjatk.socialeventorganizer.SocialEventOrganizer.repository.CateringItemRepository;

import java.util.List;

@Service
@Value
@AllArgsConstructor
@Slf4j
public class CateringItemService {

    CateringItemRepository repository;

    public List<CateringItem> findAll() {
        log.info("GET ALL CATERING_ITEM");
        return (List<CateringItem>) repository.findAll();
    }


}
