package com.action;

import java.util.ArrayList;
import java.util.List;

import com.bean.Permission;
import com.bean.Permissionservice;
import com.bean.Role;
import com.bean.RolePermission;
import com.bean.Service;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PermissionServiceService;
import com.service.RolePermissionService;


public class PermissionServiceAction extends ActionSupport
{
	private PermissionServiceService permissionservicesr = new PermissionServiceService();
	Permissionservice permissionservice;
	
	String option1;
	String option2;
	
	List<Permissionservice> permissionservices = new ArrayList<Permissionservice>();
	
	public PermissionServiceService getPermissionservicesr() {
		return permissionservicesr;
	}

	public void setPermissionservicesr(PermissionServiceService permissionservicesr) {
		this.permissionservicesr = permissionservicesr;
	}

	public Permissionservice getPermissionservice() {
		return permissionservice;
	}

	public void setPermissionservice(Permissionservice permissionservice) {
		this.permissionservice = permissionservice;
	}

	public List<Permissionservice> getPermissionservices() {
		return permissionservices;
	}

	public void setPermissionservices(List<Permissionservice> permissionservices) {
		this.permissionservices = permissionservices;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String addPermissionService()
	{
		try
		{
			permissionservice = new Permissionservice();
			Permission per=new Permission();
			per.setPermissionId(Integer.valueOf(option1));
			permissionservice.setPermission(per);
			Service service=new Service();
			service.setServiceId(Integer.valueOf(option2));
			permissionservice.setService(service);
			this.permissionservicesr.addPermissionService(permissionservice);
			return SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
	}
}