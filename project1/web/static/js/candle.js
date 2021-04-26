/**
* ---------------------------------------
* This demo was created using amCharts 4.
* 
* For more information visit:
* https://www.amcharts.com/
* 
* Documentation is available at:
* https://www.amcharts.com/docs/v4/
* ---------------------------------------
*/
// console.log("차트 데이터는 ",chartData);

am4core.useTheme(am4themes_animated);

var chart = am4core.create("chartdiv", am4charts.XYChart);
chart.paddingRight = 20;
 
//초기 데이터 입력
var data = [];
var price = 20;

var openP = price;
var lowP = price;
var highP = price;

var cnt = 0;

for (i = 1; i <= 10; i++) {
if(price<10){
    price += Math.round(Math.random() * 10);
}else{
    price -= Math.round((Math.random() < 0.5 ? 1 : -1) * Math.random() * 10); //-10 ~ 10
}

if(price > highP){
    highP = price;
}
if(price < lowP){
    lowP = price;
}

if(i%10==0){
    data.push({ date: new Date().setMinutes(cnt++), close: price
        , open: openP, low: lowP, high: highP });

    openP = price;
    lowP = price;
    highP = price;   
}
}

chart.data = data;


//  chart.dateFormatter.inputDateFormat = "yyyy-MM-dd";
 
var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
dateAxis.renderer.grid.template.location = 0;
dateAxis.renderer.minGridDistance = 60;
dateAxis.dateFormats.setKey("minute", "h:mm a"); //X축 date 표현 설정
//초,분,시 가 바뀔 때 dateFormat.setkey 조건이 안먹어서 구간이 바뀔때 새로 지정
dateAxis.periodChangeDateFormats.setKey("second", "[bold]h:mm a");
dateAxis.periodChangeDateFormats.setKey("minute", "[bold]h:mm a");
dateAxis.periodChangeDateFormats.setKey("hour", "[bold]h:mm a"); 

var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
valueAxis.tooltip.disabled = true;

 
var series = chart.series.push(new am4charts.CandlestickSeries());
series.dataFields.dateX = "date";
series.dataFields.valueY = "close";
series.dataFields.openValueY = "open";
series.dataFields.lowValueY = "low";
series.dataFields.highValueY = "high";
series.tooltipText = "Open: [bold]${openValueY.value}[/]\nLow: [bold]${lowValueY.value}[/]\nHigh: [bold]${highValueY.value}[/]\nClose: [bold]${valueY.value}[/]";

chart.cursor = new am4charts.XYCursor();

chart.scrollbarX = new am4core.Scrollbar();

// add data
var intervalCnt = 0;
var interval;
function startInterval() {
    interval = setInterval(function() {
        if(intervalCnt%10==0){                
            var lastdataItem = series.dataItems.getIndex(series.dataItems.length - 1);
            chart.addData(
                { date: new Date(lastdataItem.dateX.getTime() + 60000), close: price 
                    , open: price, low: price, high: price});

            openP = price;
            lowP = price;
            highP = price;   

            cnt++;
        }
        if(price < 5){
            price += Math.round(Math.random() * 5);
        }else{
            price +=  Math.round((Math.random() < 0.5 ? 1 : -1) * Math.random() * 5);
        }

        
        if(price > highP){
            highP = price;
        }
        if(price < lowP){
            lowP = price;
        }
        
        
        chart.data[cnt-1].close = price;
        chart.data[cnt-1].high = highP;
        chart.data[cnt-1].low = lowP;
        chart.data = data;
        // chart.dataSource.reloadFrequency = 500;
            
        intervalCnt++;
    }, 500);
}

startInterval();
 