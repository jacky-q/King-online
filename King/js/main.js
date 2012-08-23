//将字符串转换成json对象
var str2json = function(str) {
	var json = (new Function("return " + str))();
	return json;
};

function go(module){
	window.location.assign(module);
}

function getJSONObject(){
	return str2json($('#obj').val());
}


function trimNull(val){
	if(val == 'null' || val == null || val == 'undefined'){
		return '';
	}else{
		return val;
	}
}