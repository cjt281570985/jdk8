package guava.io;

import com.google.common.io.BaseEncoding;
import org.junit.Test;

public class BaseEncodingTest {

    @Test
    public void testBase64Encode() {
        BaseEncoding baseEncoding = BaseEncoding.base64();
        System.out.println(baseEncoding.encode("hello".getBytes())); //aGVsbG8=
        System.out.println(baseEncoding.encode("a".getBytes())); //YQ==

        System.out.println(new String(baseEncoding.decode("aGVsbG8="))); //hello
    }
}
