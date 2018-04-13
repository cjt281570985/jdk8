package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-04-02 14:44
 */
public class TestTransaction {


    public static void main(String[] args) throws Exception {

       // Jedis jedis = new Jedis("192.168.241.1", 6379);
        Jedis jedis = new Jedis("10.10.10.238", 6379);
        jedis.auth("123456");
        System.out.println(jedis.ping());
//        Transaction tx = jedis.multi();
//
//        Thread.sleep(7000);
//        tx.set("k1", "9999");
//        tx.set("k2", "8888");
//
//        System.out.println(tx.exec());;


    }

}
