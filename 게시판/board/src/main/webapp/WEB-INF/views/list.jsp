<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 부트스트랩 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    <!-- 제이쿼리 -->
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <title>list</title>
    <style>
        body {
            width: 1920px;

            border: 1px solid rgba(0, 0, 0, 0.199);
        }

        #subHead {
            height: 70px;
            background-color: aliceblue;
        }

        #subLeft {
            width: 150px;
            background-color: antiquewhite;

        }
        #subLeft li:hover{
            background-color: rgba(240, 248, 255, 0.388);
        }
        a{
            color: black;
            text-decoration: none;
            font-weight: 550;
        }
        a:hover{
            color: rgb(193, 199, 174);
            
        }

        .btnBox{
            padding: 20px;
        }
        
    </style>
</head>

<body>
    <header id="subHead">

    </header>
    <div id="subBox" class="row">
        <article id="subLeft" class="text-center px-0" <%-- style="height: 1080px;"--%>>
         
                <div class="py-3 fs-4"><b>게시판</b></div>
            
            <ul class="nav flex-column ">
                
                <li class="nav-item mb-2">
                    <a href="/board/list" class="nav-link ">
                        공지사항
                    </a>
                </li>
                <li class="nav-item mb-2">
                    <a href="/board/list" class="nav-link ">
                        자료실
                    </a>
                </li>
                <li class="nav-item mb-2">
                    <a href="/board/list" class="nav-link ">
                        업무공유
                    </a>
                </li>
            </ul>
        </article>
        <article id="subRight" class="col">
            <table class="table table-hover">
                <div class="btnBox">
                    <button type="button" class="btn btn-success" style="float: right;">등록</button>
                </div>
                <thead>
                    <tr>
                        <th scope="col">No</th>
                        <th scope="col">제목</th>
                        <th scope="col">작성자</th>
                        <th scope="col">조회수</th>
                        <th scope="col">작성일</th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach var="i" begin="0" end="10">
                    <tr>
                        <td scope="row">1</td>
                        <td><a href="board/toView">Mark</a></td>
                        <td>Otto</td>
                        <td>@mdo</td>
                        <td>@mdo</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </article>
    </div>
</body>

</html>