package com.exam.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.exam.board.dto.BoardDto;

@Mapper
public interface BoardDao {
	public List<BoardDto> mtdBoardList(); // 목록

	public BoardDto mtdBoardView(int num); // 내용보기

	public int mtdBoardWrite(String writer, String title, String content); // 글저장

	public int mtdBoardDelete(int num); // 글삭제
}
