$(document).ready(function(){
    loaddatefilter();
    $('#datatable').dataTable();
});

function loaddatefilter(){
    $('.datefilter').daterangepicker();
}