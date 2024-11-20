<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Dang nhap</title>
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
            .login-container {
                background-color: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                width: 300px;
            }
            .login-container h2 {
                margin-bottom: 20px;
            }
            .input-field {
                display: block;
                margin: 10px auto;
                padding: 10px;
                width: 100%;
                box-sizing: border-box;
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
            }
            .button:hover {
                background-color: darkblue;
            }
        </style>
        <script>
            function dangNhap() {
                document.getElementById('loginForm').submit();
            }
        </script>
    </head>
    <body>
        <div class="login-container">
            <h2>Dang nhap</h2>
            <!-- Form Dang nhap -->
            <form id="loginForm" action="DangNhap399" method="post">
                <input type="text" class="input-field" placeholder="Nhap tai khoan" name="username" required>
                <input type="password" class="input-field" placeholder="Nhap mat khau" name="password" required>
                <button type="button" class="button" onclick="dangNhap()">Dang nhap</button>
            </form>
        </div>
    </body>
</html>
