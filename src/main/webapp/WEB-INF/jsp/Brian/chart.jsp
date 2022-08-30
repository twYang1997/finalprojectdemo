<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:include page="../timmy/layout/navbar.jsp" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>圖</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>

<link rel="stylesheet" href="${contextRoot}/css/report_index.css">
<link rel="stylesheet" href="${contextRoot}/css/report_navs.css">
<link rel="stylesheet" href="${contextRoot}/css/member_chart.css">

</head>
<body>
	<div class="wrap">
		<div class="left">
			<div class="container">
				<div class="row justify-content-left">
					<div class="col-12">
						<div class="card" style="border-radius: 10px">
							<div class="card-body">
								<!-- 						<nav class="nav flex-column nav-pills nav-gap-y-1"> -->
								<div>1</div>
								<div>2</div>
								<div>3</div>
								<div>4</div>
								<!-- 						</nav> -->
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="right">
			<div class="col-lg-12">
				<div class="panel"
					style="border-radius: 10px; padding-top: 1%; padding-bottom: 0.5%">
					<div class="panel-heading">
						<canvas id="petTypeChart" width="400" height="400"></canvas>
						<canvas id="genderTypeChart" width="400" height="400"></canvas>
						<canvas id="sumMoneyChart" width="400" height="400"></canvas>
<!-- 						<input onchange="filterData()" type="date" id="startdate" -->
<!-- 							value="2022-08-20"> <input onchange="filterData()" -->
<!-- 							type="date" id="enddate" value="2022-08-23"> -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--******************************************************************************************************* 1 -->


	<script>
		// 	男女
		var Femalesum = "${genderFemale}";
		var Malesum = "${genderMale}";

		var ctx = document.getElementById("petTypeChart").getContext('2d');
		var myChart = new Chart(ctx, {
			type : 'doughnut',
			data : {
				labels : [ "Female", "Male" ],
				datasets : [ {
					data : [ Femalesum, Malesum ],
					backgroundColor : [ 'rgba(255, 99, 132, 0.2)',
							'rgba(255, 159, 64, 0.2)' ],
					borderColor : [ 'rgba(255,99,132,1)',
							'rgba(255, 159, 64, 1)' ],
					borderWidth : 1
				} ]
			},
		});
		//--------------------------------------------------------------------------------------------------------------------
		// 	貓狗
		var catsum = "${petTypeCat}";
		var dogsum = "${petTypeDog}";
		console.log('catsum:' + catsum);

		var ctx = document.getElementById("genderTypeChart").getContext('2d');
		var myChart = new Chart(ctx, {
			type : 'doughnut',
			data : {
				labels : [ "cat", "dog" ],
				datasets : [ {
					data : [ catsum, dogsum ],
					backgroundColor : [ 'rgba(255, 99, 132, 0.2)',
							'rgba(255, 159, 64, 0.2)' ],
					borderColor : [ 'rgba(255,99,132,1)',
							'rgba(255, 159, 64, 1)' ],
					borderWidth : 1
				} ]
			},
		});
		//------------------------------------------------------------------------------------------------------------------------------------------		
		var SumMoney = "${OrdersBySumMoney}";
		var month = "${OrdersByMonth}";
// 		var SumMoneyArray = new Array();
		
// 			SumMoneyArray.push(SumMoney)
		
		
// 		console.log('SumMoneyArray:' + SumMoneyArray);
		
// 		console.log('month:' + month);
// 		var SumMoneyArray = SumMoney.replace(, "");
// 		var monthArray = month.replace(/[]/g,"");
// 		console.log('SumMoneyArray:' + SumMoneyArray);
// 		console.log('monthArray:' + monthArray);
// 		const SumMoneydates = SumMoneyArray.push();
// 		console.log('SumMoneydates:' + SumMoneydates);
		
// 		const monthdata = monthArray.push();
// 		console.log('monthdata:' + monthdata);
		
		var ctx = document.getElementById("sumMoneyChart").getContext('2d');
var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: [6,7,8],
        datasets: [{
            label: '# of Votes',
            data: [100,200,30],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255,99,132,1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero:true
                }
            }]
        }
    }
});

// 				function filterData(){
// 					const dates2=[...dates];
// 					console.log('dates2:'+dates2);
// 					const startdate = document.getElementById('startdate');
// 					const enddate = document.getElementById('enddate');
// 					console.log('startdate:'+startdate);
// 					console.log('enddate:'+enddate);
// 					// get index number in array
// 					let indexstartdate = dates2.indexOf(startdate.value);
					
// 					console.log('indexstartdate:'+indexstartdate);
					
// 					if(	!dates2.includes(startdate.value)){
						
// 						let newIndex=0;
// 						for(item of dates2){
							
									
// 							if(	new Date(startdate.value)	> new Date(item)){
											
// 							//console.log(	new Date(startdate.value),new Date(item),new Date(startdate.value)	> new Date(item))
// 								newIndex++;
// 							}
// 						}
// 						indexstartdate=newIndex
						
// 					} 
					
// 					let indexenddate = dates2.indexOf(enddate.value);
// 					console.log('indexenddate:'+indexenddate);

// 					if (!dates2.includes(enddate.value)) {
						
					
// 						let newIndex=0;
// 						for(item of dates2){
							
										
// 							if(	new Date(enddate.value)	> new Date(item)){
								
// 							//console.log(	new Date(enddate.value),new Date(item),new Date(enddate.value)	< new Date(item))
// 								newIndex++;
// 							}
// 						}
// 						indexenddate=newIndex
// 					}
					
					
// 					//slice the array only showing the selected section / slice
// 					const filterDate = dates2.slice(indexstartdate, indexenddate + 1);

// 					// replace the labels in the chart
// 					myChart.config.data.labels = filterDate;

// 					// datapoints
// 					const datapoints2 = [...datapoints];
// 					const filterDatapoints = datapoints2.slice(indexstartdate, indexenddate + 1)

// 					myChart.config.data.datasets[0].data = filterDatapoints;

// 					myChart.update();
// 				}
	</script>
</body>
</html>