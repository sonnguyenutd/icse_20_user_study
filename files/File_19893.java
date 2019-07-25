package cc.mrbird.security.service;

import cc.mrbird.security.validate.smscode.SmsCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.concurrent.TimeUnit;

/**
 * Redis�?作验�?�?�?务
 */
@Service
public class RedisCodeService {

    private final static String SMS_CODE_PREFIX = "SMS_CODE:";
    private final static Integer TIME_OUT = 300;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * �?存验�?�?到 redis
     *
     * @param smsCode 短信验�?�?
     * @param request ServletWebRequest
     */
    public void save(SmsCode smsCode, ServletWebRequest request, String mobile) throws Exception {
        redisTemplate.opsForValue().set(key(request, mobile), smsCode.getCode(), TIME_OUT, TimeUnit.SECONDS);
    }

    /**
     * 获�?�验�?�?
     *
     * @param request ServletWebRequest
     * @return 验�?�?
     */
    public String get(ServletWebRequest request, String mobile) throws Exception {
        return redisTemplate.opsForValue().get(key(request, mobile));
    }

    /**
     * 移除验�?�?
     *
     * @param request ServletWebRequest
     */
    public void remove(ServletWebRequest request, String mobile) throws Exception {
        redisTemplate.delete(key(request, mobile));
    }

    private String key(ServletWebRequest request, String mobile) throws Exception {
        String deviceId = request.getHeader("deviceId");
        if (StringUtils.isBlank(deviceId)) {
            throw new Exception("请在请求头中设置deviceId");
        }
        return SMS_CODE_PREFIX + deviceId + ":" + mobile;
    }
}