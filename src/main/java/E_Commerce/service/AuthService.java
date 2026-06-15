package E_Commerce.service;

import E_Commerce.dto.LoginRequest;
import E_Commerce.dto.RegisterRequest;

public interface AuthService {

    String register(RegisterRequest request);

    String login(LoginRequest request);
}
