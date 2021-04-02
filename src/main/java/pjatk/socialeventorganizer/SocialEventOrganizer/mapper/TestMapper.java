//package pjatk.socialeventorganizer.SocialEventOrganizer.mapper;
//
//import org.springframework.jdbc.core.RowMapper;
//import pjatk.socialeventorganizer.SocialEventOrganizer.test_model.Catering;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//
//public class TestMapper implements RowMapper<Catering> {
//
//    @Override
//    public Catering mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//        return Catering.builder()
//                .id(rs.getLong("id_catering"))
//                .name(rs.getString("name"))
//                .build();
//    }
//}
