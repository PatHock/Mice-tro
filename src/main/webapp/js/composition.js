import 'bootstrap';
import 'abcjs/abcjs-midi.css';
import abcjs from "abcjs/midi";

window.$ = require('jquery');

import 'bootstrap/dist/css/bootstrap.min.css';
import '../scss/style.css';
import '../scss/composition.css';


/* The only possible way to understand abcjs...
    https://configurator.abcjs.net/visual
 */

$('document').ready(function(){


    const abcEditor = load();
    abcEditor.setNotDirty();
    abcEditor.setReadOnly(false);
    abcEditor.pause(false);
    abcEditor.pauseMidi(false);

    // $('#main-div').on("click", ".btn-secondary", function() {
    //     $.post("composition", document.getElementById("abcText").innerText, function (responseJson) {
    //
    //     });
    // });
});

function load() {
    $.get("composition", function(responseJson) {
        document.getElementById("abc").innerHTML = responseJson.abc;
    });

    let compRe = RegExp("((?<=compId=)\\d+)");
    let compId = compRe.exec(document.cookie)[0];

    console.log("Composition Id is: " + compId + ", Cookie is " + document.cookie);
    let reqParams = {compId: compId};
    $.get("composition", $.param(reqParams), function(responseJson) {
        let abcString = responseJson.abcString;
        console.log(abcString);
        $('#abcText').append(abcString);
    });

    return new abcjs.Editor(
        "abcText",
        {
            paper_id: "paper",
            warnings_id: "warnings-id",
            indicate_changed: true,
            generate_warnings: true,
            generate_midi: true,
            midi_download_id: "midi-download",
            midi_id: "midi",
            abcjsParams: {
                // Add any other MIDI options from "Audio" page.
                add_classes: true,
                clickListener: function(abcElem, tuneNumber, classes) {
                    console.log(abcElem, tuneNumber, classes);
                },
                responsive: "resize",
                generateDownload: true,
            },
        });

}

function getNoteFromClasses(classes) {
    var note = {};
    var noteElemList;
    let regClass = RegExp("((?<=abcjs-)[\\w]*)", "g"); //Regex to find individual class components

    for (var i in classes) {
        if (/note/.test(classes[0])) {
            noteElemList = classes[0].match(regClass);
        }
    }
    if(noteElemList !== undefined) {
        for (let i = 1; i<noteElemList.length; i++) {
            let noteElem = noteElemList[i];
            if (/l/.test(noteElem)) {
                note.line = parseInt(/(\d+)/.exec(noteElem)[0]);
            } else if (/m/.test(noteElem)) {
                note.measureNum = parseInt(/(\d+)/.exec(noteElem)[0]);
            } else if (/n/.test(noteElem)) {
                note.measureIndex = parseInt(/(\d+)/.exec(noteElem)[0]);
            }
        }
    }
    note.measureNum = getAbsoluteMeasureNumber(note.line, note.measureNum);
    return note;
}

function getAbsoluteMeasureNumber(lineNumber, measureNumber) {
    let lines = tuneObjectArray[0].lines;
    let numMeasures = 0;
    let absMeasNumber;

    for (let i = 0; i < lineNumber; i++) {
        for (let j=0; j<lines[i].staff[0].voices[0].length; j++) {
            if (lines[i].staff[0].voices[0][j].type === "bar_thin") {
                numMeasures++;
            }
        }
    }

    absMeasNumber = numMeasures + measureNumber;

    return  absMeasNumber;
}

// return abcjs.renderAbc(
//     "compAbcjs",
//     abc,
//     {
//         add_classes: true,
//         clickListener:
//             function(abcElem, tuneNumber, classes) {
//                 let note = getNoteFromClasses(classes);
//                 console.log(note);
//
//                 alert("Type " + abcElem.el_type+ "\n" +
//                     "Pitch: " + abcElem.pitches[0].pitch + "\n" +
//                     "Duration: " + abcElem.duration + "\n" +
//                     "Measure Number: " + note.measureNum + "\n" +
//                     "Measure Index: " + note.measureIndex
//                 );
//             },
//         responsive: "resize",
//     });