package com.test.praveen;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventsMapper implements RowMapper<List> {

    @SneakyThrows
    @Override
    public List mapRow(ResultSet rs, int rowNum) throws SQLException {

        List<String> list = new ArrayList<>();
        Assigned assigned = new Assigned();
        assigned.setDestCounty(rs.getString("name"));
        assigned.setEventName("assigned");

        Delivery delivery = new Delivery();
        delivery.setItemName(String.valueOf(rs.getInt("id")));
        delivery.setEventName("delivery");

        String temp = "assigned: "+new ObjectMapper().writeValueAsString(assigned);
        String temp2 = "delivery: "+new ObjectMapper().writeValueAsString(delivery);

        list.add(temp);
        list.add(temp2);
        return list;
    }

//    @Override
//    public List mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//        List<Map<String, Object>> list = new ArrayList<>();
//            Assigned assigned = new Assigned();
//            assigned.setDestCounty(rs.getString("name"));
//            assigned.setEventName("assigned");
//
//            Delivery delivery = new Delivery();
//            delivery.setItemName(String.valueOf(rs.getInt("id")));
//            delivery.setEventName("delivery");
//
//            Map<String, Object> l1=new HashMap<>();
//            l1.put("assigned", assigned);
//            l1.put("delivery", delivery);
//            list.add(l1);
//        return list;
//    }
//    @Override
//    public Events mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//        Events events = new Events();
//
//        events.getAssigned().setI_EVENT(rs.getString("I_VIN"));
//        events.getDelivery().setDId("T_EVENT_DATE");
//        return events;
//    }
}
