package com.example.exceldemo.util;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author 59203
 */
@Slf4j
public class IdUtils {

    private static final String BEGIN_DATE = "2018-04-13 00:01:01";
    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static int incr = 0;
    private static LoadingCache<Long, AtomicLong> cache = CacheBuilder.newBuilder()
            //设置并发级别为100，并发级别是指可以同时写缓存的线程数
            .concurrencyLevel(100)
            //设置写缓存后60秒钟过期
            .expireAfterWrite(60, TimeUnit.SECONDS)
            //设置缓存容器的初始容量
            .initialCapacity(100)
            //最大容量
            .maximumSize(10000)
            .build(
                    new CacheLoader<Long, AtomicLong>() {
                        @Override
                        public AtomicLong load(Long s) {
                            return new AtomicLong(1L);
                        }
                    }
            );

    public static Long getId() {
        long time = 0;
        try {
            time = getTime();
        } catch (Exception e) {
            log.error("获取时间的计算失败", e);
            throw new RuntimeException("获取Id异常", e);
        }
        incr = (incr + 1) % 10;
        return Long.valueOf(time + "" + incr);
    }

    private static long getTime() throws ExecutionException, ParseException {
        long start = DateUtils.parseDate(BEGIN_DATE, PATTERN).getTime() / 1000;
        long time = System.currentTimeMillis() / 1000 - start;
        long limit = time + 10;
        while (time < limit) {
            long andIncrement = cache.get(time).getAndIncrement();
            if (andIncrement >= 10) {
                time += 1;
                continue;
            }
            break;
        }
        return time;
    }
}
