package com.example.tongyi_demo.domain;

import java.util.HashMap;
import java.util.Map;

public class QuestionAnswerMapper {
    private static final Map<String, String> QUESTION_ANSWER_MAP = new HashMap<>();

    static {
        QUESTION_ANSWER_MAP.put("你好吗？", "我是一个AI，所以我不会感受到疲劳或情绪，但很高兴能帮助你！");
        QUESTION_ANSWER_MAP.put("你是谁？", "我是智云书坊的机器人助手，可以帮助你解答问题和推荐书籍。");
        // 添加更多问题和答案映射...
    }

    public static String getSpecificReplyOrDefault(String question, ChatResponse chatResponse) {
        String reply = QUESTION_ANSWER_MAP.getOrDefault(question, chatResponse.getOutput().getText());
        return reply;
    }
}
