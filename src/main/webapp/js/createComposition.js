import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../scss/style.css';

window.$ = require('jquery');

$('document').ready(function(){
    $(document).on("submit", "#compAttr", function(event) {
        let $form = $(this);

        $.post($form.attr("action"), $form.serialize(), function (responseJson) {
            if(responseJson.redirect) {
                window.location = responseJson.redirect;
            }
        });
        event.preventDefault(); // Important! Prevents submitting the form.
        return;
    });
});