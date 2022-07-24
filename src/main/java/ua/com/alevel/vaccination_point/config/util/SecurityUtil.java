package ua.com.alevel.vaccination_point.config.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import ua.com.alevel.vaccination_point.model.util.RoleType;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public final class SecurityUtil {

    private SecurityUtil() {
    }

    public static String redirectUserToDashboard() {
        if (hasRole(RoleType.ROLE_MAIN_ADMIN)) {
            return "redirect:/main_admin/dashboard";
        } else if (hasRole(RoleType.ROLE_POINT_ADMIN)) {
            return "redirect:/point_admin/dashboard";
        } else if (hasRole(RoleType.ROLE_DOCTOR)) {
            return "redirect:/doctor/dashboard";
        }
        return "redirect:/login";
    }

    private static String convertRoleName(String role) {
        Pattern pattern = Pattern.compile("_");
        String[] roleNameArray = pattern.split(role);
        StringBuilder roleName = new StringBuilder();
        for (int i = 1; i < roleNameArray.length; i++) {
            roleName.append(roleNameArray[i]);
        }
        return roleName.toString();
    }

    public static boolean hasRole(RoleType role) {
        Authentication authentication = SecurityUtil.getAuthentication();
        AtomicBoolean result = new AtomicBoolean(false);
        authentication.getAuthorities().forEach(authority ->
                result.set(authority.getAuthority().equalsIgnoreCase(convertRoleName(role.name()))));
        return result.get();
    }

    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static String getUsername() {
        Authentication authentication = SecurityUtil.getAuthentication();
        User principal = (User) authentication.getPrincipal();
        return principal.getUsername();
    }
}
