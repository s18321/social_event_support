package pjatk.socialeventorganizer.SocialEventOrganizer.service;


import com.google.common.collect.ImmutableList;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.Business;
import pjatk.socialeventorganizer.SocialEventOrganizer.repository.BusinessRepository;

import java.util.List;

@Service
@Value
@AllArgsConstructor
@Slf4j
public class BusinessService {

    BusinessRepository repository;

    public ImmutableList<Business> findAll() {
        final List<Business> businessList = (List<Business>) repository.findAll();
        return ImmutableList.copyOf(businessList);
    }
}
