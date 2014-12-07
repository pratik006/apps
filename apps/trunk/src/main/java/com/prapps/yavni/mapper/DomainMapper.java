package com.prapps.yavni.mapper;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.prapps.yavni.domain.Address;
import com.prapps.yavni.domain.BloodBank;
import com.prapps.yavni.domain.BloodStock;
import com.prapps.yavni.domain.Donor;
import com.prapps.yavni.domain.Organization;
import com.prapps.core.domain.Role;
import com.prapps.core.domain.User;
import com.prapps.yavni.dto.BloodTypes;
import com.prapps.yavni.dto.Event;
import com.prapps.yavni.util.YavniDateUtil;
import com.prapps.yavni.util.YavniUtil;

@Component
public class DomainMapper {

	private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	public BloodBank mapBloodBank(Map<String, String> map) {
		BloodBank bank = new BloodBank();
		bank.setBankId(getId(map, "bloodBankId"));
		bank.setName(map.get("bankName"));
		bank.setCmo(map.get("cmo"));
		bank.setAddress(mapAddress(map));
		return bank;
	}
	
	public com.prapps.yavni.dto.BloodBank mapBloodBank(BloodBank bloodBankDomain) {
		com.prapps.yavni.dto.BloodBank bank = null;
		if(null != bloodBankDomain) {
			bank = new com.prapps.yavni.dto.BloodBank();
			bank.setBankId(bloodBankDomain.getBankId());
			bank.setName(bloodBankDomain.getName());
			bank.setCmo(bloodBankDomain.getCmo());
			bank.setAddress(mapAddress(bloodBankDomain.getAddress()));
		}		
		return bank;
	}
	
	public BloodBank mapBloodBank(com.prapps.yavni.dto.BloodBank bloodBankDomain) {
		BloodBank bank = null;
		if(null != bloodBankDomain) {
			bank = new BloodBank();
			bank.setBankId(bloodBankDomain.getBankId());
			bank.setName(bloodBankDomain.getName());
			bank.setCmo(bloodBankDomain.getCmo());
			bank.setAddress(mapAddress(bloodBankDomain.getAddress()));
		}
		return bank;
	}

	public Address mapAddress(Map<String, String> map) {
		Address address = new Address();
		address.setAddressLine1(map.get("addressLine1"));
		address.setArea(map.get("area"));
		address.setEmail(map.get("email"));
		address.setMobilePhone(map.get("mob"));
		address.setOffPhone(map.get("offPhone"));
		address.setPin(map.get("pin"));
		address.setResidencePhone(map.get("resiPhone"));
		if (isNotNull(map, "otherCity")) {
			address.setCity(map.get("otherCity"));
		} else {
			address.setCity(map.get("city"));
		}
		address.setDistrict(map.get("district"));
		address.setState(map.get("state"));
		address.setCountry(map.get("country"));
		return address;
	}
	
	public Address mapAddress(com.prapps.yavni.dto.Address addressTO ) {
		Address address = null;
		if(null != addressTO) {
			address = new Address();
			address.setAddressLine1(addressTO.getAddressLine1());
			address.setArea(addressTO.getArea());
			address.setEmail(addressTO.getEmail());
			address.setMobilePhone(addressTO.getMobilePhone());
			address.setOffPhone(addressTO.getOffPhone());
			address.setPin(addressTO.getPin());
			address.setResidencePhone(addressTO.getResidencePhone());
			address.setCity(addressTO.getCity());
			address.setDistrict(addressTO.getDistrict());
			address.setState(addressTO.getState());
			address.setCountry(addressTO.getCountry());
		}
		return address;
	}
	
	public com.prapps.yavni.dto.Address mapAddress(com.prapps.yavni.domain.Address addressDomain) {
		com.prapps.yavni.dto.Address address = null;
		if(null != addressDomain) {
			address = new com.prapps.yavni.dto.Address();
			address.setAddressLine1(addressDomain.getAddressLine1());
			address.setArea(addressDomain.getArea());
			address.setEmail(addressDomain.getEmail());
			address.setMobilePhone(addressDomain.getMobilePhone());
			address.setOffPhone(addressDomain.getOffPhone());
			address.setPin(addressDomain.getPin());
			address.setResidencePhone(addressDomain.getResidencePhone());
			address.setCity(addressDomain.getCity());
			address.setDistrict(addressDomain.getDistrict());
			address.setState(addressDomain.getState());
			address.setCountry(addressDomain.getCountry());
		}
		return address;
	}

