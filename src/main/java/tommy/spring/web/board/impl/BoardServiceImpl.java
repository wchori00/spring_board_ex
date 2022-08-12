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
		//	throw new IllegalArgumentException("0�� ���� ����� �� �����ϴ�");
		//}
		//boardDAO.insertBoard(vo); // 1000�� �� ��� ����
		//boardDAO.insertBoard(vo); // Exception �߻�
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
