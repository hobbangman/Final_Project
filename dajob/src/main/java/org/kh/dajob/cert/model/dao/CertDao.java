package org.kh.dajob.cert.model.dao;

import java.util.ArrayList;

import org.kh.dajob.cert.model.vo.Cert;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("certDao")
public class CertDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public ArrayList<Cert> selectList() {
		return new ArrayList<Cert>(sqlSession.selectList("Cert.selectList"));
	}
	
}
