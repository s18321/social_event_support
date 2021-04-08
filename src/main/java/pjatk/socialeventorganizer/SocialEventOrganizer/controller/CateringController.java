package pjatk.socialeventorganizer.SocialEventOrganizer.controller;


import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.Catering;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.exception.IllegalArgumentException;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.request.CateringRequest;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.response.CateringResponse;
import pjatk.socialeventorganizer.SocialEventOrganizer.service.CateringService;

import javax.validation.Valid;


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
    public ResponseEntity<ImmutableList<Catering>> findAll() {
        log.info("GET ALL CATERING");
        final ImmutableList<Catering> all = cateringService.findAll();
        log.info(String.valueOf(all.size()));
         return ResponseEntity.ok(cateringService.findAll());
    }

//    @RequestMapping(
//            method = RequestMethod.GET,
//            value = "/city/{city}",
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity findByCity(@PathVariable String city) {
//        log.info("GET " + city);
//        return ResponseEntity.ok(cateringService.findByCity(city));
//    }

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
    public ResponseEntity<CateringResponse> addCatering(@Valid @RequestBody CateringRequest request) {
        final CateringResponse response = cateringService.addNewCatering(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/{id}", //name same as function argument
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCatering(@Valid @RequestBody CateringRequest request, @PathVariable Long id) {
        try {
            cateringService.updateCatering(id, request);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{id}") //name same as function argument
    public ResponseEntity deleteCatering(@PathVariable Long id) {
        try {
            cateringService.deleteCatering(id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.noContent().build();
    }
}
