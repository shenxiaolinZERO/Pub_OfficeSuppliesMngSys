/**
 * Created by user10 on 2016/5/30.
 */
/*---------加载入库-采购-----------*/
$(document).ready(function () {
    $('#purchase-info').dataTable({

        }
    )
})







function loadInPurchase(){
    //"inStorageTypeId": "所选的入库类型Id类型(1、采购，2、归还，3、受赠)",
    var x={"inStorageTypeId":1};
    console.log(x);
    $.ajax({
        type:"post",
        url:"http://192./InstorageCheckIn/sendInStorage.do",
        data:JSON.stringify(x),
        dataType:"json",
        header:{
            "Content-Type":"application/json",
            "Accept":"application/json"
        },
        success:function(data){
            var json=data;
            console.log(data);


            var html1 = '';
            for(var i= 0;i<json.posStamp.length;i++){

                html1 +='<tr>';
                html1 +='<td><input type="checkbox"/></td>';
                html1 +='<td>'+json.posStamp[i].puritemId+'</td>';
                html1 +='<td>'+json.posStamp[i].puritemName+'</td>';
                html1 +='<td>'+json.posStamp[i].puritemSpec+'</td>';
                html1 +='<td>'+json.posStamp[i].pursupplierName+'</td>';
                html1 +='<td>'+json.posStamp[i].puritemType+'</td>';
                html1 +='<td><button id="inStorage">入库</button></td>';
                html1 +='<tr>';
            }
            $("#purchaseItem").append(html1);
        }
    })

}
