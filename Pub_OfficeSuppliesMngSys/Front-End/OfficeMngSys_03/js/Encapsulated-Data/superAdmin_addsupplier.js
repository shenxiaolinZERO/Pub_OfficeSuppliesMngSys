/**
 * Created by user10 on 2016/6/22.
 */
//$(function(){})和$(document).ready(function(){}) 的用法

$(function(){
    $("#submit-info").click(function () {
        $.validator.setDefaults({
            submitHandler: function () {
                saveForm();
            }
        });
        ensureValid();
    })
});


//"fullName": "供应商全称",
//    "shortName": "供应商简称",
//    "supplierTypeId": "供应商类型",
//    "linkman": "联系人",
//    "cellPhoneNumber": "手机号码",
//    "phone": "联系电话",
//    "fax": "传真",
//    "postcode": "邮编",
//    "address": "地址",
//    "remark": "备注"

function saveForm(){
    console.log("添加供应商啊");
    //获取用户输入的数据
    var supplierId=$("#supplier-id").val();
    var fullName=$("#supplier-fullName").val();
    var shortName=$("#supplier-shortName").val();
       //类型
    var supplierTypeId=$("#supplier-type").val();

    var linkman=$("#supplier-contact").val();
    var cellPhoneNumber=$("#supplier-telephone").val();
    var phone=$("#supplier-phone").val();
    var fax=$("#supplier-fax").val();
    var postcode=$("#supplier-postcode").val();
    var address=$("#supplier-address").val();
    var remark=$("#supplier-remark").val();

    var  x = {
        "pageIndex":pn,
        "pageCount":pageCount,
        "startTime":startTime,
        "endTime":endTime,
        "itemTypeId":itemTypeId,
        "itemName":itemName,
        "inStorageTypeId":inStorageTypeId
    };

    $.ajax({
        url:"http://192.168.35.111:8080/officeSystem/SupplierManager/addSupplier.do",
        type:"post",
        dataType:"json",
        data: JSON.stringify(x),
        success: function (data) {
            alert("成功提交");
            $('#form-submit')[0].reset();
            console.log("成功添加供应商信息");

        },
        error: function () {
            console.log("操作失败");
        }

    })
}

function ensureValid(){
    $("#form-submit").validate({
        rules:{
            supplierId: {
                required:true
           },
            fullName:{
                required:true
            },
            shortName:{
                required:true
            },

            supplierTypeId: {
                required:true
            },
            linkman:{
                required:true
            },
            cellPhoneNumber:{
                required:true
            },

            phone:{
                required:true
            },
            fax:{
                required:true
            },
            postcode:{
                required:true
            },
            address:{
                required:true
            }
            //remark: {
            //    required:true
            //}

        },
        messages:{
            supplierId: {
                required:"供应商编号不能为空"
            },
            fullName:{
                required:"供应商全称不能为空"
            },
            shortName:{
                required:"供应商简称不能为空"
            },

            supplierTypeId: {
                required:"供应商类型ID不能为空"
            },
            linkman:{
                required:"联系人不能为空"
            },
            cellPhoneNumber:{
                required:"手机号码不能为空"
            },

            phone:{
                required:"联系电话不能为空"
            },
            fax:{
                required:"传真不能为空"
            },
            postcode:{
                required:"邮编不能为空"
            },
            address:{
                required:"地址不能为空"
            }
        }

    })
}