	public User mapUser(Map<String, String> map) {
		User user = new User();
		long userId = getId(map, "userId");
		if (userId > 0) {
			user.setUserId(userId);
		}
		user.setFirstName(map.get("firstName"));
		user.setLastName(map.get("lastName"));
		user.setUserName(map.get("userName"));
		user.setPassword(map.get("password"));
		user.setRoleStr(map.get("role"));
		Role role = new Role();
		// role.setName("CALL_CENTER_USER");
		role.setId(3);
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		user.setRoles(roles);
		return user;
	}
	
	public com.prapps.core.vo.User mapUser(User user) {
		com.prapps.core.vo.User userTO = new com.prapps.core.vo.User();
		userTO.setFirstName(user.getFirstName());
		userTO.setLastName(user.getLastName());
		userTO.setUserId(user.getUserId());
		userTO.setUserName(user.getUserName());
		userTO.setRoles(mapRoles(user.getRoles()));
		return userTO;
	}
	
	public Set<com.prapps.core.vo.Role> mapRoles(Collection<Role> roles) {
		Set<com.prapps.core.vo.Role> roleTOs = new HashSet<com.prapps.core.vo.Role>(roles.size());
		for(Role role : roles) {
			roleTOs.add(mapRole(role));
		}
		return roleTOs;
	}
	
	public com.prapps.core.vo.Role mapRole(Role role) {
		com.prapps.core.vo.Role roleTO = new com.prapps.core.vo.Role();
		roleTO.setId(role.getId());
		roleTO.setName(role.getName());
		return roleTO;
	}

	public Set<BloodStock> mapBloodStock(Map<String, String> map) {
		Set<BloodStock> bloodStocks = new HashSet<BloodStock>(3);
		BloodStock bloodStock = new BloodStock();
		bloodStock.setBatch("P-" + map.get("batch"));
		bloodStock.setBloodGroup(map.get("bloodGroup"));
		BloodBank bloodBank = new BloodBank();
		bloodBank.setBankId(getId(map, "bloodBankId"));
		bloodStock.setBloodBank(bloodBank);
		bloodStock.setReceivedDate(toDateTime(map, "receivedDate", "receivedTime"));
		bloodStock.setIssuedDate(toDateTime(map, "issueDate"));
		if (null != bloodStock.getReceivedDate()) {
			bloodStock.setExpiryDate(YavniUtil.getExpiryDate(bloodStock.getReceivedDate()));
		}
		bloodStock.setIssued(toBoolean(map, "deleted"));
		bloodStock.setCreatedTS(YavniUtil.getCurrentTimestamp());
		bloodStock.setUpdatedBy(map.get("userName"));
		bloodStock.setUpdatedTS(YavniUtil.getCurrentTimestamp());

		BloodStock rbc = bloodStock.clone();
		rbc.setBatch("R-" + map.get("batch"));
		rbc.setBloodType(BloodTypes.RBC.toString());
		bloodStocks.add(rbc);
		
		BloodStock wbc = bloodStock.clone();
		wbc.setBatch("W-" + map.get("batch"));
		wbc.setBloodType(BloodTypes.WBC.toString());
		bloodStocks.add(wbc);
		
		BloodStock plasma = bloodStock.clone();
		plasma.setBatch("P-" + map.get("batch"));
		plasma.setBloodType(BloodTypes.PLASMA.toString());
		bloodStocks.add(plasma);
		
		BloodStock platelets = bloodStock.clone();
		platelets.setBatch("T-" + map.get("batch"));
		platelets.setBloodType(BloodTypes.PLATELETS.toString());
		bloodStocks.add(platelets);
		return bloodStocks;
	}
	
	public BloodStock mapIssuePacket(Map<String, String> context) {
		BloodStock bloodStock = new BloodStock();
		bloodStock.setId(getId(context, "id"));
		bloodStock.setBatch(context.get("batch"));
		bloodStock.setPatientName(context.get("patientName"));
		bloodStock.setDoctorName(context.get("doctorName"));
		bloodStock.setHospitalName(context.get("hospitalName"));
		bloodStock.setBedNumber(context.get("bedNumber"));
		bloodStock.setRemarks(context.get("remarks"));
		return bloodStock;
	}

