package com.citizens.citizensapi.controller;

import com.citizens.citizensapi.primary.entity.Citizens;
import com.citizens.citizensapi.repo.primary.CitizensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/citizens")
public class CitizenController {

    @Autowired
    private CitizensRepository citizenRepository;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllCitizens(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String sortDir) {

        // Default values if frontend not sending
        int pageNumber = (page != null) ? page : 0;
        int pageSize = (size != null) ? size : 100;
        String sortField = (sortBy != null) ? sortBy : "id";
        Sort.Direction direction = (sortDir != null && sortDir.equalsIgnoreCase("desc"))
                ? Sort.Direction.DESC
                : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(direction, sortField));

        Page<Citizens> citizenPage = citizenRepository.findAll(pageable);

        Map<String, Object> response = new HashMap<>();
        response.put("citizens", citizenPage.getContent());
        response.put("currentPage", citizenPage.getNumber());
        response.put("totalItems", citizenPage.getTotalElements());
        response.put("totalPages", citizenPage.getTotalPages());
        response.put("pageSize", citizenPage.getSize());

        return ResponseEntity.ok(response);
    }
}
