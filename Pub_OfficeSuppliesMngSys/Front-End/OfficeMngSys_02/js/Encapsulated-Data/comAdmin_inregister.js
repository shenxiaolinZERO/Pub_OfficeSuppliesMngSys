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
            for(var i=0;i<len;i++){
                var option=document.createElement("option");

                //option.innerHTML=data[i].name;
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

        },
        error:function(data){
            console.log(data);
        }
    });
}