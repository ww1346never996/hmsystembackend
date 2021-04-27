package org.hmsystem.server.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Random;

@Component
public class OrderNumUtils {
    public int getOrderNum() {
        // 获得系统时间，作为生成随机数的种子
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmsSSSS");
        long seed = System.currentTimeMillis();
        // 调用种子生成随机数
        Random random = new Random(seed);
        int rand = random.nextInt();
        if (rand < 0) {
            rand = rand * -1;
        }
        return rand;
    }
}
