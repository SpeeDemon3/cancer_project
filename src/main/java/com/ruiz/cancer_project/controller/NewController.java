package com.ruiz.cancer_project.controller;

import com.ruiz.cancer_project.controller.dto.NewRequestRecordDto;
import com.ruiz.cancer_project.service.NewService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/new")
@AllArgsConstructor
@Slf4j
public class NewController {

    private final NewService newService;

    @PostMapping("/add/{userId}")
    public ResponseEntity<?> addNew(@PathVariable Long userId, @RequestBody NewRequestRecordDto newRequestRecordDto) {

        try {
            return ResponseEntity.ok(newService.save(userId, newRequestRecordDto));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("There is a problem with insert in database.");
        }

    }

    @GetMapping("/{newId}")
    public ResponseEntity<?> getnewById(@PathVariable Long newId) {

        try {
            return ResponseEntity.ok(newService.findById(newId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("New not found with id: " + newId);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {

        try {
            return ResponseEntity.ok(newService.deleteByid(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }


}
