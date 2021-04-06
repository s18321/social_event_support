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
import pjatk.socialeventorganizer.SocialEventOrganizer.service.CateringService
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [CateringController.class])
class CateringControllerTest extends Specification {

    @Autowired
    private MockMvc mockMvc

    @MockBean
    private CateringService cateringService;

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
}


