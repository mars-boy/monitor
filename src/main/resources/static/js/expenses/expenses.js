$(document).ready(function(){
    loaddatefilter();
    $('#datatable').dataTable();
    $('#submit-model-data-mine').click(function(e){
        return validateModelData();
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