package com.bd17kaka.kankantu.worker;

import redis.clients.jedis.Jedis;

public class repost {

	private static String apiKey = "3790992882";
	private static String apiSecret = "fa1b2986b8fcb881802c7ac811ef2d33";
	private static String redisPassword = "199111@0Smy";
	private static String redisHost = "69.85.92.97";
	private static int redisPort = 6397;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 获取redis对象
//		Jedis jedis = new Jedis(redisHost, redisPort);
//		jedis.auth(redisPassword);
		
//		System.out.println(jedis.lpop("weibo:default:default"));
		System.out.println("123");
	}

}
