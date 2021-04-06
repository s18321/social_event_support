package pjatk.socialeventorganizer.SocialEventOrganizer.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.CateringItem;
import pjatk.socialeventorganizer.SocialEventOrganizer.service.CateringItemService;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Validated
@RestController
@RequestMapping("api/catering_item")
public class CateringItemController {

    private final CateringItemService service;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CateringItem>> findAll() {
        log.info("GET ALL CATERING_ITEM_TYPES");
        return ResponseEntity.ok(service.findAll());
    }
}
