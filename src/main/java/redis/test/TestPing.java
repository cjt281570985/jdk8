package redis.test;

import redis.clients.jedis.Jedis;

public class TestPing {
	public static void main(String[] args) 
	{
		Jedis jedis = new Jedis("192.168.141.133",6379);
		System.out.println(jedis.ping());
		System.out.println(jedis.get("k"));
	}
}
