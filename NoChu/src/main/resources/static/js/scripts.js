/*!
* Start Bootstrap - Shop Homepage v5.0.4 (https://startbootstrap.com/template/shop-homepage)
* Copyright 2013-2021 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-shop-homepage/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project

//추가 js

$(document).ready(function(){

    var select = $("select#color");

    select.change(function(){
        var select_name = $(this).children("option:selected").text();
        $(this).siblings("label").text(select_name);

        if(select_name == "제목명"){
            $("#contactForm").attr("action","Songsearch")
        }
        else if(select_name == "가수명"){
            $("#contactForm").attr("action","search")
        }
    });
});

