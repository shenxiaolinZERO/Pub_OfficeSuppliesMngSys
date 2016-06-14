/**
 * Created by user10 on 2016/6/1.
 */

$(document).ready(function () {
                getIntype();
            });
//$(function(){
//    getInType();
//
//});
            var data1=[];

            function getIntype(){
                $.ajax({
                    type:"post",
                    dataType:"json",
                    url:"http://192.168.35.111:8080/officeSystem/InstorageCheckIn/getInstorageType.do",
                    //data:"",
                    success:function(data){
                        var len=data.length;
            //data1=data;
            //var i;
            //console.log(data1[i].id);
            //for(var j=0;j<len;j++){
            //    var jian=data[j].name;
            //    var zhi=data[j].id;
            //    var data2={};
            //    //alert(data2);
            //    data1[j]=data2;
            //}
            //console.log(data1);
            //console.log(data);

            //alert(len);
            //$('#selectIn').attr("length",'0');

            $("#selectIn").append(('<option value="0"> </option>'));
            for(var i=0;i<len;i++){
                //var option=document.createElement("option");
                //option.value=data[i].id;
                //alert(option.value);
                //$("#selectIn").append(option);


                $("#selectIn").append(('<option value='+data[i].id+'>'+data[i].name+'</option>'));
                //console.log($('option').val("value"));
                //console.log("123"+data[i].id);
                //alert($("#selectIn").val("value"));
            }
            //for(var j=0;j<len;j++){
            //    console.log($('option').val("value"));
            //}

            //var opts=document.getElementById("selectIn").options;
            //for(var i=0;i<opts.length;i++){
            //    if(opts.selected){
            //       // console.log(opts[i].value);
            //        //if(opts[i].value==1){window.location.href="comAdmin_in_purchase.html"; }
            //        switch (opts[i].value){
            //            //case "1":window.open("comAdmin_in_purchase.html");
            //            case "1": window.location.href='http://localhost:63342/OfficeMngSys_02/comAdmin_in_purchase.html';
            //
            //            //case "1":$("#selectIn option a").attr("href","comAdmin_in_purchase.html").on;
            //                     //document.getElementById("selectIn").innerHTML=href("comAdmin_in_purchase.html");
            //                break;
            //            case "2":window.open("comAdmin_in_return.html");
            //                break;
            //            case "3":window.open("comAdmin_in_gain.html");
            //                break;
            //        }
            //    }
            //}
        },
        error:function(data){
            console.log(data);
        }
    });
}