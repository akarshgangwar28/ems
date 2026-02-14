package com.akarsh.ems.config;

import com.akarsh.ems.entity.Role;
import com.akarsh.ems.entity.RoleType;
import com.akarsh.ems.entity.User;
import com.akarsh.ems.repository.RoleRepository;
import com.akarsh.ems.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Bean
    CommandLineRunner initRolesAndAdmin() {
        return args -> {

            // create ADMIN role if not exists
            Role adminRole = roleRepository.findByName(RoleType.ADMIN)
                    .orElseGet(() -> roleRepository.save(
                            Role.builder().name(RoleType.ADMIN).build()
                    ));

            // create EMPLOYEE role if not exists
            roleRepository.findByName(RoleType.EMPLOYEE)
                    .orElseGet(() -> roleRepository.save(
                            Role.builder().name(RoleType.EMPLOYEE).build()
                    ));

            // create default admin user
            if (userRepository.findByEmail("admin@ems.com").isEmpty()) {
                User admin = User.builder()
                        .email("admin@ems.com")
                        .password("admin123") // plain password for now
                        .role(adminRole)
                        .enabled(true)
                        .build();

                userRepository.save(admin);
                System.out.println("ADMIN USER CREATED: admin@ems.com / admin123");
            }
        };
    }
}
