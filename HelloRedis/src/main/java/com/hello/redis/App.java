package com.hello.redis;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	
		Jedis jedis = new Jedis("localhost", 6379);
		// jedis.auth("admin");
		
		jedis.set("name", "hello");
		System.out.println(jedis.get("name"));
		
		jedis.close();
	}
}
