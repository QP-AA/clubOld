package com.jinwang.weixin.handler;

import com.jinwang.weixin.enums.WxChatMsgTypeEnum;

import java.util.Map;

/**
 * @Author jinwang
 * @Date 2024/10/27 20:04
 * @Version 1.0 （版本号）
 */
public interface WxChatMsgHandler {

    WxChatMsgTypeEnum getMsgType();

    String dealMsg(Map<String, String> msgMap);
}
