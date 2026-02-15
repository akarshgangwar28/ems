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
            roleRepository.findByName(RoleType.ADMIN)
                    .orElseGet(() -> roleRepository.save(
                            Role.builder().name(RoleType.ADMIN).build()
                    ));

            // create EMPLOYEE role if not exists
            roleRepository.findByName(RoleType.EMPLOYEE)
                    .orElseGet(() -> roleRepository.save(
                            Role.builder().name(RoleType.EMPLOYEE).build()
                    ));
            roleRepository.findByName(RoleType.HR)
                    .orElseGet(() -> roleRepository.save(
                            Role.builder().name(RoleType.HR).build()
                    ));
            Role superAdmin = roleRepository.findByName(RoleType.SUPER_ADMIN)
                    .orElseGet(() -> roleRepository.save(
                            Role.builder().name(RoleType.SUPER_ADMIN).build()
                    ));
            roleRepository.findByName(RoleType.MANAGER)
                    .orElseGet(() -> roleRepository.save(
                            Role.builder().name(RoleType.MANAGER).build()
                    ));




            Role superAdminRole = roleRepository.findByName(RoleType.SUPER_ADMIN).get();

            if (userRepository.findByEmail("admin@ems.com").isEmpty()) {
                User admin = User.builder()
                        .email("admin@ems.com")
                        .password("admin123")
                        .firstName("System")
                        .lastName("Admin")
                        .role(superAdminRole)
                        .enabled(true)
                        .build();

                userRepository.save(admin);
                System.out.println("SUPER ADMIN CREATED");
            }
        };
    }
}
