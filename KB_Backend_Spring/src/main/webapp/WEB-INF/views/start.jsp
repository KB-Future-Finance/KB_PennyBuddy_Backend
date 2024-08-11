<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Penny Buddy - Welcome</title>
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
    <style>
      body {
        margin: 0;
        padding: 0;
        font-family: 'Nanum Pen Script', sans-serif; /* 귀여운 손글씨체로 변경 */
        background-color: #f9e5d9; /* 밝은 베이지 톤의 배경색 */
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        text-align: center;
      }
      .welcome-container {
        background-color: #ffffff;
        padding: 200px 300px; /* 박스를 더 크게 조정 */
        border-radius: 25px; /* 좀 더 둥근 모서리 */
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
      }
      .welcome-container h1 {
        font-size: 48px; /* 글씨 크기를 좀 더 크게 */
        color: #4b6584; /* 부드러운 진한 색상 */
        margin-bottom: 20px; /* 제목과 내용 간의 간격 조정 */
      }
      .welcome-container p {
        font-size: 24px; /* 내용 글씨 크기를 좀 더 크게 */
        color: #4b6584;
        margin-top: 10px;
      }
      .welcome-container a {
        display: inline-block;
        background-color: #f7b731; /* 파스텔톤의 버튼 색상 */
        color: white;
        border: none;
        border-radius: 25px;
        padding: 15px 30px;
        font-size: 24px; /* 버튼 글씨 크기를 크게 조정 */
        cursor: pointer;
        margin-top: 30px;
        text-decoration: none; /* 링크 밑줄 제거 */
      }
      .welcome-container a:hover {
        background-color: #fd9644; /* 호버 시 조금 더 진한 색상 */
      }
    </style>
</head>
<body>
<div class="welcome-container">
    <h1>Penny Buddy와 함께</h1>
    <p>쉽고 즐겁게 시작해보세요!</p>
    <a href="http://localhost:5173">시작하기</a>
</div>
</body>
</html>
