package guava.io;

import com.google.common.base.Preconditions;

public class Base64 {

    private final static String CODE_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private final static char[] CODE_DICT = CODE_STRING.toCharArray();

    private Base64() {
    }

    public static String encode(String plain) {
        Preconditions.checkNotNull(plain);
        StringBuilder result = new StringBuilder();

        return result.toString();
    }

    public static String toBinary(String source) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {

        }

        return result.toString();
    }


    //a b   01100001   01100010

    public static void main(String[] args) {

        System.out.println(CODE_DICT);


    }
}
