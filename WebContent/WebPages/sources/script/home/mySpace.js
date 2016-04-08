/**
 * Created by 0 on 2016/4/4.
 */
function doClick(o){
//当前被中的对象设置css
    o.className="tab_current";
    var j;
    var id;
    var e;
//遍历所有的页签，没有被选中的设置其没有被选中的css
    for(var i=1;i<=3;i++){ //i<3 多少个栏目就填多大值
        id ="tab"+i;
        j = document.getElementById(id);
        e = document.getElementById("sub"+i);
        if(id != o.id){
            j.className="tab_link";
            e.style.display = "none";
            j.style.background = "#0460AD";
        }else{
            e.style.display = "block";
            j.style.background = "#0D72CC";
        }
    }
}