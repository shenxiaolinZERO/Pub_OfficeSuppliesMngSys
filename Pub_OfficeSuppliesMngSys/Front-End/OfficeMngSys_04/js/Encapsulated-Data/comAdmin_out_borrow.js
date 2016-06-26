

$(document).ready(function(){
    loadDate(1);
});


//加载数据
function loadDate(pn){
    //var outStorageTypeId="1";
    $.ajax({
    type:"post",
    dataType:"json",
    url:"http://localhost:8080/officeSystem/OutstorageCheckIn/getOutstorageHome.do",

    data: JSON.stringify({"outStorageTypeId":"1","pageIndex":pn,"pageCount":"5"}),
    success:function(data){
        console.log(data);

            //start-加载分页
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
            //end-加载分页


            var html1 = "";
            console.log(data.resultList.length);
            for(var i=0;i<data.resultList.length;i++){
                html1 +='<tr>';
                var array=data.resultList[i];
                html1 +='<td><input class="choose" type="checkbox"/></td>';
                html1 +='<td>'+array.itemId+'</td>';
                html1 +='<td>'+array.itemName+'</td>';
                html1 +='<td>'+array.itemTypeName+'</td>';
                html1 +='<td>'+array.spec+'</td>';
                html1 +='<td>'+array.borrowNum+'</td>';
                html1 +='<td>'+array.borrowerName+'</td>';
                html1 +='<td>'+array.auditTime+'</td>';
                html1 +='<td>'+array.remark+'</td>';
                html1 +='<td><button id="'+array.id+'" onclick="out(this)">出库</button></td>';
                html1 +='</tr>';
            }
            $("tbody").append(html1);

    },
})
}

//点击出库按钮进行归还入库
function out(element){
    //var idList=new Array();
    //var f={};
    //f.id=element.id;
    //idList.push(f);
    //console.log(JSON.stringify(idList));
    ////var id=element.id;
    //idList.push(id);
    //alert(idList[0]);
    var x = {
        "outStorageTypeId":"1",
        //"idList":idList,
        "id":"8",
        "operaterId":"2",
    };
    console.log(x);
    $.ajax({
        type:"post",
        url:"http://localhost:8080/officeSystem/OutstorageCheckIn/operateOutStorageCheckIn.do",
        data:JSON.stringify(x),
        dataType:"json",
        header:{
            "Content-Type":"application/json",
            "Accept":"application/json"
        },
        success:function(data){
            console.log(data.message);
            if(data.message=="success"){
                alert("成功出库");
            }
            if(data.message=="error"){
                alert("出库失败");
            }
        }
    })
}



//根据搜索条件搜索
function search(){
    var itemName=$("#itemName").val();
    // var itemTypeId=$("input[value]).val();
    var x = {
        "itemName":itemName,
        "itemTypeId":1,
        "staffId":"1"
    };
    console.log(x);
    $.ajax({
        type:"post",
        url:"http://localhost:8080/officeSystem/InstorageCheckIn/getBorrowApplyByMap.do",
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
                html2 +='<td><input class="choose" type="checkbox"/></td>';
                html2 +='<td>'+array.itemId+'</td>';
                html2 +='<td>'+array.itemName+'</td>';
                html2 +='<td>'+array.itemTypeName+'</td>';
                html2 +='<td>'+array.measureUnitName+'</td>';
                html2 +='<td>'+array.num+'</td>';
                html2 +='<td>'+array.staffName+'</td>';
                html2 +='<td>'+array.time+'</td>';
                html2 +='<td><button id="'+array.id+'" onclick="add(this)">入库</button></td>';
                html2 +='</tr>';
                $("tbody").append(html2);
            }
        }
    })
}


//分页的各种方法

//首页
function firstPage(){
    loadDate(1);
}

//尾页
function lastPage(){
  var pn = document.getElementById("pageSize").value;
    loadDate(pn);
}

//上一页
function previousPage(){
   var pn1=document.getElementById("pageIndex").value;
    if(pn1==1){
        alert("这已是首页！");
        var pn = parseInt(pn1);
        loadDate(pn);
    }else{
        var pn = parseInt(pn1);
        pn-=1;
        loadDate(pn);
    }
}

//下一页
function nextPage(){
    var pn1=document.getElementById("pageIndex").value;
    if(pn1==pageSize){
        alert("这已是最后一页！");
        var pn = parseInt(pn1);
        loadDate(pn);
    }else{
        var pn = parseInt(pn1);
        pn+=1;
        loadDate(pn);
    }
}

//跳转到指定页
function jumpPage(){
    var pn1 = document.getElementById("certian-page").value;
    var pn = parseInt(pn);
    loadDate(pn);
    $("#certian-page").val();
}

