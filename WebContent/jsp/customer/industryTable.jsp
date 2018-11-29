<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title></title>
<!-- ECharts单文件引入 -->
<script src="${pageContext.request.contextPath }/js/echarts.min.js"></script>
<script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
</head>
<body>
	<table>
		<tr>
			<td>
				<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
				<div id="main" style="width: 600px; height: 400px;"></div> <script
					type="text/javascript">
				    //定义两个数组存储图标信息
				    var industryArray=new Array();
				    var countArray=new Array();
					// 基于准备好的dom，初始化echarts实例
					var myChart = echarts.init(document.getElementById('main'));
					//异步加载数据
					/* function fetchData(cb) {
						// 通过 setIndustry 异步加载
						
						setTimeout(
								function() {
									cb({
										categories : [ "羊毛衫", "雪纺衫", "裤子",
												"高跟鞋", "袜子" ],
										data : [ 20, 36, 10, 10, 20 ]
									});
								}, 1000);
					} */
					// 初始 option
					option = {
						title : {
							text : '客户行业统计',
							subtext : '可能存在误差'
						},
						tooltip : {
							trigger : 'axis'
						},
						legend : {
							data : [ '客户数量' ]
						},
						toolbox : {
							show : true,
							feature : {
								mark : {
									show : true
								},
								dataView : {
									show : true,
									readOnly : false
								},
								magicType : {
									show : true,
									type : [ 'line', 'bar' ]
								},
								restore : {
									show : true
								},
								saveAsImage : {
									show : true
								}
							}
						},
						calculable : true,
						xAxis : {
							type : 'category',
							data : []
						},
						yAxis : {
							type : 'value'
						},
						series : [ {
							name : '客户数量',
							type : 'bar',
							data : [],
							markPoint : {
								data : [ {
									type : 'max',
									name : '最大值'
								}, {
									type : 'min',
									name : '最小值'
								} ]
							},
							markLine : {
								data : [ {
									type : 'average',
									name : '平均值'
								} ]
							},

						} ]
					};
					$.post("${pageContext.request.contextPath}/CustomerAction_industryCount", {},
							  function(data){
						    $.each( data, function(i, n){
							    
						    	 industryArray[i]=n[0];
						    	 countArray[i]=n[1];
							        });
						    myChart.setOption({
								xAxis : {
									data :industryArray
								},
								series : [ {
									// 根据名字对应到相应的系列
									name : '客户数量',
									data :countArray
								} ]
							});
						    
							  },"json");
					  myChart.setOption(option);
					  myChart.hideLoading();
					  
					//fetchData(function(data) {
						
					//});
					
				</script>

			</td>
		</tr>
	</table>
</body>
</html>