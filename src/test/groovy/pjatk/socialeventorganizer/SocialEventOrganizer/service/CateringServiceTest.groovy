package pjatk.socialeventorganizer.SocialEventOrganizer.service

import com.google.common.collect.ImmutableList
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.Catering
import pjatk.socialeventorganizer.SocialEventOrganizer.repository.CateringRepository
import spock.lang.Specification
import spock.lang.Subject

class CateringServiceTest extends Specification {

    @Subject
    CateringService cateringService

    CateringRepository cateringRepository

    def setup(){
        cateringRepository = Mock()

        cateringService = new CateringService(cateringRepository)
    }

    def "findAll positive test scenario"() {
        given:
        def catering = Catering.builder()
                .cateringId(1)
                .name('Name')
                .city('Warsaw')
                .build()

        def cateringList = Arrays.asList(catering)

        def target = ImmutableList.copyOf(cateringList)

        when:
        def result = cateringService.findAll()

        then:
        result == target

        1 * cateringRepository.findAll() >> target
    }
}
