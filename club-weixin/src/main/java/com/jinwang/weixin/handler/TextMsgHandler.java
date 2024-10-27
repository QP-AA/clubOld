package com.jinwang.weixin.handler;

import com.jinwang.utils.RedisUtil;
import com.jinwang.weixin.enums.WxChatMsgTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @Author jinwang
 * @Date 2024/10/27 20:16
 * @Version 1.0 （版本号）
 */
@Component
@Slf4j
public class TextMsgHandler implements WxChatMsgHandler{

    private static final String KEY_WORD = "验证码";

    private static final String LOGIN_PREFIX = "loginCode";

    @Resource
    private RedisUtil redisUtil;

    @Override
    public WxChatMsgTypeEnum getMsgType() {
        return WxChatMsgTypeEnum.TEXT_MSG;
    }

    @Override
    public String dealMsg(Map<String, String> msgMap) {
        log.info("接收文本消息");
        String content = msgMap.get("Content");
        String fromUserName = msgMap.get("FromUserName");
        String toUserName = msgMap.get("ToUserName");

        if (!StringUtils.equals(KEY_WORD, content)) {
            //todo 接入大模型？
            String ansContent = "目前还无法理解您的问题哦~";
            return buildReplyXml(fromUserName, toUserName, ansContent);
        }

        int code = ThreadLocalRandom.current().nextInt(1000, 10000);
        String codeKey = redisUtil.buildKey(LOGIN_PREFIX, String.valueOf(code));
        redisUtil.setNx(codeKey, fromUserName, 5L, TimeUnit.MINUTES);
        String numContent = "您当前的验证码是：" + code + ", 5分钟内有效";
        return buildReplyXml(fromUserName, toUserName, numContent);
    }

    private String buildReplyXml(String fromUserName, String toUserName, String content) {
        return "<xml>\n" +
                "  <ToUserName><![CDATA[" + fromUserName + "]]></ToUserName>\n" +
                "  <FromUserName><![CDATA[" + toUserName + "]]></FromUserName>\n" +
                "  <CreateTime>12345678</CreateTime>\n" +
                "  <MsgType><![CDATA[text]]></MsgType>\n" +
                "  <Content><![CDATA[" + content + "]]></Content>\n" +
                "</xml>";
    }
}
