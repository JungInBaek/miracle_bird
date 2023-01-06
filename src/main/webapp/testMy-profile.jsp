<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
      google.charts.load("current", {packages:["calendar"]});
      google.charts.setOnLoadCallback(drawChart);

   function drawChart() {
       var dataTable = new google.visualization.DataTable();
       dataTable.addColumn({ type: 'date', id: 'Date' });
       dataTable.addColumn({ type: 'number', id: 'Won/Loss' });
       dataTable.addRows([
         /*  [ new Date(2012, 3, 13), 1 ],
          [ new Date(2012, 3, 14), 2 ],
          [ new Date(2012, 3, 15), 3 ],
          [ new Date(2012, 3, 16), 0 ],
          [ new Date(2012, 3, 17), 0 ], */
          // Many rows omitted for brevity.
          [ new Date(2023, 9, 4), 5 ],
          [ new Date(2023, 9, 5), 0 ],
          [ new Date(2023, 9, 12), 1 ],
          [ new Date(2023, 9, 13), 1 ],
          [ new Date(2023, 9, 19), 1 ],
          [ new Date(2023, 9, 23), 0 ],
          [ new Date(2023, 9, 24), 0 ],
          [ new Date(2023, 9, 30), 1 ]
        ]);

       var chart = new google.visualization.Calendar(document.getElementById('calendar_basic'));

       var options = {
         title: "활동 기록",
         height: 350,
         
       };

       chart.draw(dataTable, options);
   }
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
	$.ajax({
		url : "profile/one",
		success : function(profileResult) {
			$("#profileResult").html(profileResult);
		}
	})
	$.ajax({
		url : "profile/feedChart",
		success : function(chartResult) {
			$('#chartResult').html(chartResult);
		}
	})
	$.ajax({
		url : "profile/allFeed",
		success : function(feedResult) {
			$('#feedResult').html(feedResult);
		}
	})
</script>
</head>
<body>
	프로필 결과
	<div id="profileResult"></div>
	<a href="my-profileUpdate.jsp"><button>수정</button></a>
	<hr>
	피드 잔디
	<div id="calendar_basic" style="width: 1000px; height: 200px;"></div>
	<hr>
	피드 결과
	<div id="feedResult"></div>
</body>
</html>