	public String[][] mapBloodPackets(List<BloodStock> bloodPackets) {
		String[][] response = new String[bloodPackets.size()][];
		int ctr = 0;
		for (BloodStock bloodPacket : bloodPackets) {
			response[ctr] = new String[6];
			response[ctr][0] = bloodPacket.getBloodGroup();
			response[ctr][1] = String.valueOf(bloodPacket.getCount());
			response[ctr][2] = YavniDateUtil.dateToString(bloodPacket.getReceivedDate());
			response[ctr][3] = bloodPacket.getBloodBank().getAddress().getPin();
			response[ctr][4] = bloodPacket.getBloodBank().getAddress().getAddressLine1();
			response[ctr][5] = bloodPacket.getBloodBank().getAddress().getMobilePhone();
		}
		return response;
	}

	public Donor mapDonor(Map<String, String> map) {
		Donor donor = new Donor();
		long donorId = getId(map, "donorId");
		if (donorId > 0) {
			donor.setDonorId(donorId);
		}
		donor.setFirstName(map.get("firstName"));
		donor.setLastName(map.get("lastName"));
		donor.setGender(map.get("gender"));
		donor.setBloodGroup(map.get("bloodGroup"));
		donor.setDateOfBirth(toDate(map, "dob"));
		donor.setLastDonationDate(toDate(map, "lastDonatedDate"));
		donor.setBp(map.get("bp"));
		donor.setHeight(map.get("height"));
		donor.setWeight(map.get("weight"));
		donor.setComments(map.get("comments"));
		donor.setAddress(mapAddress(map));
		return donor;
	}

	public Organization mapCamp(Map<String, String> map) {
		Organization camp = new Organization();
		long organizationId = getId(map, "organizationId");
		if (organizationId != -1) {
			camp.setOrganizationId(organizationId);
		}
		camp.setOrganizationName(map.get("organization"));
		camp.setCampDate(toDate(map, "date"));
		try {
			long bankId = Long.parseLong(map.get("bankId"));
			BloodBank bank = new BloodBank();
			bank.setBankId(bankId);
			camp.setBloodBank(bank);
		} catch (Exception e) {
			e.printStackTrace();
		}
		camp.setSecretaryName(map.get("secretaryName"));
		camp.setPresidentName(map.get("presidentName"));
		camp.setContactPerson(map.get("contactPerson"));
		camp.setAddress(mapAddress(map));
		camp.setComments(map.get("comments"));
		return camp;
	}

