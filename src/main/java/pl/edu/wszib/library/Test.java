package pl.edu.wszib.library;

import org.apache.commons.codec.digest.DigestUtils;

public class Test {
    public static void main(String[] args) {
        String haslo = "maciek123";
        String hash = DigestUtils.md5Hex(haslo);
        System.out.println(hash);
    }
}
