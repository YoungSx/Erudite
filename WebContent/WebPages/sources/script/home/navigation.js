/**
 * Created by 0 on 2016/4/5.
 */
function columnMove(o){
//当前被中的对象设置css
    o.className="columnCurrent";
    var j;
    var id;
    var e;
    var d;
//遍历所有的页签，没有被选中的设置其没有被选中的css
    for(var i=1;i<=5;i++){ //i<3 多少个栏目就填多大值
        id ="column"+i;
        j = document.getElementById(id);
        e = document.getElementById("class"+i);
        d = document.getElementById("classification")
        if(id != o.id){
            j.className="columnLink";
            e.style.display = "none";
            j.style.background = "#0D72CC";
        }else{
            e.style.display = "block";
            d.style.display = "block";
            j.style.background = "#0460AD";
        }
    }
}
function classificationLeave(o){
//当前被中的对象设置css
    o.className="columnCurrent";
    var d;
    d = document.getElementById("classification")
    d.style.display = "none";
}
function columnLeave(o){
//当前被中的对象设置css
    o.className="columnCurrent";
    var d;
    d = document.getElementById("classification")
    d.style.display = "none";

}