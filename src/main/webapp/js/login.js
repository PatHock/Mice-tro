$(document).on("submit", "#loginForm", function(event) {
    var $form = $(this);

    $.post($form.attr("action"), $form.serialize(), function (responseJson) {
        if(responseJson.redirect) {
            window.location = responseJson.redirect;
        }
        else if(responseJson.messageerror) {
            // $("#loginErrMessDiv").text(responseJson.messageerror);

            // jQuery('<div/>', {
            //     id: 'loginErrMessDiv',
            //     class: 'alert alert-danger',
            //     role: 'alert',
            //     text: responseJson.messageerror
            // }).appendTo('#loginForm');
            var $message = $("#loginErrMsg");
            $("div[class='alert alert-danger']").remove();
            $("<div></div>", {
                id: "loginErr",
                class: "alert alert-danger",
                text: responseJson.messageerror,
                role: "alert"
            }).appendTo($message);
            // $("<loginErr>").text(responseJson.messageerror).appendTo($myTag);
        }
        return;
    });
    event.preventDefault(); // Important! Prevents submitting the form.
});
