//package pjatk.socialeventorganizer.SocialEventOrganizer;
//
//import org.apache.tools.ant.taskdefs.optional.junit.BaseTest;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.jdbc.Sql;
//import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.Catering;
//import pjatk.socialeventorganizer.SocialEventOrganizer.model.dto.Location;
//import pjatk.socialeventorganizer.SocialEventOrganizer.repository.CateringRepository;
//import pjatk.socialeventorganizer.SocialEventOrganizer.repository.LocationRepository;
//
//public class Test extends BaseTest {
//
//    @Autowired
//    private LocationRepository locationRepository;
//
//    @Autowired
//    private CateringRepository cateringRepository;
//
//    @Test
//    @DisplayName("many-to-many-mapping-test")
//    @Sql(scripts = "/many-to-many-mapping.sql")
//    void embeddedMappingTest() {
//
//        Catering catering1 = cateringRepository.save(getSubject1());
//        Catering catering2 = cateringRepository.save(getSubject2());
//        Catering catering3 = cateringRepository.save(getSubject3());
//
//        Location branch1 = getBranch1();
//        branch1.addSubject(subj1);
//        branch1.addSubject(catering2);
//
//        Location createdBranch1 = locationRepository.save(branch1);
//        Assert.assertTrue(createdBranch1 != null);
//
//        Location branch2 = getBranch2();
//        branch2.addSubject(subj1);
//        branch2.addSubject(catering3);
//
//        Location createdBranch2 = locationRepository.save(branch2);
//        Assert.assertTrue(createdBranch2 != null);
//
//        locationRepository.delete(branch1);
//        Assert.assertTrue(!locationRepository.existsById(branch1.getBranchId()));
//
//        locationRepository.findAll().forEach(b -> System.err.println(b));
//    }
//
//    private static Catering getSubject1() {
//        Catering subject = new Subject();
//        subject.setSubjectName("Software Engineering");
//        subject.setSubjectDesc(
//                "Apply key aspects of software engineering processes for the development of a complex software system");
//
//        return subject;
//    }
//
//    private static Catering getSubject2() {
//        Catering subject = new Subject();
//        subject.setSubjectName("Distributed System");
//        subject.setSubjectDesc("Explore recent advances in distributed computing systems");
//
//        return subject;
//    }
//
//    private static Catering getSubject3() {
//        Subject subject = new Subject();
//        subject.setSubjectName("Business Analysis and Optimization");
//        subject.setSubjectDesc("understand the Internal and external factors that impact the business strategy");
//
//        return subject;
//    }
//
//    private static Branch getBranch1() {
//        Branch branch = new Branch();
//        branch.setBranchName("Computer Science and Engineering");
//        branch.setBranchShortName("CSE");
//        branch.setDescription(
//                "CSE department offers courses under ambitious curricula in computer science and computer engineering..");
//
//        return branch;
//    }
//
//    private static Branch getBranch2() {
//        Location branch = new Branch();
//        branch.setBranchName("Information Technology");
//        branch.setBranchShortName("IT");
//        branch.setDescription(
//                "IT is the business side of computers - usually dealing with databases, business, and accounting");
//
//        return branch;
//    }
//}
//
