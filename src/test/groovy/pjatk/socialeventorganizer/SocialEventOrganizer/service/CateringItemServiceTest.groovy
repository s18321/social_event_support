package pjatk.socialeventorganizer.SocialEventOrganizer.service

import com.google.common.collect.ImmutableList
import pjatk.socialeventorganizer.SocialEventOrganizer.mapper.CateringItemMapper
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.CateringItem
import pjatk.socialeventorganizer.SocialEventOrganizer.repository.CateringItemRepository
import spock.lang.Specification
import spock.lang.Subject

class CateringItemServiceTest extends Specification {

    @Subject
    CateringItemService cateringItemService

    CateringItemRepository repository

    CateringItemMapper mapper

    def setup() {
        repository = Mock()

        cateringItemService = new CateringItemService(repository, mapper)
    }

    def "findAll positive test scenario"() {
        given:
        def catering = CateringItem.builder()
                .name('Name')
                .build();

        def list = [catering]
        def target = ImmutableList.copyOf(list)

        when:
        def result = cateringItemService.findAll()

        then:
        target == result
        1 * repository.findAll() >> target

    }

}
