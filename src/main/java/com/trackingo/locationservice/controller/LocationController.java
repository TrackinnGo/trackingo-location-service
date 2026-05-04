package com.trackingo.locationservice.controller;

import com.trackingo.locationservice.model.Location;
import com.trackingo.locationservice.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
@CrossOrigin("*")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping
    public void updateLocation(@RequestBody Location location) {
        locationService.updateLocation(location);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Location> getLocation(@PathVariable String userId) {
        Location location = locationService.getLocation(userId);

        if (location == null) {
            return ResponseEntity.noContent().build(); // <-- important
        }

        return ResponseEntity.ok(location);
    }
}