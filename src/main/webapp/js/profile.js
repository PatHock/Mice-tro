import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../scss/style.css';
import '../scss/profile.css';
import 'mustache';
import * as Mustache from "mustache";

window.$ = require('jquery');


$('document').ready(function(){
    $.post("profile", function(responseJson) {
        $.each(responseJson, function (index, obj) {
            // alert(obj.title);
            appendComposition(obj);
        });
    });

});

function appendComposition(obj) {
    let $compDiv = $("#compositionMenu");

    let compEntry = {
        title: obj.title,
        description: obj.desc
    };

    let template = "" +
        "<a href=\"composition\" class=\"list-group-item\">" +
        "    <h4 class=\"list-group-item-heading\">Title: {{title}}</h4>" +
        "    <p class=\"list-group-item-text\">Description: {{description}}</p>" +
        "</a>";

    let html = Mustache.to_html(template, compEntry);

    $($compDiv).append(html);

}
