package com.test.boot.controller;

import com.test.boot.config.CommonConfiguration;
import com.test.boot.config.SingletonBean;
import com.test.boot.models.Address;
import com.test.boot.models.Employee;
import com.test.boot.models.Planet;
import com.test.boot.models.Users;
import com.test.boot.service.PlanetService;
import com.test.praveen.EventsRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/common")
@RestController
public class CommonController {


    @Autowired
    CommonConfiguration commonConfiguration;

    @Autowired
    EventsRunner eventsRunner;

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    JdbcTemplate jdbcTemplate;
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
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @GetMapping("/check")
    public ResponseEntity singleton() {

        employee.setId(1L);
        employee.setName("Narahari");
        address.setCity("Hyderabad");
        employee.setAddress(address);

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
}
