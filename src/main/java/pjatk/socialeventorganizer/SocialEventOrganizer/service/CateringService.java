package pjatk.socialeventorganizer.SocialEventOrganizer.service;

import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import pjatk.socialeventorganizer.SocialEventOrganizer.mapper.CateringMapper;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.Catering;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.exception.NotFoundException;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.request.CateringRequest;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.response.NewCateringResponse;
import pjatk.socialeventorganizer.SocialEventOrganizer.repository.CateringRepository;

import java.util.List;
import java.util.Optional;

@Service
@Value
@AllArgsConstructor
@Slf4j
public class CateringService {

    CateringRepository repository;

    CateringMapper cateringMapper;

    public List<Catering> findAll() {

        final List<Catering> cateringList = (List<Catering>) repository.findAll();
        return ImmutableList.copyOf(cateringList);
    }

    public List<Catering> findByCity(@PathVariable String city) {
        final List<Catering> cateringList = repository.findByCity(city);
        if (cateringList.isEmpty()) {
            log.info("SERVICE");
            throw new NotFoundException("There are NO catering companies in " + city);
        }
        return Optional.ofNullable(repository.findByCity(city))
                .orElseThrow(() -> new NotFoundException("There are no catering companies in " + city));

    }

    public NewCateringResponse save(CateringRequest request) {
        final Catering catering = cateringMapper.mapToDTO(request);
        log.info("TRYING TO SAVE" + catering.toString());
        repository.save(catering);

        final NewCateringResponse cateringResponse = cateringMapper.mapToResponse(catering);
        return cateringResponse;
    }


    public void updateCatering(Long cateringId, CateringRequest request) {
        final Catering catering = cateringMapper.mapToDTO(request, cateringId);
        log.info("TRYING TO UPDATE " + catering);
        repository.save(catering);
        log.info("UPDATED");
    }

    public void deleteCatering(Long id) {
        log.info("TRYING TO DELETE CATERING WITH ID " + id);
        repository.deleteById(id);
    }

}
