package org.kh.dajob.cert.model.service;

import java.util.ArrayList;
import java.util.Map;

import org.kh.dajob.cert.model.vo.Cert;
import org.kh.dajob.cert.model.vo.UserCert;

public interface CertService {
	ArrayList<Cert> selectList();
	
	int insertUserCert(Map<String, Object> map);
	
	int deleteUserCert(String member_id);
}
