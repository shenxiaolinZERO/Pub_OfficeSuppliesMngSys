/**
 * Created by user10 on 2016/5/30.
 */
/*---------加载入库-受赠-----------*/
$(document).ready(function () {
         loadInGain();
})

function loadInGain(){
    //获取赠送物品的信息，传给后台数据库

    $("#inStorage").on("click",function(){

    var itemName = $("input[name='itemName']").val();
    var itemTypeId = $("input[name='itemTypeId']").val();
    var spec = $("input[name='spec']").val();
    var measureUnitId = $("input[name='measureUnitId']").val();
    var maxInventory = $("input[name='maxInventory']").val();
    var minInventory = $("input[name='minInventory']").val();
    var totalNumber = $("input[name='totalNumber']").val();
    var sender = $("input[name='sender']").val();
    var sendTime = $("input[name='sendTime']").val();
    var remark = $("input[name='remark']").val();

    var x = {
        "maxInventory":maxInventory,
        "minInventory":minInventory,
        "itemName": itemName,
        "spec": spec,
        "itemTypeId": itemTypeId,
        "measureUnitId":measureUnitId,
        "remark": null,

        "totalNumber": totalNumber,
        "operaterId":"1",
        "remark": remark,

        "sender": sender,
        "sendTime": sendTime
    };
    console.log(x);

    $.ajax({
        type:"post",
        //这个URL该不该和return 以及purchase一样？
        //url:"http://192.168.35.111:8080/officeSystem/InstorageCheckIn/getInstorageHome.do"
        url:"http://192.168.35.111:8080/officeSystem/InstorageCheckIn/sendInStorage.do",
        data:JSON.stringify(x),
        dataType:"json",
        header:{
            "Content-Type":"application/json",
            "Accept":"application/json"
        },
        success:function(data){
            console.log(data.message);
            if(data.message=="success"){
                alert("成功添加入库");
            }
        }
    })
    });
}

