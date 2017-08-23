package board.model.service;

import java.util.*;

import board.model.vo.Board;
import board.model.dao.BoardDao;

public class BoardService {
	public BoardService(){}

	public int getListCount() {
		return new BoardDao().getListCount();
	}

	public ArrayList<Board> selectList(int currentPage, int limit) {
		return new BoardDao().selectList(currentPage, limit);
	}

	public int insertBoard(Board b) {
		return new BoardDao().insertBoard(b);
	}
	
	public Board selectBoard(int boardNum){
		return new BoardDao().selectBoard(boardNum);
	}

	public void addReadCount(int boardNum) {
		new BoardDao().addReadCount(boardNum);
	}

	public int deleteBoard(int boardNum) {
		return new BoardDao().deleteBoard(boardNum);
	}

	public int insertReply(Board originBoard, Board replyBoard) {
		return new BoardDao().insertReply(originBoard, replyBoard);
	}

	public void updateReplySeq(Board replyBoard) {
		new BoardDao().updateReplySeq(replyBoard);
	}

	public int updateBoardReply(Board b) {
		return new BoardDao().updateBoardReply(b);
	}

	public int updateBoard(Board b) {
		return new BoardDao().updateBoard(b);
	}

	public ArrayList<Board> selectList() {
		return new BoardDao().selectList();
	}
}





