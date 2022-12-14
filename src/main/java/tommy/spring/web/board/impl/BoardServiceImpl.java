package tommy.spring.web.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tommy.spring.web.board.BoardService;
import tommy.spring.web.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
//	private BoardDAOMybatis boardDAO;
//	private BoardDAO boardDAO;
//	private BoardDAOSpring boardDAO;
	private BoardDAOJPA boardDAO;
	
	
	@Override
//	@Transient
	public void insertBoard(BoardVO vo) {
		//if(vo.getSeq() == 0) {
		//	throw new IllegalArgumentException("0번 글은 등록할 수 없습니다");
		//}
		//boardDAO.insertBoard(vo); // 1000번 글 등록 성공
		//boardDAO.insertBoard(vo); // Exception 발생
		boardDAO.insertBoard(vo);
	}
	@Override
//	@Transient
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}
	@Override
//	@Transient
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}
	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}
	
}
