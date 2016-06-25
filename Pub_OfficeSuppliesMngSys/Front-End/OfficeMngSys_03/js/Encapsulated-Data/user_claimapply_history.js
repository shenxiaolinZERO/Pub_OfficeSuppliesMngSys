

$(document).ready(function(){
    loadDate(1);

});


//加载数据
function loadDate(pn){
    var pageIndex=pn;
    var pageCount="5";
    var recipienter="-1";
    //var itemId="-1";
    //var itemTypeId="-1";
    //var itemName="-1";


    var  x = {
        "pageIndex":pn,
        "pageCount":pageCount,
        "recipienter":recipienter
        //"itemId":itemId,
        //"itemName":itemName,
        //"itemTypeId":itemTypeId

     };
    console.log(x);
    $.ajax({
        type:"post",
        dataType:"json",
        url:"http://192.168.35.111:8080/officeSystem/RecipientApply/userHistoryRecipientApply.do",
        data: JSON.stringify(x),
        success:function(data){

            console.log(data);
            if(1){
                var page =' ';
                page +='第<input type="text" id="pageIndex" style="border:0;width: 20px;text-align: center;" class="page-current" readonly="readonly" value="'+data.pageIndex+'"/>页';
                page +='共<input type="text" id="pageSize"  style="border:0;width: 20px;text-align: center;" class="page-total" readonly="readonly"value="'+data.pageSize+'"/>页';
                page +='<a class="btn" id="firstPage" onclick="firstPage()">首页</a>';
                page +='<a class="btn" id="previous" onclick="previousPage()">上一页</a>';
                page +='<a class="btn" id="next" onclick="nextPage()">下一页</a>';
                page +='<a class="btn" id="lastPage" onclick="lastPage()">最后一页</a>';
                page +='<input type="text" class="page-num" id="certian-page" style="width: 20px;text-align: center"/>';
                page +='<a class="btn" id="page-jump" onclick="jumpPage()">跳至此页</a>';
                $(".page").append(page);

                var html1 = "";
                for(var i=0;i<data.resultList.length;i++){
                    html1 +='<tr>';
                    var array=data.resultList[i];
                    //!~@#$%^&
                    html1 +='<td>'+array.itemId+'</td>';
                    html1 +='<td>'+array.itemName+'</td>';
                    html1 +='<td>'+array.itemTypeName+'</td>';
                    html1 +='<td>'+array.spec+'</td>';
                    html1 +='<td>'+array.inventory+'</td>';

                    html1 +='<td><button id="'+array.id+'" onclick="confirmPre(this)">申请</button></td>';
                    html1 +='</tr>';
                }
                $("tbody").append(html1);

            }
     }
})
}

//确定预采购
  function confirmPre(element){
        var applyId=element.id;
        var x = {
            "applyId":applyId,
            "staffId":"1",
        };
        console.log(x);
        $.ajax({
            type:"post",
            url:"http://192.168.35.111:8080/officeSystem/ItemProcurement/confirmPreItemProcurement.do",
            data:JSON.stringify(x),
            dataType:"json",
            header:{
                "Content-Type":"application/json",
                "Accept":"application/json"
            },
            success:function(data){
                console.log(data.message);
                if(data.message=="success"){
                    alert("确定预采购成功");
                }
                if(data.message=="error"){
                    alert("确定预采购失败");
                }
            }
        })
    }
//不通过
    function notPass(element){

        var applyId=element.id;
        var reason="no";
        var x = {
            "applyId":applyId,
            "staffId":"1",
            "reason":reason
        };
        console.log(x);
        $.ajax({
            type:"post",
            url:"http://192.168.35.111:8080/officeSystem/ItemProcurement/notPassItemProcurementApply.do",
            data:JSON.stringify(x),
            dataType:"json",
            header:{
                "Content-Type":"application/json",
                "Accept":"application/json"
            },
            success:function(data){
                console.log(data.message);
                if(data.message=="success"){
                    alert("操作成功");
                }
                if(data.message=="error"){
                    alert("操作失败");
                }
            }
        })
    }


//分页的各种方法

//首页
function firstPage(){
    loadReturnDate(1);
}

//尾页
function lastPage(){
  var pn = document.getElementById("pageSize").value;
    loadPurchaseDate(pn);
}

//上一页
function previousPage(){
   var pn1=document.getElementById("pageIndex").value;
    if(pn1==1){
        alert("这已是首页！");
        var pn = parseInt(pn1);
        loadPurchaseDate(pn);
    }else{
        var pn = parseInt(pn1);
        pn-=1;
        loadPurchaseDate(pn);
    }
}

//下一页
function nextPage(){
    var pn1=document.getElementById("pageIndex").value;
    if(pn1==pageSize){
        alert("这已是最后一页！");
        var pn = parseInt(pn1);
        loadPurchaseDate(pn);
    }else{
        var pn = parseInt(pn1);
        pn+=1;
        loadPurchaseDate(pn);
    }
}

//跳转到指定页
function jumpPage(){
    var pn1 = document.getElementById("certian-page").value;
    var pn = parseInt(pn);
    loadPurchaseDate(pn);
    $("#certian-page").val();
}


