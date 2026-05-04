package com.trackingo.locationservice.service;

import com.trackingo.locationservice.model.Location;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class LocationService {

    private final Map<String, Location> locationMap = new ConcurrentHashMap<>();

    public void updateLocation(Location location) {
        locationMap.put(location.getUserId(), location);
    }

    public Location getLocation(String userId) {
        return locationMap.get(userId);
    }
}