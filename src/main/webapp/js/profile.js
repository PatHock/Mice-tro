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

        // let compositions = document.querySelector('#compositionMenu').getElementsByTagName('button');
        // for (let i=0; i<compositions.length; i++){
        //     let comp = compositions[i];
        //     comp.onclick = loadComposition(this.id);
        // }

    });

    $.get("profile", function(responseJson) {
        document.getElementById("pageTitle").innerHTML = "Welcome, " + responseJson.username + " &#x1F600";
    });

    $('#compositionMenu').on('click', '.list-group-item.list-group-item-action', function() {
        let $this = $(this);
        let reqParams = {compId: this.id};

        // $.get("composition", $.param(reqParams), function(responseJson) {
        //     if(responseJson.redirect) {
        document.cookie = "cookieName=; max-age=-1; path=/;";   // delete cookie
        document.cookie = "compId=" + reqParams.compId + ";";
        window.location = "/micetr0/composition";
                // window.location = responseJson.redirect;
            // }
        // })
    });


});

function appendComposition(obj) {

    let compEntry = {
        title: obj.title,
        description: obj.desc,
        compId: obj.compositionID
    };

    let template = "<h4 class=\"list-group-item-heading\">Title: {{title}}</h4>" +
        "<p class=\"list-group-item-text\">Description: {{description}}</p>";

    let html = Mustache.to_html(template, compEntry);

    $('<button />', {
        "class": "list-group-item list-group-item-action",
        type: 'button',
        id: compEntry.compId,
        // click: loadComposition(),
        html: html
    }).appendTo("#compositionMenu");
}

// function loadComposition() {
//     console.log("composition");
// }

