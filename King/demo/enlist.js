var $ = function(id){
	return document.getElementById(id);
};

function getElementsByClass(name,tag/*,node*/){
	var aNode;
	if(arguments.length > 2){
		aNode = arguments[2];
	}else{
		aNode = document;
	}
	
	var items = aNode.getElementsByTagName(tag);
	var result = [];
	for(var i=0,j=items.length;i<j;i++){
		if(name == ''){
			if(items[i].className == null || items[i].className == ''){
				result.push(items[i]);
			}
		}else{
			if(items[i].className.indexOf(name) >= 0)  {
				result.push(items[i]);
			}
		}
		
	}
	return result;
}

function binding(){
	var btnList = getElementsByClass('arrow_up','div').concat(getElementsByClass('arrow_down','div'));
	for(var i=0;i<btnList.length;i++){
		btnList[i].addEventListener('mousedown',arrowDown,false);
		btnList[i].addEventListener('mouseup',arrowUp,false);
//		btnList[i].addEventListener('click',arrow,false);
//		btnList[i].attachEvent('onmousedown',arrowDown);
//		btnList[i].attachEvent('onmouseupdate',arrowUpdate);
//		btnList[i].attachEvent('onclick',arrow);
	}
}
var mouseDownTStamp = 0;
function arrowDown(e){
	mouseDownTStamp = new Date().getTime();
}
function arrowUp(e){
	var action = e.target.innerHTML;
	var height = '0';
	if(action == '+'){
		height =  '100';
	}else if(action == '-'){
		height = '0';
	}
	var mouseUpTStamp = new Date().getTime();
	
	if(( mouseUpTStamp - mouseDownTStamp) > 300){
		var amount = getElementsByClass('amount','DIV');
		amount[0].style.height = height  + '%';;
		amount[0].style.top = (100 - height) + '%';
		$('am').value = height;
	}else{
		arrow(e);
	}
}

function arrow(e){
	var action = e.target.innerHTML;
	var amount = getElementsByClass('amount','DIV');
//	var container = getElementsByClass('container','DIV');
//	alert('faint');
	var total = 100;
	var current = $('am').value/1;
	if(action == '+'){
		current = Math.min(100,current + 1);
	}else if(action == '-'){
		current = Math.max(0,current - 1);
	}
	$('am').value = current;
	amount[0].style.height = current + '%';
	amount[0].style.top = (total - current) + '%';
	
}
binding();


