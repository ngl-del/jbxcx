package com.jb.xcx.gzh;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MaterialTest {

    @Test
    public void testGetMaterial() throws JSONException {
        Token token = CommonUtil.getToken(WeChatConfig.APP_ID,WeChatConfig.APP_SECRET);//获取接口访问凭证access_token
        List<Material> lists = CommonUtil.getMaterial(token.getAccessToken(),"news",0,10);//调用获取素材列表的方法
        System.out.println(lists.size());//输出
    }
}