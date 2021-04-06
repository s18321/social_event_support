package pjatk.socialeventorganizer.SocialEventOrganizer.controller;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.Catering;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.request.CateringRequest;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.response.NewCateringResponse;
import pjatk.socialeventorganizer.SocialEventOrganizer.service.CateringService;

import javax.validation.Valid;
import java.util.List;


@Slf4j
@AllArgsConstructor
@Validated
@RestController
@RequestMapping("api/catering")
public class CateringController {

    private final CateringService cateringService;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Catering>> findAll() {
        log.info("GET ALL CATERING");
        return ResponseEntity.ok(cateringService.findAll());
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/city/{city}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findByCity(@PathVariable String city) {
        log.info("GET " + city);
        return ResponseEntity.ok(cateringService.findByCity(city));
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/name/{name}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findByCateringName(@PathVariable String name) {
        log.info("GET " + name);
        return ResponseEntity.ok(cateringService.findByName(name));
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NewCateringResponse> addCatering(@Valid @RequestBody CateringRequest request) {
        final NewCateringResponse response = cateringService.addNewCatering(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/{id}", //name same as function argument
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCatering(@Valid @RequestBody CateringRequest request, @PathVariable Long id) {
        cateringService.updateCatering(id, request);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{id}") //name same as function argument
    public ResponseEntity deleteCatering(@PathVariable Long id) {
        cateringService.deleteCatering(id);
        return ResponseEntity.noContent().build();
    }
}
