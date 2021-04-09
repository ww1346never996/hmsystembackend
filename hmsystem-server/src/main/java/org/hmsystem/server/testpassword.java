package org.hmsystem.server;

import org.hmsystem.server.config.MD5Util;

public class testpassword {
    public static void main(String[] args) {
        String encodedpassword = MD5Util.encode("123456");
        System.out.println(encodedpassword);
    }

}
