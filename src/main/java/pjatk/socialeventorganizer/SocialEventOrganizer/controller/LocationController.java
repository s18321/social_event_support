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
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.Location;
import pjatk.socialeventorganizer.SocialEventOrganizer.service.LocationService;

@Slf4j
@AllArgsConstructor
@Validated
@RestController
@RequestMapping("api/location")
public class LocationController {

    private final LocationService service;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ImmutableList<Location>> findAAll() {
        log.info("GET LOCATIONS");
        return ResponseEntity.ok(service.findAll());
    }
}
