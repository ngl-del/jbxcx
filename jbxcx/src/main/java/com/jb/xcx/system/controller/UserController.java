package com.jb.xcx.system.controller;

import com.jb.xcx.base.BaseController;
import com.jb.xcx.base.Result;
import com.jb.xcx.constants.BaseEnums;
import com.jb.xcx.constants.Constants;
import com.jb.xcx.gzh.*;
import com.jb.xcx.system.dto.Article;
import com.jb.xcx.system.dto.User;
import com.jb.xcx.util.Dates;
import com.jb.xcx.util.Results;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import java.util.List;


/**
 * 用户Controller
 */
@RestController
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class UserController extends BaseController {

    private static List<User> userList = new ArrayList<>();

    // 先静态模拟数据
    static {
        User user1 = new User();
        user1.setUserId(1L);
        user1.setUsername("lufei");
        user1.setNickname("蒙奇D路飞");
        user1.setBirthday(Dates.parseDate("2000-05-05"));
        user1.setSex(Constants.Sex.MALE);
        user1.setEnabled(Constants.Flag.YES);
        userList.add(user1);

        User user2 = new User();
        user2.setUserId(2L);
        user2.setUsername("nami");
        user2.setNickname("娜美");
        user2.setBirthday(Dates.parseDate("2000/7/3"));
        user2.setSex(Constants.Sex.FEMALE);
        user2.setEnabled(Constants.Flag.YES);
        userList.add(user2);
    }

    @RequestMapping("/queryAll")
    public Result queryAll(){
        return Results.successWithData(userList, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }

    @RequestMapping("/queryOne/{userId}")
    public Result queryOne(@PathVariable Long userId){
        User user = null;
        for(User u : userList){
            if(u.getUserId().longValue() == userId){
                user = u;
            }
        }
        return Results.successWithData(user);
    }

    @RequestMapping("/getArticle")
    public void getArticle(){
//        Article article=new Article();
//        return Results.successWithStatus();
    }


    @RequestMapping("/testGetMaterial")
    public List<Material> testGetMaterial() throws JSONException {
        Token token = CommonUtil.getToken(WeChatConfig.APP_ID,WeChatConfig.APP_SECRET);//获取接口访问凭证access_token
        List<Material> lists = CommonUtil.getMaterial(token.getAccessToken(),"news",0,10);//调用获取素材列表的方法
        System.out.println(lists.size());//输出
        return lists;
    }



    /**
     * 获取素材列表
     */
  /*  public JSONObject getMaterialList(String type , int offset, int count) {
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=" + "";//ACCESS_TOKEN
        String outputStr = "";
        //POST请求发送的json参数
        Material material = new Material();
        material.setType(type);
        material.setOffset(offset);
        material.setCount(count);

        JSONObject jsonObject = new JSONObject();
        jsonObject = JSONObject.fromObject(material);
        System.out.println(jsonObject);

        outputStr = jsonObject.toString();

        new HttpRequestPost();
        jsonObject = HttpRequestPost.httpRequest(requestUrl, outputStr, "POST");
        return jsonObject;
        return null;
    }

*/
}
