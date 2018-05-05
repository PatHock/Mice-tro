import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../scss/style.css';
import '../scss/createAccount.css';

window.$ = require('jquery');


$('document').ready(function(){
    // doPost
    $(document).on("submit", "#accountForm", function(event) {
        let $form = $(this);

        $.post($form.attr("action"), $form.serialize(), function (responseJson) {
            if (form.attr(""))
            if(responseJson.redirect) {
                window.location = responseJson.redirect;
            }
            else if(responseJson.messageerror) {
                let $message = $("#loginErrMsg");
                $("div[class='alert alert-danger']").remove();
                $("<div></div>", {
                    id: "accountErr",
                    class: "alert alert-danger",
                    text: responseJson.messageerror,
                    role: "alert"
                }).appendTo($message);
            }
            return;
        });
        event.preventDefault(); // Important! Prevents submitting the form.
    });

    $('.fliper-btn').click(function(){
        $('.flip').find('.card').toggleClass('flipped');
    });
});