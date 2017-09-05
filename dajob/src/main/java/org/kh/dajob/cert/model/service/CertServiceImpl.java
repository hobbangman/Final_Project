package org.kh.dajob.cert.model.service;

import java.util.ArrayList;

import org.kh.dajob.cert.model.dao.CertDao;
import org.kh.dajob.cert.model.vo.Cert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertServiceImpl implements CertService {

	@Autowired
	// 의존성 주입 : Dependancy Injection
	private CertDao certDao;

	@Override
	public ArrayList<Cert> selectList() {
		return certDao.selectList();
	}
	
}
