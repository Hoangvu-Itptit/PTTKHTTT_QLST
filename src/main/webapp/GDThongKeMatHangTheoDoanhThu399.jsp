<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Thong ke theo doanh thu</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                text-align: center;
                padding: 20px;
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
            .input-group {
                margin-bottom: 20px;
                display: flex;
                justify-content: center;
            }
            .input-item {
                margin: 0 10px;
                text-align: left;
            }
            .input-item label {
                display: block;
                margin-bottom: 5px;
                font-weight: bold;
            }
            .input-field {
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
                margin-top: 20px;
            }
            .button:hover {
                background-color: darkblue;
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
            tr[data-id] {
                cursor: pointer;
            }
            tr:hover {
                background-color: #f2f2f2;
            }
        </style>
        <script>
            function subXemThongKe() {
                const startDate = document.getElementById('startDate').value;
                const endDate = document.getElementById('endDate').value;
                fetch('ThongKeMatHangTheoDoanhThu399?startDate=' + startDate + '&endDate=' + endDate)
                        .then(response => response.json())
                        .then(data => generateRows(data));
            }

            function generateRows(data) {
                console.log(data)
                const table = document.getElementById('data-table');
                table.innerHTML = `
                    <tr>
                        <th>STT</th>
                        <th>Ten</th>
                        <th>So luong ban</th>
                        <th>Thanh tien</th>
                    </tr>
                `;

                for (let index = 0; index < data.length; index++) {
                    const item = data[index];
                    const row = table.insertRow();
                    row.setAttribute('data-id', item.id);
                    row.innerHTML =
                            '<td>' + (index + 1) + '</td>' +
                            '<td>' + item.name + '</td>' +
                            '<td>' + item.quantity + '</td>' +
                            '<td>' + item.revenue + ' $</td>';
                    row.addEventListener('click', () => subDanhSachDonHang(item.id));
                }

            }

            function subDanhSachDonHang(itemID) {
                const startDate = document.getElementById('startDate').value;
                const endDate = document.getElementById('endDate').value;

                fetch('ChiTietDonHangChuaMatHang399?itemID=' + itemID + '&startDate=' + startDate + '&endDate=' + endDate)
                    .then(response => response.text())
                    .then(html => {
                        document.open();
                        document.write(html);
                        document.close();
                    });
            }

            document.addEventListener('DOMContentLoaded', function () {
                document.getElementById('view-report').addEventListener('click', subXemThongKe);
            });
        </script>
    </head>
    <body>
        <div class="container">
            <h2>Thong ke theo doanh thu</h2>
            <form>
                <div class="input-group">
                    <div class="input-item">
                        <label for="startDate">Ngay bat dau</label>
                        <input type="date" id="startDate" class="input-field" name="startDate">
                    </div>
                    <div class="input-item">
                        <label for="endDate">Ngay ket thuc</label>
                        <input type="date" id="endDate" class="input-field" name="endDate">
                    </div>
                </div>
                <button type="button" id="view-report" class="button">Xem thong ke</button>
            </form>
            <table id="data-table">
                <tr>
                    <th>STT</th>
                    <th>Ten</th>
                    <th>So luong ban</th>
                    <th>Thanh tien</th>
                </tr>
            </table>
        </div>
    </body>
</html>
