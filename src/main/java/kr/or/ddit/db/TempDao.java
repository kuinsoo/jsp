package kr.or.ddit.db;

import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class TempDao {
	
	public Map<String , Object> getTemp(){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		// 매개변수가 없어서 값을 주지 않아도 된다 
		return session.selectOne("temp.temp");
	}


}
