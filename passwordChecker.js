var $criteriaSet = $('#criteria');
$("#criteria-container").hide();

function genCharArray(charA, charZ) {
    var a = [], i = charA.charCodeAt(0), j = charZ.charCodeAt(0);
    for (; i <= j; ++i) {
        a.push(String.fromCharCode(i));
    }
    return a;
}


$("input#registeredPassword").keyup(function(){
    $("#criteria-container").show();
    $("div#criteria-container").addClass('checking');
    
    
    var passWord = $('#registeredPassword').val();
    var regex1 = genCharArray('A','Z');
    var regex2 = genCharArray('a','z');
    var regex3 = genCharArray('0','9');
    
    var checkUppercase = false;
    var checkLowercase = false;
    var checkNumber = false;
    
    
    
    if (passWord.length >= 8){
        $('li#character').removeClass('checking');
        $('li#character').addClass('checked');
    }
    else {
        $('li#character').removeClass('checked')
        $('li#character').addClass('checking');
    }
    
    
    
    for (var i=0; i < passWord.length; i++){
        if (regex1.includes(passWord[i])){checkUppercase=true;}
        if (regex2.includes(passWord[i])){checkLowercase=true;}
        if (regex3.includes(passWord[i])){checkNumber=true;}
        
        if (passWord.length >= 1){
            if (checkLowercase && checkUppercase){
                $('li#characteristic').removeClass('checking');
                $('li#characteristic').addClass('checked');
            }
            else {
                $('li#characteristic').removeClass('checked');
                $('li#characteristic').addClass('checking');
            }
            if (checkLowercase && checkUppercase && checkNumber){
                $('li#specialCharacter').removeClass('checking');
                $('li#specialCharacter').addClass('checked');
            }
            else {
                $('li#specialCharacter').removeClass('checked');
                $('li#specialCharacter').addClass('checking');
            }
        }
    }
    
    
    
});  




