import com.demo.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * SPring data Redis 测试
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= App.class)
public class RedisTest {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    //添加一个字符串
    @Test
    public void testSet(){
        this.redisTemplate.opsForValue().set("key","测试value能不能插入redis");
    }

    @Test
    public void testGet(){
        String value=(String) this.redisTemplate.opsForValue().get("key");
        System.out.println(value);
    }
}
