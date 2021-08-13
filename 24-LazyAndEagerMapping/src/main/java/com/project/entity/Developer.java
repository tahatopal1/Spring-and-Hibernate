package com.project.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "developer")
public class Developer {
	
	public Developer() { }

	public Developer(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "developer", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<BusinessDomain> businessDomainList;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "developer", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<BusinessTech> businessTechList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<BusinessDomain> getBusinessDomainList() {
		return businessDomainList;
	}

	public void setBusinessDomainList(List<BusinessDomain> businessDomainList) {
		this.businessDomainList = businessDomainList;
	}

	public List<BusinessTech> getBusinessTechList() {
		return businessTechList;
	}

	public void setBusinessTechList(List<BusinessTech> businessTechList) {
		this.businessTechList = businessTechList;
	}

	public void addDomain(BusinessDomain businessDomain) {
		if (businessDomainList == null) {
			businessDomainList = new ArrayList<BusinessDomain>();
		}
		
		businessDomain.setDeveloper(this);
		businessDomainList.add(businessDomain);
	}
	
	public void addTech(BusinessTech businessTech) {
		if (businessTechList == null) {
			businessTechList = new ArrayList<BusinessTech>();
		}
		
		businessTech.setDeveloper(this);
		businessTechList.add(businessTech);
	}
	
	@Override
	public String toString() {
		return "Developer [id=" + id + ", name=" + name + ", surname=" + surname + ", businessDomainList="
				+ businessDomainList + ", businessTechList=" + businessTechList + "]";
	}
	
}
