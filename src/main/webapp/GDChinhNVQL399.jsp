<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>GD Chinh NVQL</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f4f4;
                text-align: center;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }
            .button {
                padding: 10px 20px;
                font-size: 16px;
                margin: 10px;
                cursor: pointer;
                background-color: blue;
                color: white;
                border: none;
                border-radius: 5px;
                text-align: center;
                display: inline-block;
            }
            .button:hover {
                background-color: darkblue;
            }
        </style>
        <script>
            function subXemBaoCao() {
                window.location.href = 'GDBaoCao399.jsp';
            }
        </script>
    </head>
    <body>
        <div>
            <button class="button" onclick="subXemBaoCao()">Xem bao cao</button>
        </div>
    </body>
</html>
