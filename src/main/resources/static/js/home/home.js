$(document).ready(function(){
    loadDefaultChart();
    $('#chart-generation-button').click(function(e){
        data = [];
        labels = [];
        var nonDeserialisedjson = $("#categoryExpense").val();
        var myData = jQuery.parseJSON(nonDeserialisedjson);
        var expectedChecks = $('input.form-check-input').length;
        for(i = 0; i < expectedChecks;i++){
            var chkboxname = "#cat-"+i;
            if ($(chkboxname).is(":checked")){
                var temp = $(chkboxname).val();
                labels.push(temp);
                var amount_expense = myData[temp];
                data.push(amount_expense);
            }
        }
        var selectedChart = $("#chart-box option:selected").val();
        loadChart(labels,data,selectedChart);
    });
});

function loadDefaultChart(){
    data = [];
    labels = [];
    var nonDeserialisedjson = $("#categoryExpense").val();
    var myData = jQuery.parseJSON(nonDeserialisedjson);
    for(key in myData){
        labels.push(key);
        data.push(myData[key]);
    }
    loadChart(labels,data,"pie");
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

function parseJSON(data) {
    return window.JSON && window.JSON.parse ? window.JSON.parse( data ) : (new Function("return " + data))();
}
