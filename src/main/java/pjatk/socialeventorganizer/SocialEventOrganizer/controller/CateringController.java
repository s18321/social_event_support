package pjatk.socialeventorganizer.SocialEventOrganizer.controller;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.CateringDTO;
import pjatk.socialeventorganizer.SocialEventOrganizer.repository.CateringRepository;

import java.util.List;


@Slf4j
@AllArgsConstructor
@Validated
@RestController
@RequestMapping("api/catering")
public class CateringController {

    private final CateringRepository cateringRepository;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/all",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CateringDTO>> findAll(){
        log.info("GET ALL CATERING");
        return ResponseEntity.ok(cateringRepository.findAll());
    }

}
