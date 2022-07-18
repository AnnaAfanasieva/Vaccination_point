package ua.com.alevel.vaccination_point.config;

public interface SecurityService {

    boolean isAuthenticated();
    void autoLogin(String username, String password);
    boolean existsByEmail(String email);
}
