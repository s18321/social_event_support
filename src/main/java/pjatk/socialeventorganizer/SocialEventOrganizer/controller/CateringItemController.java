package pjatk.socialeventorganizer.SocialEventOrganizer.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.CateringItem;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.request.CateringItemRequest;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.response.CateringItemResponse;
import pjatk.socialeventorganizer.SocialEventOrganizer.service.CateringItemService;

import javax.validation.Valid;
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

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CateringItemResponse> addCatering(@Valid @RequestBody CateringItemRequest request) {
        final CateringItemResponse response = service.addNewCateringItem(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCatering(@Valid @RequestBody CateringItemRequest request, @PathVariable Long id) {
        service.updateCateringItem(id, request);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{id}") //name same as function argument
    public ResponseEntity deleteCatering(@PathVariable Long id) {
        service.deleteCateringItem(id);
        return ResponseEntity.noContent().build();
    }
}
