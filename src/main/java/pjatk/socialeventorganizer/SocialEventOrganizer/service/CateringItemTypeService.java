package pjatk.socialeventorganizer.SocialEventOrganizer.service;

import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.CateringItemType;
import pjatk.socialeventorganizer.SocialEventOrganizer.repository.CateringItemTypeRepository;

import java.util.List;

@Service
@Value
@AllArgsConstructor
@Slf4j
public class CateringItemTypeService {

    CateringItemTypeRepository repository;

    public List<CateringItemType> findAll() {
        final List<CateringItemType> cateringItemTypeList = (List<CateringItemType>)repository.findAll();
        return ImmutableList.copyOf(cateringItemTypeList);
    }

}
