<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tommy.spring.web.board.impl.BoardDAO" %>
<%@ page import="tommy.spring.web.board.BoardVO" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	

	// 1. 사용자 입력 정보 추출: 검색 기능은 나중에 구현
	
	// 2. 데이터베이스 연동 처리
	BoardVO vo = new BoardVO();
	BoardDAO boardDAO = new BoardDAO();
// 	List<BoardVO> boardList = boardDAO.getBoardList(vo);
	
	// 세션에 저장된 글 목록을 추출
	List<BoardVO> boardList = (List<BoardVO>)session.getAttribute("boardList");
	
	// 3. 응답 화면 구성
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="board.list.mainTitle"/></title>
</head>
<body>
<h1><spring:message code="board.list.mainTitle"/></h1>
<h3>${userName}<spring:message code="board.list.welcomeMsg"/><a href="logoutProc.jsp">Log-Out</a></h3>
<!-- 검색 시작 -->
<form action="getBoardList.do" method="post">
<table border="1">
<tr>
<td>
<select name="searchCondition">
<!-- <option value="TITLE">제목</option> -->
<!-- <option value="CONTENT">내용</option> -->
<c:forEach items="${conditionMap }" var="option">
<option value="${option.value }">${option.key }</option>
</c:forEach>
</select>
<input type="text" name="searchKeyword"/>
<input type="submit" value="<spring:message code="board.list.search.condition.btn"/>"/>
</td>
</tr>
</table>
</form><br/>
<!-- 검색 종료 -->
<table border="1">
<tr>
<th><spring:message code="board.list.table.head.seq"/></th>
<th><spring:message code="board.list.table.head.title"/></th>
<th><spring:message code="board.list.table.head.writer"/></th>
<th><spring:message code="board.list.table.head.regDate"/></th>
<th><spring:message code="board.list.table.head.cnt"/></th>
</tr>

<c:forEach var="board" items="${boardList }">
<tr>
<td>${board.seq }</td>
<td><a href="getBoard.do?seq=${board.seq }">${board.title }</a></td>
<td>${board.writer }</td>
<td><fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd"/></td>
<td>${board.cnt }</td>
</tr>
</c:forEach>

<%-- <% for(BoardVO board: boardList) { %> --%>
<!-- <tr> -->
<%-- <td><%=board.getSeq() %></td> --%>
<!-- <td> -->
<%-- <%-- <a href="getBoard.jsp?seq=<%=board.getSeq() %>"><%=board.getTitle() %></a> --%>
<%-- <a href="getBoard.do?seq=<%=board.getSeq()%>"><%=board.getTitle()%></a> --%>
<!-- </td> -->
<%-- <td><%=board.getWriter() %></td> --%>
<%-- <td><%=board.getRegDate()%></td> --%>
<%-- <td><%=board.getCnt() %></td> --%>
<!-- </tr> -->
<%-- <%} %> --%>
</table><br/>
<a href="insertBoard.jsp"><spring:message code="board.list.link.insertBoard"/></a>
</body>
</html>
