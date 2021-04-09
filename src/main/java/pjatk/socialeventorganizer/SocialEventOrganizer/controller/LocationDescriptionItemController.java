package pjatk.socialeventorganizer.SocialEventOrganizer.controller;

import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.LocationDescriptionItem;
import pjatk.socialeventorganizer.SocialEventOrganizer.service.LocationDescriptionItemService;

@Slf4j
@AllArgsConstructor
@Validated
@RestController
@RequestMapping("api/location_description")
public class LocationDescriptionItemController {

    private final LocationDescriptionItemService service;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ImmutableList<LocationDescriptionItem>> findAAll() {
        log.info("GET LOCATION DESCRIPTIONS");
        return ResponseEntity.ok(service.findAll());
    }
}
