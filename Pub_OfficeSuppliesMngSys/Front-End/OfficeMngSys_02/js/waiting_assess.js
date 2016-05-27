
/**
 * Created by lenovo on 2016/3/5.
 */
//���ء�����ˡ�
$(document).ready(function(){
    load_wait_assess();

})

function load_wait_assess(){

    //$.ajax({
    //    url : 'http://192.168.199.104:8080/cammatmana/login.mvc?account=1012013001&password=123456',//��¼
    //    //url : 'http://139.129.28.117:8080/cammatmana/executeHQL.mvc?hql=from tb_material',//��ѯ
    //    type : "get",
    //    async : false,
    //    dataType : "jsonp",
    //    jsonp : "callBackParamName", //��������ڽ���callback���õ�function���Ĳ���
    //    jsonpCallback : "callBackName", //callback��function����,����˻�����ƺ�dataһ�𴫵ݻ���
    //    success : function() {
    //        alert("1323");
    //    },
    //    error : function() {
    //        alert("5459");
    //    }
    //})

    $.ajax({
        url: "http://192.168.199.104:8080/demo/test21.do",//��¼
        //url : 'http://127.0.0.1:8080/cammatmana/back/executeHql.mvc?hql=from Material',//��ѯ
        type: "get",
        async: false,
        dataType: "jsonp",
        jsonp: "callBackParamName", //��������ڽ���callback���õ�function���Ĳ���
        jsonpCallback:"callBackName", //callback��function����,����˻�����ƺ�dataһ�𴫵ݻ���
        success:  function() {
                    alert("1323");
                },
        error: function () {
            alert("sdsdf");
        }
    })


    //$.ajax({
    //    url : 'http://192.168.199.104:8080/cammatmana/login.mvc?account=1012013001&password=123456',//��¼
    //    //url : 'http://192.168.199.104:8080/cammatmana/executeHQL.mvc?hql=from tb_material',//��ѯ
    //    type : "get",
    //    async : false,
    //    dataType : "jsonp",
    //    jsonp : "callBackParamName", //��������ڽ���callback���õ�function���Ĳ���
    //    jsonpCallback : "callBackName", //callback��function����,����˻�����ƺ�dataһ�𴫵ݻ���
    //    success : function(json) {
    //        alert(JSON.stringify(json));
    //    },
    //    error : function() {
    //        alert(json);
    //    }
    //});

   // var x={"id":"1", "password":"123" , "name":"����"};
   //// var x={"state":"8", "stayDepartmentId":"1"};
   //  console.log(x);
   // $.ajax({
   //     type:"get",
   //     //url:"http://192.168.199.156:8080/demo/test11.do",
   //     url:"http://192.168.199.104:8080/demo/test11.do",
   //     //url:"http://192.168.199.156:8080/demo/auditTrouble.do",
   //
   //     data:JSON.stringify(x),
   //     dataType:"jsonp",
   //     header:{
   //         "Content-Type": "application/json",
   //         "Accept": "application/json"
   //     },
   //     success:function(data){
   //         var json = data;
   //         console.log(data);
   //         alert("lalallll");
   //
   //         var html='';
   //         //for(var i=0;i<json.collection.length;i++) {
   //         //
   //         //    html1 +='<div class="col-md-3 product">';
   //         //    html1 +='<a href="#"><img src="'+json.collection[i].url+'"></a>';
   //         //    html1 +='<div class="product-bottom">';
   //         //    html1 +='<span class="price">'+'?'+' '+json.collection[i].item_sale_price+'</span>';
   //         //    html1 +='<p><a>'+json.collection[i].item_name+' '+json. collection[i].item_size+'*'+json.collection[i].item_pack+'/'+json.collection[i].item_unit_no+'</a></p>';
   //         //    html1 +='<button type="button" class="btn">ȡ���ղ�</button>';
   //         //    html1 +='</div>';
   //         //    html1 +='</div>';
   //         //}
   //         //$("#like").append(html1);
   //         //deleteCollection();
   //     }
   // })



}
