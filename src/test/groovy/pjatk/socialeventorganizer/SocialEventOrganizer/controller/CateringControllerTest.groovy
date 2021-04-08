package pjatk.socialeventorganizer.SocialEventOrganizer.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.common.collect.ImmutableList
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.Catering
import pjatk.socialeventorganizer.SocialEventOrganizer.model.exception.NotFoundException
import pjatk.socialeventorganizer.SocialEventOrganizer.model.request.CateringRequest
import pjatk.socialeventorganizer.SocialEventOrganizer.model.response.CateringResponse
import pjatk.socialeventorganizer.SocialEventOrganizer.service.CateringService
import spock.lang.Specification

import javax.validation.ConstraintViolationException

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [CateringController.class])
class CateringControllerTest extends Specification {

    @Autowired
    private MockMvc mockMvc

    @MockBean
    private CateringService cateringService

    def "GET /api/catering/all returns all values positive test scenario"() {
        given:
        def catering = Catering.builder()
                .name("Sample Name")
                .city("Sample City")
                .streetName("Sample Street")
                .streetNumber(1)
                .description("Sample Description")
                .serviceCost(0.00)
                .businessId(1)
                .build()

        def objectMapper = new ObjectMapper()

        def cateringList = ImmutableList.of(catering)
        def json = objectMapper.writeValueAsString(cateringList)

        BDDMockito.given(cateringService.findAll())
                .willReturn(cateringList)

        expect:
        mockMvc.perform(
                get("/api/catering/all")
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json(json))

    }

    def "GET /api/catering/city/{city} positive test scenario"() {
        given:
        def city = 'Warsaw'

        def catering = Catering.builder()
                .name("Sample Name")
                .city(city)
                .streetName("Sample Street")
                .streetNumber(1)
                .description("Sample Description")
                .serviceCost(0.00)
                .businessId(1)
                .build()

        def objectMapper = new ObjectMapper()
        def cateringList = ImmutableList.of(catering)
        def json = objectMapper.writeValueAsString(cateringList)

        BDDMockito.given(cateringService.findByCity(city))
                .willReturn(cateringList)

        expect:
        mockMvc.perform(
                get("/api/catering/city/Warsaw")
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json(json))
    }

    def "GET /api/catering/city/{city} negative test scenario"() {
        given:
        def city = 'blank'

        BDDMockito.given(cateringService.findByCity(city))
                .willThrow(NotFoundException)

        expect:
        mockMvc.perform(
                get("/api/catering/city/blank")
        )
                .andExpect(status().isNotFound())
    }

    def "GET /api/catering/name/{name} positive test scenario"() {
        given:
        def name = 'Name'

        def catering = Catering.builder()
                .name(name)
                .city('city')
                .streetName("Sample Street")
                .streetNumber(1)
                .description("Sample Description")
                .serviceCost(0.00)
                .businessId(1)
                .build()

        def objectMapper = new ObjectMapper()

        def cateringList = ImmutableList.of(catering)
        def json = objectMapper.writeValueAsString(cateringList)

        BDDMockito.given(cateringService.findByName(name))
                .willReturn(cateringList)

        expect:
        mockMvc.perform(
                get("/api/catering/name/Name")
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json(json))
    }

    def "GET /api/catering/name negative test scenario"() {
        given:
        def name = 'blank'

        BDDMockito.given(cateringService.findByName(name))
                .willThrow(NotFoundException)

        expect:
        mockMvc.perform(
                get("/api/catering/name/blank")
        )
                .andExpect(status().isNotFound())
    }

    def "POST /api/catering/add positive test scenario"() {
        given:
        def cateringRequest = CateringRequest.builder()
                .name('name')
                .city('city')
                .streetName("Sample Street")
                .streetNumber(1)
                .serviceCost('12.20')
                .businessId(1)
                .email('email@email.com')
                .phoneNumber('123456789')
                .build()

        def cateringResponse = CateringResponse.builder()
                .id(1)
                .name('name')
                .email('email@email.com')
                .build()

        def objectMapper = new ObjectMapper()

        def jsonRequest = objectMapper.writeValueAsString(cateringRequest)
        def jsonResponse = objectMapper.writeValueAsString(cateringResponse)

        BDDMockito.given(cateringService.addNewCatering(cateringRequest))
                .willReturn(cateringResponse)

        expect:
        mockMvc.perform(
                post("/api/catering/add")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(jsonRequest)
        )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json(jsonResponse))
    }

    def "POST /api/catering/add negative test scenario"() {
        given:
        def cateringRequest = CateringRequest.builder()
                .city('city')
                .streetName("Sample Street")
                .streetNumber(1)
                .serviceCost('12.20')
                .businessId(1)
                .email('email@email.com')
                .phoneNumber('123456789')
                .build()

        def objectMapper = new ObjectMapper()

        def jsonRequest = objectMapper.writeValueAsString(cateringRequest)

        BDDMockito.given(cateringService.addNewCatering(cateringRequest))
                .willThrow(ConstraintViolationException)

        expect:
        mockMvc.perform(
                post("/api/catering/add")
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(jsonRequest)
        )
                .andExpect(status().isBadRequest())
    }

    def "PUT /api/catering/{id} positive test scenario"() {
        given:
        def id = 1
        def cateringRequest = CateringRequest.builder()
                .name('name')
                .city('city')
                .streetName("Sample Street")
                .streetNumber(1)
                .serviceCost('12.20')
                .businessId(1)
                .email('email@email.com')
                .phoneNumber('123456789')
                .build()

        def objectMapper = new ObjectMapper()

        def jsonRequest = objectMapper.writeValueAsString(cateringRequest)

        BDDMockito
                .doNothing()
                .when(cateringService)
                .updateCatering(id, cateringRequest)


        expect:
        mockMvc.perform(
                put("/api/catering/{id}", id)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(jsonRequest)
        )
                .andExpect(status().isNoContent())
    }

    def "PUT /api/catering/{id}} negative test scenario"() {
        given:
        def id = 1
        def cateringRequest = CateringRequest.builder()
                .city('city')
                .streetName("Sample Street")
                .streetNumber(1)
                .serviceCost('12.20')
                .businessId(1)
                .email('email@email.com')
                .phoneNumber('123456789')
                .build()

        def objectMapper = new ObjectMapper()

        def jsonRequest = objectMapper.writeValueAsString(cateringRequest)

        BDDMockito
                .doNothing()
                .when(cateringService)
                .updateCatering(id, cateringRequest)


        expect:
        mockMvc.perform(
                put("/api/catering/{id}", id)
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(jsonRequest)
        )
                .andExpect(status().isBadRequest())
    }

    def "DELETE /api/catering/ positive test scenario"() {
        given:
        def id = 1

        BDDMockito
                .doNothing()
                .when(cateringService)
                .deleteCatering(id)

        expect:
        mockMvc.perform(
                delete("/api/catering/{id}", id)
        )
                .andExpect(status().isNoContent())

    }

}


