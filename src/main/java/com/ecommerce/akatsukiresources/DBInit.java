package com.ecommerce.akatsukiresources;


import com.ecommerce.akatsukiresources.enums.Role;

import com.ecommerce.akatsukiresources.model.Appuser;
import com.ecommerce.akatsukiresources.model.VerificationToken;
import com.ecommerce.akatsukiresources.repository.AppUserRepo;
import com.ecommerce.akatsukiresources.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;



@Component
public class DBInit {

    @Autowired
    AppUserRepo appUserRepo;

    Appuser user;

    @Autowired
    VerificationService verificationService;


    public DBInit(AppUserRepo appUserRepo){
        this.appUserRepo = appUserRepo;
    }

    public DBInit() {
    }

    @Bean
    public CommandLineRunner initDb(){
        return args -> {
           Appuser user = appUserRepo.findByUsername("kene@afc.com");
           if(user.equals(null)){
               Appuser adminUser = new Appuser("William", "Ohia", "kene@afc.com", "mohawk", Role.admin);
               appUserRepo.save(adminUser);
               final VerificationToken verificationToken = new VerificationToken(adminUser);
               verificationService.storeVerifiedToken(verificationToken);
           }

        };
    }

}
