package com.example.tongyi_demo.domain;

//这个是用来处理请求的
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatRequest {
    String model;
    Input input;
    Parameters parameters;

    public ChatRequest(String q){
        model  = "qwen-turbo";
        input = new Input(q);
        parameters = new Parameters();


    }
    class Input {
        public List<Chat> messages;
        Input(String q){
            ArrayList<ChatRequest.Chat> chats = new ArrayList<>();
            chats.add(new Chat("system","我是智云书坊——寓教售书平台的机器人哟~"));
            chats.add(new Chat("user",q));

            messages = chats;
        }



    }

    class Chat {
        public String role;
        public String content;
        Chat(String role,String content){
            this.role = role;
            this.content = content;
        }
    }

    class Parameters {
        public String result_format = "text";
    }
}
