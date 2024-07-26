package org.example;

import io.netty.handler.logging.LogLevel;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.logging.AdvancedByteBufFormat;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world!");

//		System.out.println(
//				HttpClient.create()
//						.doOnChannelInit((observer, channel, remoteAddress) ->
//								channel.pipeline()
//										.addFirst(new CustomLoggingHandler()))
//						.get()
//						.uri("https://httpbin.org/get")
//						.responseContent()
//						.aggregate()
//						.asString()
//						.block());

		System.out.println(
				HttpClient.create()
						.wiretap("outboundLogger", LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL)
						.get()
						.uri("https://httpbin.org/get")
						.responseContent()
						.aggregate()
						.asString()
						.block());

	}
}