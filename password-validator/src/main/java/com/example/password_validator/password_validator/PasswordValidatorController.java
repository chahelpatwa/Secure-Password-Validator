package com.example.password_validator.password_validator;

import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class PasswordValidatorController {

    private static final Logger logger = LoggerFactory.getLogger(PasswordValidatorController.class);

    @PostMapping("/validate")
    public String validatePassword(@RequestBody String password) {
        logger.info("Received password for validation: {}", password);
        String result = PasswordValidator.evaluatePasswordStrength(password);
        logger.info("Validation result: {}", result);
        return result;
    }
}