$(document).on("submit", "#loginForm", function(event) {
    var $form = $(this);

    $.post($form.attr("action"), $form.serialize(), function (responseJson) {
        if(responseJson.redirect) {
            window.location = responseJson.redirect;
        }
        else if(responseJson.messageerror) {
            $("#loginErrMessDiv").text(responseJson.messageerror);
        }
        return;
    });
    event.preventDefault(); // Important! Prevents submitting the form.
});
