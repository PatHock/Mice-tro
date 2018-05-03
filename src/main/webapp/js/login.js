import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../scss/style.css';
import '../scss/login.css';

window.$ = require('jquery');

$(document).on("submit", "#loginForm", function(event) {
    let $form = $(this);

    $.post($form.attr("action"), $form.serialize(), function (responseJson) {
        if(responseJson.redirect) {
            window.location = responseJson.redirect;
        }
        else if(responseJson.messageerror) {
            let $message = $("#loginErrMsg");
            $("div[class='alert alert-danger']").remove();
            $("<div></div>", {
                id: "loginErr",
                class: "alert alert-danger",
                text: responseJson.messageerror,
                role: "alert"
            }).appendTo($message);
        }
        return;
    });
    event.preventDefault(); // Important! Prevents submitting the form.
});
