import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../scss/style.css';
import '../scss/login.css';

window.$ = require('jquery');

$('document').ready(function(){

    $(document).on("submit", "#loginForm", function(event) {
        let $form = $(this);

        $.post($form.attr("action"), $form.serialize() + "&type=login", function (responseJson) {
            if(responseJson.redirect) {
                window.location = responseJson.redirect;
            }
            else if(responseJson.loginError) {
                let $message = $("#loginErrMsg");
                $("div[class='alert alert-danger']").remove();
                $("<div></div>", {
                    id: "loginErr",
                    class: "alert alert-danger",
                    text: responseJson.loginError,
                    role: "alert"
                }).appendTo($message);
            }
            return;
        });
        event.preventDefault(); // Important! Prevents submitting the form.
    });

    $(document).on("submit", "#signupForm", function(event) {
        let $form = $(this);

        $.post($form.attr("action"), $form.serialize() + "&type=signup", function (responseJson) {
            if(responseJson.redirect) {
                window.location = responseJson.redirect;
            }
            else if(responseJson.signupError) {
                let $message = $("#signupErrMsg");
                $("div[class='alert alert-danger']").remove();
                $("<div></div>", {
                    id: "signupErr",
                    class: "alert alert-danger",
                    text: responseJson.signupError,
                    role: "alert"
                }).appendTo($message);
            }
            return;
        });
        event.preventDefault(); // Important! Prevents submitting the form.
    });


    $('.flipper-btn').click(function(){
        $('.flip').find('.card').toggleClass('flipped');
    });

});