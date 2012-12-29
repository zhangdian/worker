package com.bd17kaka.kankantu.worker;

import redis.clients.jedis.Jedis;

import com.bd17kaka.kankantu.weibo4j.Timeline;
import com.bd17kaka.kankantu.weibo4j.model.WeiboException;

public class repost {

	private static String apiKey = "3790992882";
	private static String apiSecret = "fa1b2986b8fcb881802c7ac811ef2d33";
	private static String redisPassword = "199111@0Smy";
	private static String redisHost = "69.85.92.97";
	private static int redisPort = 6379;
	/**
	 * @param args
	 * @throws WeiboException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException  {
		// 获取redis对象
		Jedis jedis = new Jedis(redisHost, redisPort);
		jedis.auth(redisPassword);
		
		while (true) {
			// 等待5秒钟再转发
			Thread.sleep(900000);
			
			// 获取token
			String token = jedis.get("weibo:token");
			if (null == token) {
				continue;
			}
			
			// 获取微博
			String key = jedis.lpop("weibo:default:default");
			if (key == null) {
				continue;
			}
			Timeline timeLine = new Timeline();
			timeLine.setToken(token);
			// 转发微博
			try {
				timeLine.Repost(key);
				System.out.println("转发微博成功:" + key);
			} catch (WeiboException e) {
				System.out.println(e.getMessage());
				continue;
			}
		}
	}
}
