<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Giao Dien Chinh</title>
    <style>
        /* Dinh dang cho toan bo trang */
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        /* Dinh dang cho hop chua cac nut */
        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 20px;
        }

        /* Dinh dang cho cac nut */
        .button {
            width: 150px;
            height: 40px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 10px;
            cursor: pointer;
            font-size: 16px;
            text-align: center;
        }

        .button:hover {
            background-color: #0056b3;
        }
    </style>
    <script>
        function subDangKi() {
            window.location.href = 'GDThongTin399.jsp';
        }

        function subDangNhap() {
            window.location.href = 'GDDangNhap399.jsp';
        }
    </script>
</head>
<body>
<div class="container">
    <button class="button" onclick="subDangNhap()">Dang nhap</button>
    <button class="button" onclick="subDangKi()">Dang ky</button>
</div>
</body>
</html>
