package chapter3;

import com.google.common.cache.*;
import com.google.common.util.concurrent.Uninterruptibles;
import com.guava.study.TestTicker;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CacheTest {
    private LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .build(
                    new CacheLoader<String, String>() {
                        public String load(String key) {
                            return transformUpperCase(key);
                        }
                    });
    private RemovalListener<String, String> removalListener = new RemovalListener<String, String>() {
        public void onRemoval(RemovalNotification<String, String> removal) {
            System.out.println(removal.getKey()+" removal");
        }
    };
    TestTicker testTicker = new TestTicker();
    private Cache<String, String> cache = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(10, TimeUnit.SECONDS)
            .removalListener(removalListener)
            .recordStats()
            .ticker(testTicker)
            .build();
    private String transformUpperCase(String input) {
        return input.toUpperCase();
    }

    @Test
    public void test1() {
        try{
            loadingCache.put("key", "value");
            System.out.println(loadingCache.getUnchecked("key"));
            System.out.println(loadingCache.get("abc"));
        } catch (ExecutionException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test2() {
        System.out.println(loadingCache.getUnchecked("abc"));
    }

    @Test
    public void test3() {
        try {
            cache.put("key", "value");
            System.out.println(cache.get("key", new Callable<String>() {
                @Override
                public String call()  {
                    return transformUpperCase("key");
                }
            }));
            System.out.println(cache.get("abc", new Callable<String>() {
                @Override
                public String call()  {
                    return transformUpperCase("abc");
                }
            }));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        cache.put("abc", "ABC");
        cache.invalidate("abc");
        System.out.println(cache.asMap());
    }

    @Test
    public void test5() {
        cache.put("abc", "ABC");
        System.out.println(cache.asMap());
        Uninterruptibles.sleepUninterruptibly(20, TimeUnit.SECONDS);
        System.out.println(cache.asMap());
    }

    @Test
    public void test6() {
        System.out.println(cache.stats());
    }

    @Test
    public void test7(){
        cache.put("abc", "ABC");
        System.out.println(cache.asMap());
        testTicker.addElapsedTime(TimeUnit.NANOSECONDS.convert(10, TimeUnit.SECONDS));
        System.out.println(cache.asMap());
    }
}
