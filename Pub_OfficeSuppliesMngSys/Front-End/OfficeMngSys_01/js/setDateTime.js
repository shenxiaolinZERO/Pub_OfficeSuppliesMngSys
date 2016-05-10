/**
 * Created by user10 on 2016/3/26.
 */

function startTime(){
    var today=new Date();
    var h=today.getHours();
    var m=today.getMinutes();

    var s=today.getSeconds();
    m=checkTime(m);
    s=checkTime(s);

    document.getElementById("setDateTime").innerHTML=h+":"+m+":"+s;
    t=setTimeout(function(){startTime();},1000);
};

  function checkTime(i){
    if(i<10) {
        i="0"+i;
    }
    return i;
};

