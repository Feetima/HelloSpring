<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script>

            $(function() {
                $("#su").on("click", function() {
                   console.log("!2222");
                   //alert($("#memberName").val());
                  $.ajax({
                           type : "GET",            // HTTP method type(GET, POST) 형식이다.
                           url : "/findByName?name=" + $("#memberName").val()   ,  // 컨트롤러에서 대기중인 URL 주소이다.
                                                             //findByName?name=hel
                           data : {},            // Json 형식의 데이터이다.
                           success : function(res){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
                               // 응답코드 > 0000
                               var str = "";


                               for(var i=0; i<res.length;i++){
                                str +=  "<tr>\n";
                                str +=      "<td>" + res[i].id + "</td>\n";
                                str +=      "<td>" + res[i].name + "</td>\n";
                                str +=      "<td>" + res[i].address + "</td>\n";
                                str +=  "</tr>\n";

                               }
                               $("#memberData").empty();
                               $("#memberData").append(str);


                               console.log(str);

                           },
                           error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
                               alert("통신 실패.")
                           }
                        });
                });

            });

      </script>
    <title>JQuery Intro</title>


</head>
<body>

    <p>이제부터 제이쿼리를 다 같이 공부해보죠!!<br>
    마우스로 글씨를 클릭해보세요!!</p>

    이름: <input type="text" name="name" id="memberName">

   <input id="su" type="button" value="BUTTON"></input>

    <table id ="memberTable">
      <thead>
            <th>아이디</th>
            <th>이름</th>
            <th>주소</th>
      </thead>
      <tbody id = "memberData">
            <td></td>
            <td></td>
            <td></td>
      </tbody>

    </table>

</body>
</html>