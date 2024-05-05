package com.example.tongyi_demo.domain;

//这个是用来处理响应的
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatResponse {
    Output output;
    Usage usage;
    String request_id;

    @Data
   public static class Output{
        public String text;
        public String finish_reason;


    }

    @Data
   public static class Usage{
        public String output_tokens;
        public String input_tokens;
    }


}