	public java.sql.Date toDate(Map<String, String> map, String key) {
		java.sql.Date dt = null;
		if (isNotNull(map, key)) {
			String strDate = map.get(key);
			try {
				dt = new java.sql.Date(df.parse(strDate).getTime());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dt;
	}

	public Timestamp toDateTime(Map<String, String> map, String key, String timeKey) {
		Timestamp dt = null;
		if (isNotNull(map, key)) {
			String strDate = map.get(key);
			String time = map.get(timeKey);
			try {
				if (YavniUtil.isNotNull(time)) {
					strDate = strDate + " " + time;
				} 
				else {
					strDate = strDate + " 00:00AM";
				}
				dt = YavniDateUtil.toDateTime(strDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dt;
	}

	public Timestamp toDateTime(Map<String, String> map, String key) {
		Timestamp dt = null;
		if (isNotNull(map, key)) {
			String strDate = map.get(key);
			try {
				dt = new Timestamp(df.parse(strDate).getTime());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dt;
	}

	public Boolean toBoolean(Map<String, String> map, String key) {
		Boolean bool = null;
		if (isNotNull(map, key)) {
			try {
				bool = Boolean.parseBoolean(map.get(key));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bool;
	}

	public Long getId(Map<String, String> map, String key) {
		if (isNotNull(map, key)) {
			try {
				long id = Long.parseLong(map.get(key));
				return id;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public boolean isNotNull(Map<String, String> map, String key) {
		return map.containsKey(key) && (null != map.get(key)) && (!map.get(key).isEmpty());
	}
	
	public Collection<com.prapps.core.vo.User> mapUsers(Collection<User> userDomains) {
		Collection<com.prapps.core.vo.User> users = new ArrayList<com.prapps.core.vo.User>(userDomains.size());
		for(User user : userDomains) {
			users.add(new com.prapps.core.vo.User(user));
		}
		return users;
	}
	
	public Collection<com.prapps.yavni.dto.BloodBank> mapBloodBanks(Collection<BloodBank> bankDomains) {
		Collection<com.prapps.yavni.dto.BloodBank> banks = new ArrayList<com.prapps.yavni.dto.BloodBank>(bankDomains.size());
		for(BloodBank bank : bankDomains) {
			banks.add(new com.prapps.yavni.dto.BloodBank(bank));
		}
		return banks;
	}
	
	public Collection<com.prapps.yavni.dto.Organization> mapOrganizations(Collection<Organization> organizationDomains) {
		Collection<com.prapps.yavni.dto.Organization> organizations = new ArrayList<com.prapps.yavni.dto.Organization>(organizationDomains.size());
		for(Organization organization : organizationDomains) {
			organizations.add(new com.prapps.yavni.dto.Organization(organization));
		}
		return organizations;
	}
	
	public com.prapps.yavni.domain.Event mapEvent(Event event) {
		com.prapps.yavni.domain.Event event2 = new com.prapps.yavni.domain.Event();
		event2.setActivityDate(event.getActivityDate());
		event2.setActivityLocation(mapAddress(event.getActivityLocation()));
		BloodBank bloodBankDomain = new BloodBank();
		bloodBankDomain.setBankId(event.getBloodBankId());
		event2.setBloodBank(bloodBankDomain);
		event2.setExpectedDonorCount(event.getExpectedDonorCount());
		event2.setFulfilment(event.getFulfilment());
		Organization organizationDomain = new Organization();
		organizationDomain.setOrganizationId(event.getOrganizationId());
		event2.setOrganization(organizationDomain);
		event2.setRequirement(event.getRequirement());
		return event2;
	}

	public com.prapps.yavni.domain.Organization mapOrganization(com.prapps.yavni.dto.Organization organizationTO) {
		Organization organization = new Organization();
		organization.setOrganizationId(organizationTO.getOrganizationId());
		organization.setOrganizationName(organizationTO.getOrganizationName());
		organization.setBloodBank(mapBloodBank(organizationTO.getBloodBank()));
		if(null != organizationTO.getRegistrationDate()) {
			organization.setRegistrationDate(new java.sql.Date(organizationTO.getRegistrationDate().getTime()));
		}
		organization.setPresidentName(organizationTO.getPresidentName());
		organization.setSecretaryName(organizationTO.getSecretaryName());
		organization.setContactPerson(organizationTO.getContactPerson());
		organization.setComments(organizationTO.getComments());
		organization.setRegistrationDate(new java.sql.Date(YavniUtil.getCurrentDate().getTime()));
		Calendar cal = Calendar.getInstance();
		cal.setTime(organization.getRegistrationDate());
		String state = "";
		if(null != organization.getAddress()) {
			state = organization.getAddress().getState();
		}
		organization.setOrganizationCode("YAV/"+cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"/"+state+"/"+organization.getOrganizationId());
		return organization;
	}
	
	public com.prapps.yavni.dto.Organization mapOrganization(Organization organizationDomain) {
		com.prapps.yavni.dto.Organization organization = new com.prapps.yavni.dto.Organization();
		organization.setOrganizationId(organizationDomain.getOrganizationId());
		organization.setOrganizationName(organizationDomain.getOrganizationName());
		organization.setBloodBank(mapBloodBank(organizationDomain.getBloodBank()));
		organization.setRegistrationDate(organizationDomain.getRegistrationDate());
		organization.setPresidentName(organizationDomain.getPresidentName());
		organization.setSecretaryName(organizationDomain.getSecretaryName());
		organization.setContactPerson(organizationDomain.getContactPerson());
		organization.setComments(organizationDomain.getComments());
		organization.setRegistrationDate(new Date());
		Calendar cal = Calendar.getInstance();
		cal.setTime(organization.getRegistrationDate());
		String state = "";
		if(null != organization.getAddress()) {
			state = organization.getAddress().getState();
		}
		organization.setOrganizationCode("YAV/"+cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"/"+state+"/"+organization.getOrganizationId());
		return organization;
	}
	
	public Event mapEvent(com.prapps.yavni.domain.Event eventDomain) {
		Event event2 = new Event();
		event2.setEventId(eventDomain.getEventId());
		event2.setActivityDate(eventDomain.getActivityDate());
		event2.setActivityLocation(mapAddress(eventDomain.getActivityLocation()));
		event2.setBloodBank(mapBloodBank(eventDomain.getBloodBank()));
		event2.setExpectedDonorCount(eventDomain.getExpectedDonorCount());
		event2.setFulfilment(eventDomain.getFulfilment());
		event2.setOrganization(mapOrganization(eventDomain.getOrganization()));
		event2.setRequirement(eventDomain.getRequirement());
		return event2;
	}
}
