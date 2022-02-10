<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <script type="text/javascript">
//             $(function () {
//                 $("#btnWrite").on("click", function () {
//                     location.href = "${path}/board/boardlist.jsp";
//                 });
//             });
        </script>
        <style>
            #boardDetailTable {
            	height:70px;
               	width: 95%; 
				background-color: #eeeeee; 
			 	border: 1px solid black; 
				text-align: center;
			 	margin: auto; 
            }

            #boardDetailTable tr {
               	border: 1px solid black; 
            }
			
			#boardDetailTable2 {
				width: 95%; 
				background-color: white; 
			 	border: 1px solid black; 
				text-align: center;
			 	margin: auto; 
			 	border-bottom: 0pt;
			}
            .jb-th-1 {
                height: 300px;
                width: 100%;
                background-color: white;
            }
            
			#boardCommentTable {
				width: 95%; 
			 	border: 1px solid black; 
				text-align: center;
			 	margin: auto;
			}
			
			#boardCommentTable2 {
				width: 95%; 
			 	border: 1px solid black; 
				text-align: center;
			 	margin: auto;
			}
			
			
            .textInput2 {
                padding-top: 80px;
            }
            #commandinput{
                width: 100%;
                height: 100px;;
            }
            #Cinputbutton{
                width: 100%;
                height: 100px;
            }
        </style>

    </head>

    <body>
        <table id="boardDetailTable">
            <tr>
                <th width="10%">자유</td>
                <th colspan="2" width="90%">제목1</td>
            </tr>
        
            <tr>
                <td width="33%">글쓴이(닉네임) : a</td>
                <td width="34%">작성날짜 : 22/01/25</td>
                <td width="33%">조회수:1</td>
            </tr>
        </table>
        <table id="boardDetailTable2" >
            <tr>
                <td class="jb-th-1" align="left" valign="top">
                    <span>동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세</span>
                </td>
            </tr>
        
            <tr height="100px">
                <td text align="center">
	                <input type="button" id="recommand" value="추천">
	                <br>15
                </td>
            </tr>
        </table>
        
        
        <!-- 댓글 목록 -->
        <table id="boardCommentTable" border="1">
            <tr>
                <td>닉네임 : K</td>
                <td>무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세 <input type="button" id="Cinput" value="대댓글 입력"></td>
                <td>22/01/26<br>00:01:01
                </td>
            </tr>
            <tr>
                <td>닉네임 : S</td>
                <td>바람 서리 불변함은 우리 기상일세 <input type="button" id="Cmodify" value="수정"></td>
                <td>22/01/26<br>00:01:03
                </td>
            </tr>
            <tr>
                <td>닉네임 : S</td>
                <td>남산 위에 저 소나무 철갑을 두른듯 <input type="button" id="Cmodify" value="수정"></td>
                <td>22/01/26<br>00:01:02
                </td>
            </tr>
        </table>
        
        <!-- 댓글 등록 -->
        <table id="boardCommentTable2" border="1" width="95%">
            <tr>
                <td width="90%">
                	<input type="text" id="commandinput">
                </td>
                <td>
                	<input type="button" value="등록" id="Cinputbutton">
                </td>
            </tr>
        </table>
    </body>

    </html>