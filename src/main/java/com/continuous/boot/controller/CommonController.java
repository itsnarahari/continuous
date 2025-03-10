package com.continuous.boot.controller;

import com.continuous.boot.config.SingletonBean;
import com.continuous.boot.models.*;
import com.continuous.boot.service.CommonServices;
import com.continuous.boot.service.PlanetService;
import com.continuous.practice.Employee;
import com.continuous.praveen.EventsRunner;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/common")
@RestController
public class CommonController {

    @Autowired
    EventsRunner eventsRunner;

    @Autowired
    RestTemplate restTemplate;
//    @Autowired
//    JdbcTemplate jdbcTemplate;
    @Autowired
    SingletonBean singletonBean;
    @Autowired
    PlanetService planetService;
    @Value("${babu:}")
    String dynamicProps;
    @Autowired
    Employee employee;
    @Autowired
    Address address;
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Autowired
    private CommonServices commonServices;

    @GetMapping("/check")
    public ResponseEntity singleton() {

        employee.setId(1);
        employee.setName("Narahari");
        address.setCity("Hyderabad");

        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @GetMapping("/common2")
    public ResponseEntity common() {
        return new ResponseEntity(dynamicProps, HttpStatus.OK);
    }

    @GetMapping("/jt")
    public ResponseEntity jt() {
        List<Users> result = jdbcTemplate.query("select * from users", new JtRowMapper());
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PostMapping("/planet")
    public ResponseEntity planetRequest(@Valid @RequestBody Planet planet) {
        Planet planet1 = planetService.savePlanet(planet);
        return ResponseEntity.ok(planet1);
    }

    @GetMapping
    @Transactional(timeout = 2)
    public ResponseEntity notification() {
        List evn = eventsRunner.findEvents("2", "vin");
        return new ResponseEntity(evn, HttpStatus.OK);
    }

    @GetMapping("endpoints")
    public ResponseEntity<List<String>> getEndpoints() {
        return new ResponseEntity<>(
                requestMappingHandlerMapping
                        .getHandlerMethods()
                        .keySet()
                        .stream()
                        .map(RequestMappingInfo::toString)
                        .collect(Collectors.toList()),
                HttpStatus.OK
        );
    }

    @GetMapping("/external")
    public ResponseEntity<?> get() {
        String url = "https://reqres.in/api/users";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        ResponseEntity<?> rest = restTemplate.exchange(url, HttpMethod.GET, httpEntity, HashMap.class);
        return rest;
    }

    @RequestMapping(value = "/down", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> downloadFiles(@RequestParam List<Integer> ids) {

        MapSqlParameterSource parameters = new MapSqlParameterSource("ids", ids);

        String query="select * from images where id in(:ids)";
        List images = jdbcTemplate.query(query, parameters, (rs, rowNum) ->
                new Images(rs.getLong("id"),
                        rs.getBytes("data"),
                        rs.getString("title")));
        System.out.println(images);
        return ResponseEntity.status(HttpStatus.OK).body(images);

    }
    @RequestMapping(value = "/async", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save() {
        commonServices.process();
        return ResponseEntity.ok("success");
    }
}
