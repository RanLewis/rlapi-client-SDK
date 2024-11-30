package com.ranlewis.rlapi.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.ranlewis.rlapi.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Ran Lewis
 * @Version 1.0
 * @Description 调用第三方接口客户端
 * @Date 2024/11/13 18:42
 */
public class RLAPIClient {

    private String assessKey;
    private String secretKey;

    public RLAPIClient(String assessKey, String secretKey) {
        this.assessKey = assessKey;
        this.secretKey = secretKey;
    }

    private Map<String, String> getSignMap(String body) {
        Map<String, String> map = new HashMap<>();
        map.put("assessKey", assessKey);
        map.put("nonce", RandomUtil.randomNumbers(4));
        map.put("body", body);
        map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("sign", getSign(body,secretKey));
        return map;
    }

    private String getSign(String body, String secretKey) {
        Digester digester = new Digester(DigestAlgorithm.SHA256);
        String content = body + secretKey;
        return digester.digestHex(content);
    }

    public String getUsername(User user) {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse response = HttpRequest.post("http://localhost:8123/name/user")
                .body(json)
                .addHeaders(getSignMap(json))
                .execute();
        if (response.isOk()) {
            return response.body();
        } else {
            throw new RuntimeException();
        }
    }
}
