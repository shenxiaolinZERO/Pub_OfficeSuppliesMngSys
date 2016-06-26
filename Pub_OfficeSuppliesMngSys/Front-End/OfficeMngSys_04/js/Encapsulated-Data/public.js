/**
 * Created by user10 on 2016/6/11.
 */
//全选功能函数
function selectAll(){
    var allChoose=document.getElementsByClassName("allChoose")[0];
    var list=document.getElementsByClassName("choose");
    if(allChoose.checked){
        for(var i= 0;i<list.length;i++){
            list[i].checked=true;
        }
        return true;
    }else{
        for(var i=0;i<list.length;i++){
            list[i].checked=false;
        }
        return false;
    }
}