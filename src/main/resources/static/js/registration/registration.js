$(document).ready(function(){
    $( "#confirmpassword" ).prop( "disabled", true );
    $("#username").on("blur",  function() {
        /*username  availability check goes here*/
        var username=$('#username').val();
        if(username != ""){
            $.ajax({
                    url : "chkuser?username="+username,
                    type : "post",
                    async : false,
                    success : function(data) {
                        alert(data);
                        if(data == 'found'){
                           alert("username exists");
                        }else{

                        }
                    }
                });
        }
    });
    $('#password').focus(function () {
        $('#confirmpassword').val('');
        $( "#confirmpassword" ).prop( "disabled", true );
    });
    $("#password").on("blur",function(){
        if($('#password').val() != "")
            $( "#confirmpassword" ).prop( "disabled", false );
    });
    $('#confirmpassword').on("blur",function(){
        if($('#confirmpassword').val() != $('#password').val()){
            alert("password and confirm password incorrect");
        }else{

        }
    });
    $('#submitform').click(function(e){
        return validateUserRegistration();
    });
});

function validateUserRegistration(){
    var msg = 0;
    var username = $('#username').val();
    if(usernmae != ""){
        $.ajax({
                url : "chkuser?username="+username,
                type : "post",
                async : false,
                success : function(data) {
                    alert(data);
                    if(data == 'found'){
                        msg+=1;
                    }
                }
            });
        if($('#confirmpassword').val() != $('#password').val()){
            msg+=1;
        }
    }
    if(msg > 0){
        msg = false;
    }else{
        msg = true;
    }
    return msg;
}