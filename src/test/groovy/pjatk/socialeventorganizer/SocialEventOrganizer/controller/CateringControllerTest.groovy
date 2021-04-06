package pjatk.socialeventorganizer.SocialEventOrganizer.controller


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import pjatk.socialeventorganizer.SocialEventOrganizer.service.CateringService
import spock.lang.Specification

@WebMvcTest(controllers = [CateringController.class])
class CateringControllerTest extends Specification {

    @Autowired
    private MockMvc mockMvc

    @MockBean
    private CateringService cateringService;

    
}
