package com.example.farmerGateway;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
 class Farmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private int age;
    private long contact;
    private long adharno;
    private int land;
    
    public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public long getAdharno() {
		return adharno;
	}
	public void setAdharno(long adharno) {
		this.adharno = adharno;
	}
	public int getLand() {
		return land;
	}
	public void setLand(int land) {
		this.land = land;
	}
	Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	private String location;
	private int group_id;

	public void addAttribute(String string, List<Farmer> farmers) {
		// TODO Auto-generated method stub
		
	}

    // Getters and setters
}

@Entity
class Cultivation {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String crop_name;
   private String period_of_cultivation;
   private int period_of_harvest;
   private int cultivation_land;
   private String require_pesticide;
   private Long overall_cost;
   private Long expected_yield;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getCrop_name() {
	return crop_name;
}
public void setCrop_name(String crop_name) {
	this.crop_name = crop_name;
}
public String getPeriod_of_cultivation() {
	return period_of_cultivation;
}
public void setPeriod_of_cultivation(String period_of_cultivation) {
	this.period_of_cultivation = period_of_cultivation;
}
public int getPeriod_of_harvest() {
	return period_of_harvest;
}
public void setPeriod_of_harvest(int period_of_harvest) {
	this.period_of_harvest = period_of_harvest;
}
public int getCultivation_land() {
	return cultivation_land;
}
public void setCultivation_land(int cultivation_land) {
	this.cultivation_land = cultivation_land;
}
public String getRequire_pesticide() {
	return require_pesticide;
}
public void setRequire_pesticide(String require_pesticide) {
	this.require_pesticide = require_pesticide;
}
public Long getOverall_cost() {
	return overall_cost;
}
public void setOverall_cost(Long overall_cost) {
	this.overall_cost = overall_cost;
}
public Long getExpected_yield() {
	return expected_yield;
}
public void setExpected_yield(Long expected_yield) {
	this.expected_yield = expected_yield;
}
   
	
}

@Entity
class groupdetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "group_id")
   private Long groupId;

   @Column(name = "id")
   private Long farmerId;
   
   @Column(name = "name")
   private Long farmername;

public Long getGroupId() {
	return groupId;
}

public void setGroupId(Long groupId) {
	this.groupId = groupId;
}

public Long getFarmerId() {
	return farmerId;
}

public void setFarmerId(Long farmerId) {
	this.farmerId = farmerId;
}

public Long getFarmername() {
	return farmername;
}

public void setFarmername(Long farmername) {
	this.farmername = farmername;
}
   
   
}

@Entity
class Admin {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String adminname;
   public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

public String getAdminname() {
	return adminname;
}
public void setAdminname(String adminname) {
	this.adminname = adminname;
}
public String getAdpassword() {
	return adpassword;
}
public void setAdpassword(String adpassword) {
	this.adpassword = adpassword;
}
private String adpassword;

}

@Entity
class StoreManager {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String storename;
   public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getStorename() {
	return storename;
}
public void setStorename(String storename) {
	this.storename = storename;
}
public String getStorepassword() {
	return storepassword;
}
public void setStorepassword(String storepassword) {
	this.storepassword = storepassword;
}
private String storepassword;
}