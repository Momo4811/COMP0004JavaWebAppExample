<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Statistics</title>
    <jsp:include page="/meta.jsp"/>
    <style>
        .StatisticsChoices {
            width: 40%;
            text-align: center;
            padding: 20px;
            box-sizing: border-box;
            align-items: center;
            margin: auto;
        }
        .StatisticsChoices ul {
            list-style-type: none;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .StatisticsChoices li {
            margin-bottom: 20px;
            width: 80%;
        }
        .StatisticsChoices a {
            text-decoration: none;
            color: #333;
            background-color: #ddd;
            padding: 15px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
            display: block;
            width: 100%;
            text-align: center;
        }
        .StatisticsChoices a:hover {
            background-color: #bbb;
        }
    </style>
</head>
<body>
<h1>Statistics</h1>
<jsp:include page="navbar.jsp" />
<div class = "StatisticsChoices">
<ul>
  <li><a href="/locationStatistics.html">Location Statistics</a></li>
  <li><a href="/oldestPerson.html">Oldest Person Statistics</a></li>
  <li><a href="/commonLetterStatistics.html">Most Common Letter in Names Statistics</a></li>
</ul></div>
</body>
</html>