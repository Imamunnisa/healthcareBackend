package login;

import authentication.JwtTokenUtil;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pojo.LoginRequest;

@RestController
public class AuthenticationController {

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        // In a real-world app, you'd validate credentials from a database
        if ("user".equals(loginRequest.getUsername()) && "password".equals(loginRequest.getPassword())) {
            return JwtTokenUtil.generateToken(loginRequest.getUsername());
        }
        throw new RuntimeException("Invalid credentials");
    }

}

