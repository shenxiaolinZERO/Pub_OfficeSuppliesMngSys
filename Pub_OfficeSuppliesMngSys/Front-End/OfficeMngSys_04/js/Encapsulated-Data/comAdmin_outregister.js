/**
 * Created by user10 on 2016/6/1.
 */
//$(function () {}  ���ĵ�������Ͼ�ִ��,���������Ч����һ���ġ�
$(document).ready(function () {
      getOuttype();
});


<!--start-��ȡ���Ͳ����û�ѡ�� -->
function getOuttype(){
     $.ajax({
             type:"post",
             dataType:"json",
             url:"http://localhost:8080/officeSystem/OutstorageCheckIn/getOutstorageType.do",
             success:function(data){
                  var len=data.length;

            $("#select-out").append(('<option value="0"> </option>'));
            for(var i=0;i<len;i++){
                $("#select-out").append(('<option value='+data[i].id+'>'+data[i].name+'</option>'));
            }
        },
        error:function(data){
            console.log(data);
        }
    });
}
<!--end-��ȡ���Ͳ����û�ѡ�� -->

