<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Redirect Page</title>
    <style>
      body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        font-family: Arial, sans-serif;
        background: linear-gradient(135deg, #f06, #4a90e2);
        color: white;
      }
      .container {
        text-align: center;
        background: rgba(0, 0, 0, 0.6);
        padding: 2rem;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
      }
      .container h1 {
        margin-bottom: 1rem;
      }
      .redirect-btn {
        display: inline-block;
        padding: 0.75rem 1.5rem;
        font-size: 1rem;
        color: white;
        background-color: #4a90e2;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        text-decoration: none;
        transition: background-color 0.3s ease;
      }
      .redirect-btn:hover {
        background-color: #357ABD;
      }
    </style>
</head>
<body>
<div class="container">
    <h1>Welcome to Our Application</h1>
    <p>Click the button below to go to the main application.</p>
    <a href="http://localhost:5173" class="redirect-btn">Go to Main Application</a>
</div>
</body>
</html>
