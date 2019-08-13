package com.jb.xcx.gzh;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;

/**
 * 凭证
 * access_token
 * @author Admin
 *
 */
public class Token {
    // 接口访问凭证
    private String accessToken;
    // 凭证有效期，单位：秒
    private int expiresIn;

    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public int getExpiresIn() {
        return expiresIn;
    }
    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Test
    public void testGetToken2() throws JSONException {
        //其中的WeChatConfig方法中有定义的自己微信公众号的appid和appsecret值 用到时直接调用
        Token token = CommonUtil.getToken(WeChatConfig.APP_ID,WeChatConfig.APP_SECRET);

        System.out.println("access_token:"+token.getAccessToken());
        System.out.println("expires_in:"+token.getExpiresIn());
    }
}
