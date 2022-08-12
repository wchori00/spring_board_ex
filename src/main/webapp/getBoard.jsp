<%@ page import="tommy.spring.web.board.impl.BoardDAO" %>
<%@ page import="tommy.spring.web.board.BoardVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 	// 1. 검색할 게시글 번호 추출
// 	String seq = request.getParameter("seq");

// 	// 2. 데이터베이스 연동 처리
// 	BoardVO vo = new BoardVO();				// vo 객체 생성
// 	vo.setSeq(Integer.parseInt(seq));		// vo에 시퀀스 저장
	
// 	BoardDAO boardDAO = new BoardDAO();		// dao 객체 생성
// 	BoardVO board = boardDAO.getBoard(vo);	// dao에서 데이터(+시퀀스) 불러와서 vo에 저장

	//세션에 저장한 게시글 정보를 추출한다
	BoardVO board = (BoardVO)session.getAttribute("board");

	// 3. 응답 화면 구현
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Article Content</title>
</head>
<body>
<h1>글 상세</h1>
<!-- <a href="logoutProc.jsp">Log Out</a><hr> -->
<a href="logout.do">Log Out</a><hr>
<!-- <form action="updateBoardProc.jsp" method="post"> -->
<form action="updateBoard.do" method="post">
<%-- <input name="seq" type="hidden" value="<%=board.getSeq()%>"/> --%>
<input name="seq" type="hidden" value="${board.seq }"/>
<table border="1">
<tr>
<td>제목</td>
<%-- <td><input name="title" type="text" value="<%=board.getTitle()%>"/></td> --%>
<td><input name="title" type="text" value="${board.title }"/></td>
</tr>
<tr>
<td>작성자</td>
<%-- <td><%=board.getWriter() %></td> --%>
<td>${board.writer }</td>
</tr>
<tr>
<td>내용</td>
<%-- <td><textarea name="content"><%=board.getContent()%></textarea></td> --%>
<td><textarea name="content">${board.content }</textarea></td>
</tr>
<tr>
<td>등록일</td>
<%-- <td><%=board.getRegDate()%></td> --%>
<td>${board.regDate }</td>
</tr>
<tr>
<td>조회수</td>
<%-- <td><%=board.getCnt()%></td> --%>
<td>${board.cnt }</td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="글수정"/></td>
</tr>
</table>
</form><hr>
<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;
<%-- <a href="deleteBoardProc.jsp?seq=<%=board.getSeq()%>">글삭제</a>&nbsp;&nbsp;&nbsp; --%>
<!-- <a href="getBoardList.jsp">글목록</a> -->
<%-- <a href="deleteBoard.do?seq=<%=board.getSeq()%>">글삭제</a>&nbsp;&nbsp;&nbsp; --%>
<a href="deleteBoard.do?seq=${board.seq }">글삭제</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList.do">글목록</a>
</body>
</html>