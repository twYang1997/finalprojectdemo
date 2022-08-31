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
<%-- <link rel="stylesheet" href="${contextRoot}/css/member_chart.css"> --%>

</head>
<body>
	<div class="wrap">
		<div class="left">
			<div class="container">
				<div class="row justify-content-left">
					<div class="col-12">
						<div class="card" style="border-radius: 5px">
							<div class="card-body">
								<ul>
									<li style="list-style: none;"><a
										href="${contextRoot}/memberChart">數據統計</a></li>
									<li style="list-style: none;"><a
										href="${contextRoot}/memberManagement">會員管理</a></li>
									<li style="list-style: none;"><a
										href="${contextRoot}/memberReport">檢舉文章</a></li>
									<li style="list-style: none;"><a
										href="${contextRoot}/memberProducts">商品管理</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="right row">
			<div class="col-6">
				<div class="panel">
					<canvas id="petTypeChart"></canvas>
				</div>
			</div>
			<div class="col-6">
				<div class="panel">
					<canvas id="genderTypeChart"></canvas>
				</div>
			</div>
			<div class="col-12">
				<div class="panel">
					<div
						style="display: flex; justify-content: center; padding-top: 10px">
						<input onchange="filterData()" type="month" id="startdate">
						<input onchange="filterData()" type="month" id="enddate">
					</div>
					<canvas id="sumMoneyChart"></canvas>
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
		//月份總額
		var SumMoney = "${OrdersBySumMoney}";
		var month = "${OrdersByMonth}".replace("[", "").replace("]","");
// 		console.log('month:'+ month);
// 		console.log(typeof month);
		var monthArray=month.split(', ');
// 		console.log('monthArray:'+ monthArray);
// 		console.log(typeof monthArray);
		const data = {
			      labels: monthArray,
			      datasets: [{
			        label: '總額',
			        data: JSON.parse(SumMoney),
			         backgroundColor: [
			           'rgba(255, 26, 104, 0.2)',
			           'rgba(54, 162, 235, 0.2)',
			           'rgba(255, 206, 86, 0.2)',
			           'rgba(75, 192, 192, 0.2)',
			           'rgba(153, 102, 255, 0.2)',
			           'rgba(255, 159, 64, 0.2)',
			           'rgba(0, 0, 0, 0.2)'
			         ],
			         borderColor: [
			           'rgba(255, 26, 104, 1)',
			           'rgba(54, 162, 235, 1)',
			           'rgba(255, 206, 86, 1)',
			           'rgba(75, 192, 192, 1)',
			           'rgba(153, 102, 255, 1)',
			           'rgba(255, 159, 64, 1)',
			           'rgba(0, 0, 0, 1)'
			         ],
			        borderWidth: 1
			      }]
			    };

			    // config 
			    const config = {
			      type: 'bar',
			      data,
			      options: {
			        scales: {
			          y: {
			            beginAtZero: true
			          }
			        }
			      }
			    };

			    // render init block
			    const sumMoneyChart = new Chart(
			      document.getElementById('sumMoneyChart'),
			      config
			    );

				function filterData(){
					const dates2=[...monthArray];
					console.log('dates2:'+dates2);
					const startdate = document.getElementById('startdate');
					const enddate = document.getElementById('enddate');
					console.log('startdate:'+startdate.value);
					console.log('enddate:'+enddate);
					// get index number in array
					let indexstartdate = dates2.indexOf(startdate.value);
					
					console.log('indexstartdate:'+indexstartdate);
					
					if(	!dates2.includes(startdate.value)){
						
						let newIndex=0;
						for(item of dates2){
							
									
							if(	new Date(startdate.value)	> new Date(item)){
											
							//console.log(	new Date(startdate.value),new Date(item),new Date(startdate.value)	> new Date(item))
								newIndex++;
							}
						}
						indexstartdate=newIndex
						
					} 
					
					let indexenddate = dates2.indexOf(enddate.value);
					console.log('indexenddate:'+indexenddate);

					if (!dates2.includes(enddate.value)) {
						
					
						let newIndex=0;
						for(item of dates2){
							
										
							if(	new Date(enddate.value)	> new Date(item)){
								
							//console.log(	new Date(enddate.value),new Date(item),new Date(enddate.value)	< new Date(item))
								newIndex++;
							}
						}
						indexenddate=newIndex
					}
					
					
					//slice the array only showing the selected section / slice
					const filterDate = dates2.slice(indexstartdate, indexenddate + 1);

					// replace the labels in the chart
					sumMoneyChart.config.data.labels = filterDate;

					// datapoints
					const datapoints2 = [...JSON.parse(SumMoney)];
					const filterDatapoints = datapoints2.slice(indexstartdate, indexenddate + 1)

					sumMoneyChart.config.data.datasets[0].data = filterDatapoints;

					sumMoneyChart.update();
				}
	</script>
</body>
</html>