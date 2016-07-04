package com.server.impl;

import java.util.Vector;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bean.ServerMsg;
import com.bean.User;
import com.server.IRestService;
import com.google.gson.Gson;

public class RestServiceimpl implements IRestService {

	public RestServiceimpl(){
		System.out.println("*******************************************AAAA************************");
	}
	
	static Vector<User> userList = new Vector<User>();

	static {
		userList.add(new User("0001", "Tom"));
	}

	@Override
	public User getUserInfo(String userId) {
		Gson gson = new Gson();
		for (User user : userList) {
			if (userId.equals(user.getId())) {
				System.out.println(gson.toJson(user));
				// return gson.toJson(user);
				return user;
			}
		}
		return null;
	}

	@Override
	public String getAllUserInfo() {
		Gson gson = new Gson();
		System.out.println(gson.toJson(userList));
		return gson.toJson(userList);
	}

	@Override
	public String addUserInfo(User user) {
		System.out.println("--------------------addUserInfo---------------");
		ServerMsg smsg = new ServerMsg();
		Gson gson = new Gson();
		if (checkUserInfo(user)) {
			if (checkHasUser(user) != null) {
				smsg.setCode("000002");
				smsg.setMsg("user does exist");
			} else {
				userList.add(new User(user.getId(), user.getName()));
				smsg.setCode("000000");
				smsg.setMsg("Add successful");
				// msg = "{\"code\":\"000000\",\"msg\":\"保存成功\"}";
			}
		} else {
			smsg.setCode("000001");
			smsg.setMsg("Format error");
		}
		return gson.toJson(smsg);
	}

	@Override
	public String updateUserInfo(User user) {
		System.out.println("--------------------updateUserInfo---------------");
		ServerMsg smsg = new ServerMsg();
		Gson gson = new Gson();
		if (checkUserInfo(user)) {
			smsg.setCode("000003");
			smsg.setMsg("user does not exist");
			for (User user1 : userList) {
				if (user1.getId().equals(user.getId())) {
					user1.setName(user.getName());
					smsg.setCode("000000");
					smsg.setMsg("Update successful");
				}
			}
		} else {
			smsg.setCode("000001");
			smsg.setMsg("Format error");
		}
		return gson.toJson(smsg);
	}

	@Override
	public String deleteAllUserInfo() {
		System.out.println("--------------------deleteUserInfo---------------");
		ServerMsg smsg = new ServerMsg();
		Gson gson = new Gson();
		userList.removeAllElements();
		smsg.setCode("000000");
		smsg.setMsg("Delete successful");
		// if(checkUserInfo(user)){
		// if(checkHasUser(user) != null){
		// userList.remove(user);
		// smsg.setCode("000000");
		// smsg.setMsg("删除成功");
		// }else{
		// smsg.setCode("000004");
		// smsg.setMsg("删除用户不存在");
		// }
		// }else{
		// smsg.setCode("000001");
		// smsg.setMsg("格式错误");
		// }
		return gson.toJson(smsg);
	}
	
	@Override
	public String deleteUserInfo(String userId) {
		ServerMsg smsg = new ServerMsg();
		Gson gson = new Gson();
		User user = checkHasUser(userId);
		if (user != null) {
			userList.remove(user);
			smsg.setCode("000000");
			smsg.setMsg("Delete successful");
		} else {
			smsg.setCode("000004");
			smsg.setMsg("删除用户不存在");
		}
		return gson.toJson(smsg);
	}

	public User checkHasUser(User user) {
		for (User user1 : userList) {
			if (user.getId().equals(user1.getId())) {
				return user;
			}
		}
		return null;
	}
	
	public User checkHasUser(String userId){
		for(User user1 : userList){
			if (user1.getId().equals(userId)){
				return user1;
			}
		}
		return null;
	}

	public boolean checkUserInfo(User user) {
		boolean flag = true;
		if ("".equals(user.getId()) || "".equals(user.getName())) {
			flag = false;
		}
		return flag;
	}

}
