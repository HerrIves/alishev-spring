package de.ivev.FirstSecurityApp.services;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class SecurityAdminService {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void callAdmin(){
        System.out.println("admin called");
    }
}
