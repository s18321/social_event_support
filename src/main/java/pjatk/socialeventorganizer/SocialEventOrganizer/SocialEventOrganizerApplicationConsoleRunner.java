//package pjatk.socialeventorganizer.SocialEventOrganizer;
//
//
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.Catering;
//import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.CateringMenu;
//import pjatk.socialeventorganizer.SocialEventOrganizer.service.CateringMenuService;
//import pjatk.socialeventorganizer.SocialEventOrganizer.service.CateringService;
//
//import java.util.List;
//
//@Slf4j
//@SpringBootApplication
//@AllArgsConstructor
//public class SocialEventOrganizerApplicationConsoleRunner implements CommandLineRunner {
//
//    private final CateringMenuService service;
//
//    public static void main(String[] args) {
//        SpringApplication.run(SocialEventOrganizerApplicationConsoleRunner.class, args);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        final List<CateringMenu> list = service.findAll();
//        for (CateringMenu catering : list) {
//            log.info(catering.toString());
//        }
//    }
//}
