package com.prapps.yavni.mapper;

import java.util.List;

import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;

import com.prapps.yavni.dto.BloodGroupData;

@Component
public class BloodGroupDataMapper implements ResultTransformer {

	private static final long serialVersionUID = 6770800589230377087L;

	@Override
	public Object transformTuple(Object[] tuple, String[] aliases) {		
		BloodGroupData bloodGroupData = (BloodGroupData) Transformers.aliasToBean(BloodGroupData.class).transformTuple(tuple, aliases);
		/*if(null != bloodGroupData.getRecent()) {
			bloodGroupData.setRecent(YavniDateUtil.dateToString(bloodGroupData.getRecent());
		}
		if(null != tuple[4]) {
			bloodGroupData.setOldest(YavniDateUtil.dateToString((Timestamp)tuple[4]));
		}*/
		return bloodGroupData;
	}

	@Override
	public List transformList(List collection) {
		return collection;
	}
	
	
}
