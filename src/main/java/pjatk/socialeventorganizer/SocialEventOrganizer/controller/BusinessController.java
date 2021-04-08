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
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.Business;
import pjatk.socialeventorganizer.SocialEventOrganizer.service.BusinessService;

@Slf4j
@AllArgsConstructor
@Validated
@RestController
@RequestMapping("api/business")
public class BusinessController {

    private final BusinessService service;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ImmutableList<Business>> findAll() {
        log.info("GET ALL BUSINESSES");
        final ImmutableList<Business> all = service.findAll();
        log.info(String.valueOf(all.size()));
        return ResponseEntity.ok(service.findAll());
    }
}
