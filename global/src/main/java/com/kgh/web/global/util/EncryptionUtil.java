package com.kgh.web.global.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EncryptionUtil {
    private static final int ENCRYPTION_STRENGTH = 10;

    public static String encodeBcrypt(String password) {
        return new BCryptPasswordEncoder(ENCRYPTION_STRENGTH).encode(password);
    }

    public static boolean matchesBcrypt(String password, String hashValue) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(ENCRYPTION_STRENGTH);
        return passwordEncoder.matches(password, hashValue);
    }
}

