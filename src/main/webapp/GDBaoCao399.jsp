<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Xem thong ke</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }
        .container h2 {
            margin-bottom: 20px;
        }
        .button {
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            background-color: blue;
            color: white;
            border: none;
            border-radius: 4px;
            width: 100%;
            margin: 10px 0;
        }
        .button:hover {
            background-color: darkblue;
        }
    </style>
    <script>
        function subThongKeTheoDoanhThu(){
            window.location.href = 'GDThongKeMatHangTheoDoanhThu399.jsp';
        }
    </script>
</head>
<body>
    <div class="container">
        <h2>Xem thong ke</h2>
        <button class="button">Theo mat hang</button>
        <button class="button">Theo nha cung cap</button>
        <button class="button" onclick="subThongKeTheoDoanhThu()">Theo doanh thu</button>
    </div>
</body>
</html>
