package pjatk.socialeventorganizer.SocialEventOrganizer.service;

import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pjatk.socialeventorganizer.SocialEventOrganizer.mapper.CateringMapper;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.Catering;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.exception.IllegalArgumentException;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.exception.NotFoundException;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.request.CateringRequest;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.response.CateringResponse;
import pjatk.socialeventorganizer.SocialEventOrganizer.repository.CateringRepository;

import java.util.List;

@Service
@Value
@AllArgsConstructor
@Slf4j
public class CateringService {

    CateringRepository repository;

    CateringMapper cateringMapper;


    public ImmutableList<Catering> findAll() {
        final List<Catering> cateringList = (List<Catering>) repository.findAll();
        return ImmutableList.copyOf(cateringList);
    }

    public ImmutableList<Catering> findByName(String name) {
        final List<Catering> cateringList = repository.findByNameContaining(name);
        if (cateringList != null && !cateringList.isEmpty()) {
            return ImmutableList.copyOf(cateringList);
        } else {
            throw new NotFoundException("No catering with the name " + name + " was found");
        }
    }

//    public ImmutableList<Catering> findByCity(String city) {
//        final List<Catering> cateringList = repository.findByCityContaining(city);
//        if (cateringList != null && !cateringList.isEmpty()) {
//            return ImmutableList.copyOf(cateringList);
//        } else {
//            throw new NotFoundException("No catering in the city " + city + " was found");
//        }
//    }

    public CateringResponse addNewCatering(CateringRequest request) {
        final Catering catering = cateringMapper.mapToDTO(request);
        log.info("TRYING TO SAVE" + catering.toString());
        repository.save(catering);
        log.info("SAVED");
        return cateringMapper.mapToResponse(catering);
    }


    public void updateCatering(Long cateringId, CateringRequest request) {
        if (!cateringWithIdExists(cateringId)) {
            throw new IllegalArgumentException("Catering with ID " + cateringId + " does not exist");
        }

        final Catering catering = cateringMapper.mapToDTO(request, cateringId);
        log.info("TRYING TO UPDATE " + catering);
        repository.save(catering);
        log.info("UPDATED");
    }

    public void deleteCatering(Long id) {
        if (!cateringWithIdExists(id)) {
            throw new IllegalArgumentException("Catering with ID " + id + " does not exist");
        }

        log.info("TRYING TO DELETE CATERING WITH ID " + id);
        repository.deleteById(id);
    }

    public boolean cateringWithIdExists(Long id) {
        log.info("CHECKING IF CATERING WITH ID " + id + " EXISTS");
        return repository.existsById(id);
    }

}
