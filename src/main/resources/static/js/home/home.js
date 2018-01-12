$(document).ready(function(){
    loadDefaultChart();
    $('#chart-generation-button').click(function(e){
        data = [];
        labels = [];
        var expectedChecks = 5;
        for(i = 0; i < expectedChecks;i++){
            var chkboxname = "#cat-"+i;
            if ($(chkboxname).is(":checked")){
                var temp = $(chkboxname).val();
                labels.push(temp);
                var randomnumber = Math.floor(Math.random() * (100 + 1) + 0);
                data.push(randomnumber);
            }
        }
        var selectedChart = $("#chart-box option:selected").val();
        loadChart(labels,data,selectedChart);
    });
});

function loadDefaultChart(){
    var ctx = $("#myChart").get(0).getContext("2d");
    var piechart = new Chart(ctx,{
        type: 'pie',
        data: {
            labels: ["January", "February", "March", "April", "May", "June", "July"],
            datasets: [{
                label: "My First dataset",
                data: [0, 10, 5, 2, 20, 30, 45],
            }]
        },
        options: {
            responsive: false
        }
    });
}

function loadChart(labels,data,selectedChart){
    $('#myChart').remove();
    $('#chart-canvas-mine').append('<canvas id="myChart" width="400" height="400"><canvas>');
    var ctx = $("#myChart").get(0).getContext("2d");
    var chart = new Chart(ctx,{
        type: selectedChart,
        data: {
            labels: labels,
            datasets: [{
                label: "temp chart",
                data: data,
            }]
        },
        options: {
            responsive: false
        }
    });
}