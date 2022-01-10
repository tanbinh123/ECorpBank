package com.ecorp.bank.registration.controllers;

import com.ecorp.bank.appuser.AppUser;
import com.ecorp.bank.registration.RegistrationRequest;
import com.ecorp.bank.registration.RegistrationService;
import com.ecorp.bank.registration.repository.RegistrationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    @Autowired
    private RegistrationRepository registrationRepository;
    private RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

//    @RequestMapping(value = "/register", method = RequestMethod.GET)
//    public String register() {
//        return "register";
//    }
//
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public String register(AppUser appUser) {
//        registrationRepository.save(appUser);
//        return "redirect:/login";
//    }
}
