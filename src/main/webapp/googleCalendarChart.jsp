<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
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
          [ new Date(2013, 9, 4), 5 ],
          [ new Date(2013, 9, 5), 0 ],
          [ new Date(2013, 9, 12), 1 ],
          [ new Date(2013, 9, 13), 1 ],
          [ new Date(2013, 9, 19), 1 ],
          [ new Date(2013, 9, 23), 0 ],
          [ new Date(2013, 9, 24), 0 ],
          [ new Date(2013, 9, 30), 1 ]
        ]);

       var chart = new google.visualization.Calendar(document.getElementById('calendar_basic'));

       var options = {
         title: "활동 기록",
         height: 350,
         
       };

       chart.draw(dataTable, options);
   }
    </script>
  </head>
  <body>
    <div id="calendar_basic" style="width: 1000px; height: 350px;"></div>
  </body>
</html>