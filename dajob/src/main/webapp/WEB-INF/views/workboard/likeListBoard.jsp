<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>LikeCompListBoard</title>
</head>
<body>
	<div class="row sub_content">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <div class="dividerHeading">
                        <h4><span>Tables</span></h4>
                    </div>
                </div>
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>LOGO</th>
                            <th>회사명</th>
                            <th>지역</th>
                            <th>요구능력</th>
                            <th>요구경력</th>
                        </tr>
                        </thead>
                        <tbody>
                        
                         <c:forEach items="${requestScope.list }" var="list">
                        <tr>
                            <td><a></a></td>
                            <td><a>${ list.work_writer }</a></td>
                            <td><a></a></td>
                            <td><a>${ list.work_skill }</a></td>
                            <td><a>${ list.work_career }</a></td>
                        </tr>
                        </c:forEach>
                        
                        </tbody>
                    </table>
                </div>
            </div> <!--./row-->
</body>
</html>