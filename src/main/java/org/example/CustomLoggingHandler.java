package org.example;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.logging.ByteBufFormat;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.nio.charset.StandardCharsets;

public class CustomLoggingHandler extends LoggingHandler {

    public CustomLoggingHandler() {

        super("outboundLogger", LogLevel.DEBUG, ByteBufFormat.SIMPLE);
        System.out.println("Creating outbound custom logger");
    }

    @Override
    protected String format(ChannelHandlerContext ctx, String eventName) {
        System.out.println("Format1");
        return super.format(ctx, eventName);
    }

    @Override
    protected String format(ChannelHandlerContext ctx, String eventName, Object firstArg, Object secondArg) {
        System.out.println("Format2");
        return super.format(ctx, eventName, firstArg, secondArg);
    }

    @Override
    protected String format(ChannelHandlerContext ctx, String event, Object arg) {
        System.out.println("Format3");
        if (arg instanceof ByteBuf) {
            ByteBuf msg = (ByteBuf) arg;
            return msg.toString(StandardCharsets.UTF_8);
        }
        return super.format(ctx, event, arg);
    }

    @Override
    public LogLevel level() {
        return LogLevel.DEBUG;
    }
}