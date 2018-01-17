$(document).ready(function(){
    loaddatefilter();
    $('#datatable').dataTable();
    $('#submit-model-data-mine').click(function(e){
        return validateModelData();
    })
    $('#get-data-btw-dates-mine').click(function(e){
        var date_mine = $('#datefilter-mine').val();
        var dates = date_mine.split("-");
        $.ajax({
            url: "ajax/getExpenseBetweenDates?from="+dates[0]+"&to="+dates[1],
            type: "POST",
            dataType: "json",
            success: function(result){
                /*No result coming*/
            }
        });
    })
});

function loaddatefilter(){
    $('.datefilter').daterangepicker();
}

function validateModelData(){
    var msg = 0;
    var form = $('#expenses-form-id-mine');
    var data = form.serialize();
    $.ajax({
          url: "/ajax/addExpense",
          type: 'post',
          data: data,
          success: function(response) {

          }
    });
    return false;
}