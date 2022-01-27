package ir.co.isc.querytimeout.controller;

import ir.co.isc.querytimeout.model.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final UserRepository userRepository;

    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String testTimeout() {
        try {
            userRepository.findByUsername("admin");
        } catch (RuntimeException e) {
            if (e.getMessage().startsWith("transaction timeout expired")) {
                return e.getMessage();
            }
        }
        return "query run without timeout.";
    }
}
