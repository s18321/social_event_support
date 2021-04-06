package pjatk.socialeventorganizer.SocialEventOrganizer.service

import com.google.common.collect.ImmutableList
import pjatk.socialeventorganizer.SocialEventOrganizer.mapper.CateringMapper
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.Catering
import pjatk.socialeventorganizer.SocialEventOrganizer.model.exception.NotFoundException
import pjatk.socialeventorganizer.SocialEventOrganizer.model.request.CateringRequest
import pjatk.socialeventorganizer.SocialEventOrganizer.repository.CateringRepository
import spock.lang.Specification
import spock.lang.Subject

class CateringServiceTest extends Specification {

    @Subject
    CateringService cateringService

    CateringRepository cateringRepository

    CateringMapper mapper


    def setup() {
        cateringRepository = Mock()
        mapper = Mock()

        cateringService = new CateringService(cateringRepository, mapper)
    }

    def "findAll positive test scenario"() {
        given:
        def catering = CateringRequest.builder()
                .id(1)
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

    def "findByCity positive test scenario"() {
        given:
        def catering = Catering.builder()
                .id(1)
                .name('Name')
                .city('Warsaw')
                .build()

        def city = 'Warsaw'
        def cateringList = Arrays.asList(catering)

        def target = ImmutableList.copyOf(cateringList)

        when:
        def result = cateringService.findByCity(city)

        then:
        result == target

        1 * cateringRepository.findByCity(city) >> target
    }

    def "findByCity negative test scenario"() {
        given:
        def city = 'Nope'

        when:
        cateringService.findByCity(city)

        then:
        thrown(NotFoundException)
        1 * cateringRepository.findByCity(city) >> { throw new NotFoundException() }
    }

    def "findByName positive test scenario"() {
        given:
        def target = Catering.builder()
                .id(1)
                .name('Name')
                .city('Warsaw')
                .build()

        def name = 'Name'

        when:
        def result = cateringService.findByName(name)

        then:
        result == target

        1 * cateringRepository.findByName(name) >> Optional.of(target)
    }

    def "findByName negative test scenario"() {
        given:
        def name = 'Nope'

        when:
        cateringService.findByName(name)

        then:
        thrown(NotFoundException)
        1 * cateringRepository.findByName(name) >> { throw new NotFoundException() }
    }

    def "addNewCatering positive test scenario"() {
        given:
        def cateringRequest = CateringRequest.builder()
                .name('Name')
                .city('City')
                .build();

        def catering = Catering.builder()
                .name('Name')
                .city('City')
                .build();

        when:
        cateringService.addNewCatering(cateringRequest)

        then:
        1 * mapper.mapToDTO(cateringRequest) >> catering
        1 * cateringRepository.save(catering)

    }

    def "updateCatering positive test scenario"() {
        given:
        def cateringRequest = CateringRequest.builder()
                .name('Name')
                .city('City')
                .build();

        def id = 1;

        def catering = Catering.builder()
                .id(id)
                .name('Name')
                .city('City')
                .build();

        when:
        cateringService.updateCatering(1, cateringRequest)

        then:
        1 * mapper.mapToDTO(cateringRequest, id) >> catering
        1 * cateringRepository.save(catering)
    }

    def "deleteCatering positive test scenario"() {
        given:
        def id = 1;

        when:
        cateringService.deleteCatering(id)

        then:
        1 * cateringRepository.deleteById(id)
    }


}
