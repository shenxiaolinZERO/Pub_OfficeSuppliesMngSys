

$(document).ready(function(){
    loadDate(1);

});


//加载数据
function loadDate(pn){

    $.ajax({
    type:"post",
    dataType:"json",
    url:"http://192.168.35.111:8080/officeSystem/BorrowApply/getAuditBorrowApplies.do",

    data: JSON.stringify({"pageIndex":pn,"pageCount":"5"}),
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
                html1 +='<td>'+array.itemId+'</td>';
                html1 +='<td>'+array.itemName+'</td>';
                html1 +='<td>'+array.itemTypeName+'</td>';
                html1 +='<td>'+array.spec+'</td>';
                html1 +='<td>'+array.borrowNum+'</td>';
                html1 +='<td>'+array.borrowerName+'</td>';
                html1 +='<td>'+array.applyTime+'</td>';
                //审核结果
                html1 +='<td>'+array.state+'</td>';
                html1 +='<td>'+array.auditTime+'</td>';
                //借用状态
                html1 +='<td>'+array.preReturnTime+'</td>';

                html1 +='<td>'+array.isValid+'</td>';
                html1 +='<td><button id="'+array.id+'" onclick="add(this)">删除</button></td>';
                html1 +='</tr>';
            }
            $("tbody").append(html1);

        }
    },
})
}

//查找筛选已超期物品
function overTime(){
    $("tbody").empty();
    var x = {
        "pageIndex":"1",
        "pageCount":"5"
    };
    console.log(x);
    $.ajax({
        type:"post",
        url:"http://192.168.35.111:8080/officeSystem/OverTimeBorrowApply/getBorrowApplyWarningPassHome.do",
        data:JSON.stringify(x),
        dataType:"json",
        header:{
            "Content-Type":"application/json",
            "Accept":"application/json"
        },
        success:function(data){
            console.log(data.message);

            var html2 = "";

            for(var i=0;i<data.resultList.length;i++){
                html2 +='<tr>';
                var array=data.resultList[i];
                html2 +='<td>'+array.itemId+'</td>';
                html2 +='<td>'+array.itemName+'</td>';
                html2 +='<td>'+array.itemTypeName+'</td>';
                html2 +='<td>'+array.spec+'</td>';
                html2 +='<td>'+array.borrowNum+'</td>';
                html2 +='<td>'+array.borrowerName+'</td>';
                html2 +='<td>'+array.telephone+'</td>';
                html2 +='<td>'+array.borrowTime+'</td>';
                html2 +='<td>'+array.preReturnTime+'</td>';
                html2 +='<td>'+array.inventory+'</td>';
                html2 +='<td>'+array.remark+'</td>';
                html2 +='</tr>';
            }
            $("tbody").append(html2);
        }
    })
}


//根据输入的ID搜索条件搜索
function searchById(){
    $("tbody").empty();
    var itemId=$("input[name='itemId']").val();
    var x = {
        "itemId":itemId
    };
    console.log(x);
    $.ajax({
        type:"post",
        url:"http://192.168.35.111:8080/officeSystem/OverTimeBorrowApply/getBorrowedXXAppliesByItemId.do",
        data:JSON.stringify(x),
        dataType:"json",
        header:{
            "Content-Type":"application/json",
            "Accept":"application/json"
        },
        success:function(data){
            console.log(JSON.stringify(data));
            console.log(data.length);
            var html3 = "";

            for(var i=0;i<data.length;i++){
                html3 +='<tr>';
                html3 +='<td>'+data[i].itemId+'</td>';
                html3 +='<td>'+data[i].itemName+'</td>';
                html3 +='<td>'+data[i].itemTypeName+'</td>';
                html3 +='<td>'+data[i].spec+'</td>';
                html3 +='<td>'+data[i].borrowNum+'</td>';
                html3 +='<td>'+data[i].borrowerName+'</td>';
                html3 +='<td>'+data[i].telephone+'</td>';
                html3 +='<td>'+data[i].borrowTime+'</td>';
                html3 +='<td>'+data[i].preReturnTime+'</td>';
                html3 +='<td>'+data[i].inventory+'</td>';
                html3 +='<td>'+data[i].remark+'</td>';
                html3 +='</tr>';
            }
            $("tbody").append(html3);
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

