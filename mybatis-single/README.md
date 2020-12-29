# Spring Boot 集成Mybatis

- 创建Spring Boot 基础项目
- 引入相关依赖
```xml
<!-- 引入mysql驱动-->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>

<!--引入mybatis依赖-->
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>2.1.4</version>
</dependency>
```
- 添加配置文件
```yaml

# 数据源配置
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:13306/mysql?characterEncoding=utf-8&useSSL=false
    username: root
    password: 123456

#mybatis的相关配置
mybatis:
  #mapper配置文件
  mapper-locations: classpath:mapper/*.xml
  type-aliases-package: com.joker.code.mybatis.single.entity
  #开启驼峰命名
  configuration:
    map-underscore-to-camel-case: true
```
- 编码
```sh
1. 在com.joker.code.mybaits.single下创建
controller、entity、mapper、service、service/impl文件夹
2. 在resources目录下创建mapper文件

3.创建UserController.class类
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

}

4.创建User实体类
@Data
@AllArgsConstructor
public class User implements Serializable {
    private Long id; // 编号
    private String username; // 用户名
    private String password; // 密码
}

5.创建UserService接口类

public interface UserService {

    List<User> findAll();
}

6.创建UserServiceImpl实现类
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}

7.编写UserMapper.xml文件
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.joker.code.mybatis.single.mapper.UserMapper">

    <select id="findAll" resultType="User">
        SELECT * FROM t_user
    </select>

</mapper>

8. 启动项目，访问http://localhost:8089/user/findAll进行测试

PS：数据库测试脚本
-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'laowang', '112233');
INSERT INTO `tb_user` VALUES ('2', 'laoli', '123456');
```