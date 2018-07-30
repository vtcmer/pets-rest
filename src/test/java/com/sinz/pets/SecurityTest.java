package com.sinz.pets;


import com.sinz.pets.model.Pet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityTest {

    @Test
    public void generate(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String  st = encoder.encode("123456");
        System.out.println();
    }
}
