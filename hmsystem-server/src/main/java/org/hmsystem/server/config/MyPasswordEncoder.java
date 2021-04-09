package org.hmsystem.server.config;


import org.hmsystem.server.config.MD5Util;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MyPasswordEncoder implements PasswordEncoder{

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(MD5Util.encode((String)rawPassword));
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return MD5Util.encode((String)rawPassword);
    }
}