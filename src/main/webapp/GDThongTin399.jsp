<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Form Dang ky</title>
    <style>
        .GDThongTin399 {
            text-align: center;
            margin-top: 20%;
            font-family: Arial, sans-serif;
        }
        .input-field {
            display: block;
            margin: 10px auto;
            padding: 10px;
            width: 80%;
            max-width: 400px;
            border-radius: 10px;
        }
        .button {
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            background-color: blue;
            color: white;
            border: none;
            border-radius: 10px;
        }
    </style>
    <script>
        function dangKi() {
            document.getElementById('dangKiForm').submit();
        }
    </script>
</head>
<body>
<div class="GDThongTin399">
    <h2>Thong tin</h2>
    <!-- Cac o nhap lieu -->
    <form id="dangKiForm" action="DangKi399" method="post">
        <input type="text" class="input-field" placeholder="Nhap tai khoan" name="username">
        <input type="password" class="input-field" placeholder="Nhap mat khau" name="password">
        <input type="text" class="input-field" placeholder="Nhap ten" name="name">
        <input type="text" class="input-field" placeholder="Nhap dia chi" name="address">
        <input type="text" class="input-field" placeholder="Nhap sdt" name="phone">
        <input type="email" class="input-field" placeholder="Nhap email" name="email">

        <!-- Nut Dang ky -->
        <button type="button" class="button" onclick="dangKi()">Dang ky</button>
    </form>
</div>
</body>
</html>
