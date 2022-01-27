package ir.co.isc.querytimeout.controller;

import ir.co.isc.querytimeout.model.repository.UserRepository;
import org.springframework.dao.QueryTimeoutException;
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
            userRepository.timeout();
        } catch (QueryTimeoutException e) {
            return e.getMessage();
        }
        return "query run without timeout.";
    }
}
