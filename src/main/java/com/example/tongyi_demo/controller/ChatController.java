package com.example.tongyi_demo.controller;


import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;


import cn.hutool.json.ObjectMapper;
import com.example.tongyi_demo.domain.ChatRequest;
import com.example.tongyi_demo.domain.ChatResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//还需要引入下面两个domain类

@RestController
public class ChatController {
    @PostMapping("/chat")//文档要求使用post请求
    public ChatResponse chat(@RequestBody String q){
        String url = " https://dashscope.aliyuncs.com/api/v1/services/aigc/text-generation/generation";//这里看官方文档
        String ApiKey = "sk-54d2c7532225455f817723a68fd92bc7";//这里换成你自己的ApiKey

        System.out.println("@@@"+q+"@@@");
        ChatRequest chatRequest = new ChatRequest(q);
        String json = JSONUtil.toJsonStr(chatRequest);
        System.out.println(json);//正式发送给api前,查看请求的主要数据情况
        String result = HttpRequest.post(url).header("Authorization","Bearer "+ ApiKey).header("Content-Type","application/json").body(json).execute().body();


        System.out.println("!@#$"+result);

        ChatResponse chatResponse = JSONUtil.toBean(result, ChatResponse.class);
        System.out.println(chatResponse);

        JSONObject jsonObj = JSONUtil.parseObj(q);
        String userQuestion =jsonObj.getStr("q");
        System.out.println(userQuestion);


        if("你是谁".equals(userQuestion)){
            chatResponse.getOutput().setText("我是智云书坊——寓教售书平台的机器人哟~");
        }
        if("向我推荐你们书店的书籍".equals(userQuestion)){
            chatResponse.getOutput().setText("这里向您推荐我们书店的《红楼梦》和《西游记》，它们深受我们店里用户的喜爱~");
        }
        if("我是男大学生，喜欢军事相关的书籍".equals(userQuestion)){
            chatResponse.getOutput().setText("因为您是男大学生并且喜欢军事相关的书籍，那么这里我推荐您购入本店的《步枪之王AK-47：俄罗斯的象征》或者《黄埔对决》");
        }
        if("我是女大学生，喜欢文学相关的书籍".equals(userQuestion)){
            chatResponse.getOutput().setText("因为您是女大学生并且喜欢文学相关的书籍，那么这里我推荐您购入本店的《寻常百姓家》或者《慕尼黑》");
        }
        if("介绍一下你们店里的《黄埔对决》".equals(userQuestion)){
            chatResponse.getOutput().setText("黄埔军校是在苏共、中共的帮助下，由孙中山先生于1924年创办的新型陆军军官学校，其广大师生日后成为中国现代化军队的主干。本书在扎实史料的基础上结合最近解密的文献资料，叙述了1924～1949年黄埔师生在校时期的政治斗争和毕业后的战场对决，如东征、北伐、内战、抗战和解放时期的国共将领的各场战役、战斗。他们斗智斗勇的对决，不仅决定两党和国家的命运，而且彰显了中国现代军事史的灿烂篇章。");
        }







        return chatResponse;

    }
}




