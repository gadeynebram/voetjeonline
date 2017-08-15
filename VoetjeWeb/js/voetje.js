function listValueChanged(val,inputtext){
    switch (val){
        case "raam": changeOutputFont("voetje_raam");$('#outputtext').val(inputtext);
            break;
        case "braille": changeOutputFont("voetje_braille");$('#outputtext').val(inputtext);
            break;
        case "chinees":changeOutputFont("voetje_chinees");$('#outputtext').val(inputtext);
            break;
        case "handen":changeOutputFont("voetje_handen");$('#outputtext').val(inputtext);
            break;
        case "ladder":changeOutputFont("voetje_ladder");$('#outputtext').val(inputtext);
            break;
        case "morse":$('#outputtext').val(handleMorse(inputtext));
        default: changeOutputFont("\"Helvetica Neue\",Helvetica,Arial,sans-serif");
            break;
    }
}

function changeOutputFont(fontname){
    $('#outputtext').css('font-family',fontname);
}

function inputTextValueChanged(val, listboxvalue){
    switch (listboxvalue){
        case "raam": 
        case "braille": 
        case "chinees":
        case "handen":
        case "ladder": $('#outputtext').val(val);
            break;
        case "morse": $('#outputtext').val(handleMorse(val));
            break;
        default : //no change
            break;
    }
}

function handleMorse(val){
    val=val.toLowerCase();
    var arr=val.split('');
    var res="";
    for(var i = 0; i<arr.length;i++){
        switch(arr[i]){
            case "a": res += ".-"; break;
            case "b": res += "-..."; break;
            case "c": res += "-.-."; break;
            case "d": res += "-.."; break;
            case "e": res += "."; break;
            case "f": res += "..-."; break;
            case "g": res += "--."; break;
            case "h": res += "...."; break;
            case "i": res += ".."; break;
            case "j": res += ".---"; break;
            case "k": res += "-.-"; break;
            case "l": res += ".-.."; break;
            case "m": res += "--"; break;
            case "n": res += "-."; break;
            case "o": res += "---"; break;
            case "p": res += ".--."; break;
            case "q": res += "--.-"; break;
            case "r": res += ".-."; break;
            case "s": res += "..."; break;
            case "t": res += "-"; break;
            case "u": res += "..-"; break;
            case "v": res += "...-"; break;
            case "w": res += ".--"; break;
            case "x": res += "-..-"; break;
            case "y": res += "-.--"; break;
            case "z": res += "--.."; break;
            case "0": res += "-----"; break;
            case "1": res += ".----"; break;
            case "2": res += "..---"; break;
            case "3": res += "...--"; break;
            case "4": res += "....-"; break;
            case "5": res += "....."; break;
            case "6": res += "-...."; break;
            case "7": res += "--..."; break;
            case "8": res += "---.."; break;
            case "9": res += "----."; break;
            default: res+=arr[i];
        }
        res+="/";
    }
    return res;
}