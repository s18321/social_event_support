//package pjatk.socialeventorganizer.SocialEventOrganizer;
//
//
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import pjatk.socialeventorganizer.SocialEventOrganizer.repository.CateringRepository;
//import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.CateringDTO;
//
//import java.util.List;
//
//@Slf4j
//@SpringBootApplication
//@AllArgsConstructor
//public class SocialEventOrganizerApplicationConsoleRunner implements CommandLineRunner {
//
//    private final CateringRepository repository;
//
//    public static void main(String[] args) {
//        SpringApplication.run(SocialEventOrganizerApplicationConsoleRunner.class, args);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        final List<CateringDTO> list = repository.findByCity("Warsaw");
//        for (CateringDTO catering : list) {
//            log.warn(catering.toString());
//        }
//    }
//}
