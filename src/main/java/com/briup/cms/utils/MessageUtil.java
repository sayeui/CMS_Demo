package com.briup.cms.utils;

import java.util.Date;

public class MessageUtil {
    public static final Integer STATUS_OK=200;
    public static final Integer STATUS_ERROR=500;
    public static final Integer STATUS_NOTFIND=404;
    /**
     * 返回失败消息，一般用于增删改操作的结果返回
     * */
    public static Message error(String msg){
        Message message = new Message();
        message.setStatus(STATUS_ERROR);
        message.setMessage(msg);
        message.setTimestamp(new Date().getTime());
        return message;
    }

    /**
     * 返回成功消息，一般用于增删改操作的结果返回
     * */
    public static Message success(String msg){
        Message message = new Message();
        message.setStatus(STATUS_OK);
        message.setMessage(msg);
        message.setTimestamp(new Date().getTime());
        return message;
    }
    /**
     * 返回成功的消息，一般用于查询操作的结果返回
     * */
    public static<T> Message<T> success(T data){
        Message<T> message = new Message();
        message.setStatus(STATUS_OK);
        message.setMessage("success!");
        message.setData(data);
        message.setTimestamp(new Date().getTime());
        return message;
    }
    public static<T> Message<T> success(String msg, T data){
        Message<T> message = new Message();
        message.setStatus(STATUS_OK);
        message.setMessage(msg);
        message.setData(data);
        message.setTimestamp(new Date().getTime());
        return message;
    }

}
