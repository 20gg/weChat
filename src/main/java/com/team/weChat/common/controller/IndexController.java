package com.team.weChat.common.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.weChat.common.model.WeChat;
import com.team.weChat.common.service.SysUserManager;
import com.team.weChat.util.PageHelp;

/**
 * @category index页面
 * @author yxc
 */
@Controller
public class IndexController  {
	private final static Logger log = Logger.getLogger(IndexController.class);

	@Autowired
	private SysUserManager sysUserManager;

	@Autowired
	private HttpServletRequest request;
			
	@Autowired
	private HttpSession session;

	@Value("${json.data.url}")
	private String url;

	/**
	 * @category 查询菜单列表并跳转index页面
	 * @param session
	 * @param model
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@RequestMapping("/index")
	public String index(Model model)
			throws JsonParseException, JsonMappingException, IOException {
		log.info("成功获取你的名字：" + sysUserManager.getName("1"));
		ObjectMapper mapper = new ObjectMapper();
		String root = IndexController.class.getClassLoader().getResource("55.json").getPath();
		WeChat[] list = mapper.readValue(new File(root), WeChat[].class);
		model.addAttribute("data", Arrays.asList(list).subList(0, 10));
		return "/index";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/getWeChatData")
	@ResponseBody
	public Map<String, List<WeChat>> getWeChatData(Integer  currentPage){
		Map<String, List<WeChat>> map = new HashMap<String, List<WeChat>>();
		ObjectMapper mapper = new ObjectMapper();
		//redis缓存取值
		log.info("第二次获取：" + sysUserManager.getName("1"));
		try {
			String root = session.getServletContext().getRealPath(url);
			WeChat[] array = mapper.readValue(new File(root), WeChat[].class);
			List<WeChat> list =(List<WeChat>) PageHelp.getPageList(Arrays.asList(array), currentPage, 10, (array.length / 10) + 1);
			map.put("data", list );
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return map;
	}

}
