<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
      google.charts.load("current", {packages:["calendar"]});
      google.charts.setOnLoadCallback(drawChart);

   function drawChart() {
	   $.ajax({
		   url : "profile/testFeedChart",
		   dataType : "json",
		   success : function(list) {
			   var dataTable = new google.visualization.DataTable();
		       dataTable.addColumn({ type: 'date', id: 'Date' });
		       dataTable.addColumn({ type: 'number', id: 'Won/Loss' });
		       var arr = new Array(list.length);
		       for (i=0; i<list.length; i++) {
		    	   one = new Array(2);
		    	   one[0] = new Date(list[i].feedTime);
		    	   one[1] = list[i].count;
		    	   arr[i] = one;
		       }
		       /* alert(arr); */
		       dataTable.addRows(arr);
		       /* dataTable.addRows([
		          [ new Date(2012, 3, 13), 37032 ],
		          [ new Date(2012, 3, 14), 38024 ],
		          [ new Date(2012, 3, 15), 38024 ],
		          [ new Date(2012, 3, 16), 38108 ],
		          [ new Date(2012, 3, 17), 38229 ],
		          // Many rows omitted for brevity.
		          [ new Date(2013, 9, 4), 38177 ],
		          [ new Date(2013, 9, 5), 38705 ],
		          [ new Date(2013, 9, 12), 38210 ],
		          [ new Date(2013, 9, 13), 38029 ],
		          [ new Date(2013, 9, 19), 38823 ],
		          [ new Date(2013, 9, 23), 38345 ],
		          [ new Date(2013, 9, 24), 38436 ],
		          [ new Date(2013, 9, 30), 38447 ]
		        ]); */

		       var chart = new google.visualization.Calendar(document.getElementById('calendar_basic'));

		       var options = {
		         title: "활동기록",
		         height: 350,
		         colorAxis: {minValue: 0, colors:['#ffffff','yellow']}
		       };

		       chart.draw(dataTable, options);
			}
	   })
   }
</script>
</head>
<body>
<div id="calendar_basic" style="width: 1000px; height: 350px;"></div>
</body>
</html>