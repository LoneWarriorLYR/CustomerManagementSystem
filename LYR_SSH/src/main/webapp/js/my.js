//<!-- ajax请求，根据数据字典类型码-》加载数据字典下拉项  -->
//使用ajax加载数据字典,生成select
//参数1: 数据字典类型 (dict_type_code)
//参数2: 将下拉选项放入的标签id
//参数3: 生成下拉选项时,select标签的name属性值
//参数4: 需要回显时,选中哪个option
  function loadSelect(typecode,positionId,selectName,selectedId){
	//1.创建select对象，并将name属性指定
	  var $select =  $("<select name="+selectName+"></select>");
	  //2.添加提示选项
	  $select.append($("<option value=''>---请选择---</option>"));
	  //3.使用jQuery的ajax方法，访问后台获取数据
	  $.post("${pageContext.request.contextPath}/BaseDictAction", { dict_type_code:typecode },
          function(data){
              //使用jQuery的遍历方法
               //4.将返回的json集合对象遍历
        	  $.each( data, function(i, json){
        		  //每次遍历创建一个option对象
        		   var $option = $("<option value='"+json['dict_id']+"'>"+json["dict_item_name"]+"</option>");
        		   if(json['dict_id']==selectedId){
        			   //判断是否需要回显，如果需要就被选中
        			   $option.attr("selected","selected");
        		   }
        		   //将创建好的option添加到select对象
        		   $select.append($option);
        		});
          }, "json");
	  //将组装好的select对象放入页面指定位置
	  $("#"+positionId).append($select);
  };
  
  