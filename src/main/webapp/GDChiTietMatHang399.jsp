<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Chi tiết mặt hàng</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                text-align: center;
                padding: 20px;
                position: relative;
            }
            .container {
                background-color: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                display: inline-block;
                width: 80%;
            }
            .container h2 {
                margin-bottom: 20px;
            }
            table {
                margin-top: 20px;
                width: 100%;
                border-collapse: collapse;
            }
            table, th, td {
                border: 1px solid black;
            }
            th, td {
                padding: 10px;
                text-align: left;
            }
            th {
                background-color: #f2f2f2;
            }
            .back-button {
                position: absolute;
                top: 10px;
                left: 10px;
                padding: 10px 20px;
                font-size: 16px;
                background-color: blue;
                color: white;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }
            .back-button:hover {
                background-color: darkblue;
            }
        </style>
    </head>
    <body>
        <button class="back-button" onclick="location.href = 'GDThongKeMatHangTheoDoanhThu399.jsp'">Quay lại trang thống kê</button>
        <div class="container">
            <h2>Xem chi tiết mặt hàng</h2>
            <div class="info-row">
                <div>
                    <span>Ngày bắt đầu: ${startDate}</span>
                    <span>Ngày kết thúc: ${endDate}</span>
                </div>
                <div>
                    <span>Tên Mặt Hàng: ${itemName}</span>
                </div>
                <div>
                    <span>Tổng Giá Trị: ${itemRevenue}</span>
                </div>
            </div>
            <table id="orderTable">
                <tr>
                    <th>STT</th>
                    <th>Mã đơn hàng</th>
                    <th>Tên khách hàng</th>
                    <th>Ngày mua</th>
                    <th>Số lượng sản phẩm đang xem</th>
                    <th>Giá trị</th>
                </tr>
            </table>
        </div>

        <script>
            var ordersJson = '${ordersJson}';
            var orders = JSON.parse(ordersJson);

            var table = document.getElementById("orderTable");
            orders.forEach((order, index) => {
                var row = table.insertRow();
                row.innerHTML =
                        '<td>' + (index + 1) + '</td>' +
                        '<td>' + order.maDonHang + '</td>' +
                        '<td>' + order.tenKhachHang + '</td>' +
                        '<td>' + order.ngayMua + '</td>' +
                        '<td>' + order.soLuongSanPham + '</td>' +
                        '<td>' + order.giaTri + '</td>';
            });
        </script>
    </body>
</html>
