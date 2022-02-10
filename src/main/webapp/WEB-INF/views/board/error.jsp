<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>error</title>
        <script type="text/javascript">
            $(function () {
                $("#btnWrite").on("click", function () {
                    location.href = "${path}/board/boardlist.jsp";
                });
            });
        </script>
        <style>
            .layer {
                position: absolute;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                text-align: center;
            }

            .layer .content {
                display: inline-block;
                background: #dddddd;
                vertical-align: middle;
                border: 3px solid black;
                width: 75%;
                height: 60%;
            }

            .layer .blank {
                display: inline-block;
                width: 0;
                height: 100%;
                vertical-align: middle
            }
            #btnWriter{
                width: 100px;
                height: 50px;
                background-color: gray;
                color : white;
                font-size: 15px;
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
    <div class="layer">
        <span class="content" style="text-align: left;">
            <br>
            <br>
            <h1>&nbsp&nbsp&nbsp로그인 필요</h1>
            <br>
            <br>
            <br>
            <h3>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp로그인이 필요합니다</h3>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <p align="center">
                <input type="button" id="btnWriter" value="확인" />
            </p>
            <br>
            <br>
            <br>
            <br>
        </span>
        <span class="blank"></span>
    </div>
    </body>

    </html>