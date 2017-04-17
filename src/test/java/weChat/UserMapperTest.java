package weChat;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.team.weChat.demo.dto.User;
import com.team.weChat.demo.mapper.UserMapper;
import com.team.weChat.demo.service.IUserService;

/**
 * @author gg
 */
@ContextConfiguration(locations = {"classpath*:spring.xml","classpath*:spring-mybatis-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
//@Rollback
//@Transactional
public class UserMapperTest {
	
	    @Autowired
	    UserMapper userMapper;

	    @Autowired
	    IUserService userService;
	    
	    @Before
	    public void setUp(){
	    }

	    @Test
	    public void testprofile() throws Exception {
	    	User user = new User();
	    	List<User> list= null;
	    	user.setName("阿猫");
	    	user.setPassword("123");
	    	userMapper.insert(user);
	    	list = userMapper.getAllUser();
	    	assertNotNull(list);
	    	for (User user2 : list) {
	    		System.out.println(user2.toString());
			}
	    }

	    @Test
	    public void testService() throws Exception {
	    	User user = new User();
	    	List<User> list= null;
	    	user.setName("阿海");
	    	user.setPassword("321");
	    	userService.insert(user);
	    	System.out.println(user.getCreationDate());
	    	list = userService.selectAll();
	    	assertNotNull(list);
	    	for (User user2 : list) {
	    		System.out.println(user2.toString());
			}
	    }
	}
