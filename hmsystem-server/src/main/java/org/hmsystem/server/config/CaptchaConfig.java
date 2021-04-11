package org.hmsystem.server.config;


import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;


@Configuration
public class CaptchaConfig {

    @Bean
    public DefaultKaptcha defaultKaptcha(){
        //验证码生成器
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        //配置
        Properties properties = new Properties();
        //是否有边框
        properties.setProperty("kaptcha.border", "yes");
        //设置边框颜色
        properties.setProperty("kaptcha.border.color", "105,179,90");
        //边框粗细度
        properties.setProperty("kaptcha.border.thickness", "1");
        //验证码
        properties.setProperty("kaptcha.session.key", "code");
        //验证码字体文本颜色
        properties.setProperty("kaptcha.textproducer.font.color", "blue");
        //验证码图片宽度
        properties.setProperty("kaptcha.image.width", "100");
        //验证码图片高度
        properties.setProperty("kaptcha.image.height", "40");
        //验证码长度
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
