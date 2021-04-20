package com.example.bakalaurinis_project.resource;

import com.example.bakalaurinis_project.model.LoginForm;
import com.example.bakalaurinis_project.model.RegistrationForm;
import com.example.bakalaurinis_project.model.Users;
import com.example.bakalaurinis_project.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@RestController
@RequestMapping(value = "/users")
public class UsersResource {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping(value = "/all")
    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map checkLogin(@RequestBody LoginForm loginForm) {
        Users user = usersRepository.findByUsernameAndPassword(loginForm.getUsername(), loginForm.getPassword());

        if (user != null) {
            return Collections.singletonMap("response", "Login successful");
        } else {
            return Collections.singletonMap("response", "Invalid data");
        }
    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map checkLogin(@RequestBody RegistrationForm registrationForm) {

        List<Users> users1 = usersRepository.findAllByUsername(registrationForm.getUsername());
        List<Users> users2 = usersRepository.findAllByEmail(registrationForm.getEmail());

        if (!users2.isEmpty()) {
            return Collections.singletonMap("response", "Naudotojo el. paštas užimtas");
        } else if (!isEmailCorrect(registrationForm.getEmail())) {
            return Collections.singletonMap("response", "El. paštas neatitinka struktūros");
        }

        if (!users1.isEmpty()) {
            return Collections.singletonMap("response", "Naudotojo slapyvardis užimtas");
        } else if (!isUsernameCorrect(registrationForm.getUsername())) {
            return Collections.singletonMap("response", "Slapyvardis neatitinka struktūros");
        }

        if (!isPasswordCorrect(registrationForm.getPassword())) {
            return Collections.singletonMap("response", "Slaptažodis neatitinka struktūros");
        }

        Users user = new Users(registrationForm.getUsername(), registrationForm.getEmail(),
                registrationForm.getPassword());
        usersRepository.save(user);

        return Collections.singletonMap("response", "Paskyra sukurta");
    }

    private boolean isEmailCorrect(String email) {
        return Pattern.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}" +
                "[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$", email);
    }

    private boolean isPasswordCorrect(String password) {
        return Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", password);
    }

    private boolean isUsernameCorrect(String username) {
        return username.length() >= 5;
    }
}
