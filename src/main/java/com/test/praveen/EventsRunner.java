package com.test.praveen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventsRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static final String getEventsQuery = "select * from emp where deptId=?";

    public List findEvents(String inputParam, String inputType) {
        try {
            if (inputType.equalsIgnoreCase(ConstantsFile.VIN_STRING)) {
                List<List> list = jdbcTemplate.query(getEventsQuery, new EventsMapper(), new Object[]{inputParam});
                return list.get(0);
            } else {
                new ArrayList<>();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//    public List<Events> findEvents2(String inputParam, String inputType){
//
//        try{
//            if(inputType.equalsIgnoreCase(ConstantsFile.VIN_STRING)){
//                List<Events> events =jdbcTemplate.query(getEventsQuery, new MapSqlParameterSource[]{new MapSqlParameterSource()
//                        .addValue("breedId", "")
//                        .addValue("gender", "gender")});
//                return events;
//            }
//            else{
//                return new ArrayList<>();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
