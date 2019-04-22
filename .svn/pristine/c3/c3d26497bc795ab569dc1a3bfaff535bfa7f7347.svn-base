package test.SpringMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.UUID;

import com.lee.utils.RedisPool;


@Controller
@RequestMapping("/mvc")
public class MvcController {
 
    @RequestMapping("/hello")
    public String hello(){
    	
        return "hello";
    }
    
   /* public static void main(String[] args) {
    	//连接本地的 Redis 服务
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //权限认证
        jedis.auth("12345");
        System.out.println("连接成功");
        //设置 redis 字符串数据
//        jedis.set("test", "redis-test");
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.get("test"));
	}*/
    public static void main(String[] args) {
    	RedisPool.getJedis().set("name","lee");
//    	RedisPool.getJedis().del("name");
        System.out.println("show:"+RedisPool.getJedis().get("name"));
	}/*
    public static void main(String[] args) {
    	UUID uuid = UUID.randomUUID();
    	System.out.println(uuid);
	}*/
}