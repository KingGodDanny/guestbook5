package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestBookVo;

@Repository
public class GuestBookDao {

	@Autowired
	private SqlSession sqlSession;
	
	
	//전체리스트 가져오기 AddList
	public List<GuestBookVo> getGuestList() {
		
		//Dl , loc에 DB요청
		//리스트 가져오기
		List<GuestBookVo> guestList = sqlSession.selectList("guestbook.selectList");
		
		return guestList;
	}
		
	
	//방명록 저장 Add
	public int guestInsert(GuestBookVo guestBookVo) {
		
		System.out.println("[GuestBookDao.guestInsert()]");
		
		int count = sqlSession.insert("guestbook.guestInsert" , guestBookVo);
		
		return count;
	}
	
	
}
