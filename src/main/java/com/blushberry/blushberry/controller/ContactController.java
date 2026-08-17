package com.blushberry.blushberry.controller;

import com.blushberry.blushberry.entity.ContactMessage;
import com.blushberry.blushberry.repository.ContactMessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactController {

    @Autowired
    private ContactMessageRepository contactMessageRepository;


    // SEND CONTACT MESSAGE
    @PostMapping
    public ResponseEntity<?> sendMessage(
            @RequestBody ContactMessage contactMessage) {

        try {

            ContactMessage savedMessage =
                    contactMessageRepository.save(contactMessage);

            return ResponseEntity.ok(savedMessage);

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity
                    .internalServerError()
                    .body("Unable to save contact message.");
        }
    }


    // GET ALL CONTACT MESSAGES
    @GetMapping
    public ResponseEntity<?> getAllMessages() {

        try {

            return ResponseEntity.ok(
                    contactMessageRepository.findAll()
            );

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity
                    .internalServerError()
                    .body("Unable to load messages.");
        }
    }
    
 // DELETE CONTACT MESSAGE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable Long id) {

        try {

            if (!contactMessageRepository.existsById(id)) {

                return ResponseEntity
                        .notFound()
                        .build();
            }

            contactMessageRepository.deleteById(id);

            return ResponseEntity.ok(
                    "Message deleted successfully."
            );

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity
                    .internalServerError()
                    .body("Unable to delete message.");
        }
    }
}