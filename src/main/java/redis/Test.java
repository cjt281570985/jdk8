package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @Author: chenjt
 * @Description:
 * @Date: Created 2018-04-02 14:20
 */
public class Test {


    public static void main(String[] args) throws Exception{

        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.watch("uamt");
        int amt = 1000;
        String um = jedis.get("uamt");
        System.out.println(um);
        int uamt = Integer.parseInt(um);
        if (uamt > amt) {
            System.out.println("消费超过总额度!");
            jedis.unwatch();

        } else {
            System.out.println("*********");
            Thread.sleep(5000);
            System.out.println(jedis.get("uamt"));
            Transaction transaction = jedis.multi();

            transaction.decrBy("uamt", 20);
            transaction.exec();

            System.out.println(jedis.get("uamt"));
        }


    }

}
