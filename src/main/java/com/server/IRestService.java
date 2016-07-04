package com.server;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bean.User;

@WebService
public interface IRestService {
	
	/**
	 * 获取用户信息
	 * @param userId 用户编号
	 * @return
	 */
	@GET
	@Path("/getUserInfo/{userId}")
	@Produces({MediaType.APPLICATION_JSON})
	public User getUserInfo(@PathParam("userId") String userId);
	
	/**
	 * 获取所有用户编号
	 * @return
	 */
	@GET
	@Path("/getAllUserInfo")
	@Produces({MediaType.APPLICATION_JSON})
	public String getAllUserInfo();
	
	/**
	 * 添加用户信息
	 * @param user 用户对象
	 * @return
	 */
	@POST
	@Path("/addUserInfo")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public String addUserInfo(User user);
	
	/**
	 * 更新用户信息
	 * @param user 用户对象 
	 * @return
	 */
	@PUT
	@Path("/updateUserInfo")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public String updateUserInfo(User user);
	
	/**
	 * 删除所有用户信息
	 * @return
	 */
	@DELETE
	@Path("/deleteUserInfo")
	@Consumes({MediaType.APPLICATION_JSON})
	public String deleteAllUserInfo();
	
	/**
	 * 删除单个用户信息
	 * @param userId 用户编号
	 * @return
	 */
	@DELETE
	@Path("/deleteUserInfo/{userId}")
	@Consumes({MediaType.APPLICATION_JSON})
	public String deleteUserInfo(@PathParam("userId") String userId);
	
	
}
