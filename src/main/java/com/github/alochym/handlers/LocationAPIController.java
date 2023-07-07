package com.github.alochym.handlers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.alochym.entities.Location;
import com.github.alochym.services.LocationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationAPIController {
    private LocationService locationService;

    public LocationAPIController(LocationService s) {
        this.locationService = s;
    }

    @PostMapping
    public ResponseEntity<Location> addLocation(@RequestBody @Valid Location l) {
        Location tempLocation = this.locationService.addLocation(l);
        return new ResponseEntity<Location>(tempLocation, this.customHttpHeaders(), HttpStatus.CREATED);
    }

    private HttpHeaders customHttpHeaders() {
        // custom headers response
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Server", "Spring Boot RESTful API");
        return headers;
    }
}
