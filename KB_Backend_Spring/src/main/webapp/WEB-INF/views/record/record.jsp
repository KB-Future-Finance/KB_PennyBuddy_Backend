<%--
  Created by IntelliJ IDEA.
  User: sshon
  Date: 2024-07-16
  Time: 오후 5:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RecordIndex</title>
</head>
<body>
       <form action="/record/list" , method="post">
           <label for="category_type">Category Type:</label>
           <input type="text" id="category_type" name="category_type"><br><br>

           <label for="member_Id">Member ID:</label>
           <input type="text" id="member_Id" name="member_Id"><br><br>

           <label for="amount">Amount:</label>
           <input type="text" id="amount" name="amount"><br><br>

           <label for="start_date">Start Date:</label>
           <input type="date" id="start_Date" name="start_Date"><br><br>

           <label for="end_date">End Date:</label>
           <input type="date" id="end_Date" name="end_Date"><br><br>

           <label for="delYn">delYn:</label>
           <input type="text" id="delYn" name="delYn"><br><br>

           <input type="submit" value="Submit">

       </form>
</body>
</html>
