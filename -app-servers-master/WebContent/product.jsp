<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.2.6.js"></script>
<script type="text/javascript">
//使用ajax的jquery查询

//定义一个初始全局变量  显示初始第一页
var pageNo=0;


//和body里面onload一样 一加载完窗体就调用
$(function(){
	
	
	//直接调用select
	selectproduct();
	
})

function selectproduct()
{
	//jquery ajax通过post连接
	
	 
	
	var account=$("#account").val();

	//下拉列表有默认值
	var stament1=$("#stament1").val();
 
	var stament2=$("#stament2").val();
	
	var price1=$("#price1").val();
	var price2=$("#price2").val();
	var sale1=$("#sale1").val();
	var sale2=$("#sale2").val();
	
	
	
	$.post("productseverlet.do",
	  {
	    
		 stament1:stament1,
		 stament2:stament2,
		 account:account,
		 price1:price1,
		 price2:price2,
		 sale1:sale1,
		 sale2:sale2,
		 
		 //分页要传过来
		 
		 pageNo:pageNo,
		 
	 	
	  },
	  function(data,status){
		 
		  $("#result").html(data);
	    //alert("Data: " + data + "\nStatus: " + status);
	  });
	
	}
	
	
	function update(updateId)
	{
		
		//不能直接写下面注释的代码    JSTL表达式  request response 是2个浏览器与 服务器之间的关系
		//到另外一个页面它就没了 请求不到了
		 window.open("jstl.do?updateId="+updateId, null, "height=600,width=500");
/* 		$.post("jstl.do",
				  {
				     
					
					updateId:updateId,
				 	
				  },
				  function(data,status){
					  
					  window.open("update.jsp", null, "height=600,width=500");
					 
					 // $("#result").html(data);
				    //alert("Data: " + data + "\nStatus: " + status);
				  }); */
	}
	
function delcheckAll()
{
	
	//可以接受到传过来的删除user表里的主键id
	
	
	
	
	
	
	
	if(window.confirm("是否确定删除!"))
	{
			
		//利用以前写的那个迭代器函数 接受全部checkbox值  name起一样 checkid
		var aihao='';
		
		$('input:checkbox[id="checkid"]:checked').each(function(){
			
			//每一个勾选都调用下面这个函数
			
			delusers($(this).val());
			//aihao+=$(this).val();
		})
		
		//alert(aihao);
		
		//selectproduct();
	
	
	
	}

	
	}
	
function delusers(delid)
{
	
	//可以接受到传过来的删除user表里的主键id
	
	//alert(delid);
	
	
	if(window.confirm("是否确定删除!"))
		{

		$.post("productseverlet.do",
				  {
				    
				    //把值传过去再处理 要传分页
				    
				    	delid:delid,
				    	 pageNo:pageNo,
						
				  },
				  
				  //等结束的时候再调用
				  
				  function(data,status){
					 $("#result").html(data);
				    //alert("Data: " + data + "\nStatus: " + status);
				    
				    //刷新不是浏览器再请求页面   ajax请求页面不叫刷新
				    
						//selectproduct();
				  });
				
		
	
		}
	
	
	
	
	}
	


//上一页

function prePage()
{
	//因为limit 0,每页数量  如果是第一页的话再点上一页还是第一页  分页关键是判断现在是第几页
	//使用jquery写分页  带jsp才可以写<%%>java代码
	
	
	var account=$("#account").val();

	//下拉列表有默认值
	var stament1=$("#stament1").val();
 
	var stament2=$("#stament2").val();
	
	var price1=$("#price1").val();
	var price2=$("#price2").val();
	var sale1=$("#sale1").val();
	var sale2=$("#sale2").val();
	pageNo=pageNo-1;
	if(pageNo<0)
		{
			pageNo=0;
		}

	//alert(pageNo);
	$.post("productseverlet.do",
			  {
			    
			    //把值传过去再处理
			    
			     stament1:stament1,
				stament2:stament2,
				 account:account,
				 price1:price1,
				 price2:price2,
				 sale1:sale1,
				 sale2:sale2,
				 
			    pageNo:pageNo,
				
			  },
			  
			  //等结束的时候再调用
			  
			  function(data,status){
				 $("#result").html(data);
			    //alert("Data: " + data + "\nStatus: " + status);
			    //刷新不是浏览器再请求页面   ajax请求页面不叫刷新
			    
			    
				//selectproduct();并没有传pageNo给serverlet
			  });
			
	}
//下一页

function nextPage()
{
	//var sum = $("#aaa").val();
	
	//sum
	
	var sum=4;
	var account=$("#account").val();

	//下拉列表有默认值
	var stament1=$("#stament1").val();
 
	var stament2=$("#stament2").val();
	
	var price1=$("#price1").val();
	var price2=$("#price2").val();
	var sale1=$("#sale1").val();
	var sale2=$("#sale2").val();
	
	if(pageNo<(sum-1))
	{
		pageNo+=1;
		
		
	}
	//alert("hello1");
	
	$.post("productseverlet.do",
			  {
			    
			    //把值传过去再处理
			    
			    
			   //加这段代码是为了在筛选之后在分页
			   
			   
			    stament1:stament1,
				stament2:stament2,
				 account:account,
				 price1:price1,
				 price2:price2,
				 sale1:sale1,
				 sale2:sale2,
				 
				 
				 
			    pageNo:pageNo,
					
			  },
			  
			  //等结束的时候再调用
			  
			  function(data,status){
				  
				  //接受返回过来的信息 必须的
				  
				  
				  $("#result").html(data);
			    //alert("Data: " + data + "\nStatus: " + status);
			    
			    //刷新不是浏览器再请求页面   ajax请求页面不叫刷新
			    
				//	selectproduct();
			  });
	//alert("hello1");
	}

	
function add()
{
	
	
	//弹出一个对话框
	
	window.open("add.jsp", null, "height=600,width=500");
	
	}
	


</script>


</head>
<body>
<div>

<label>分类：</label>
<select id="stament1">
	
	<option  value=""></option>
	<option  value="1">服装</option>
	<option  value="3">家电</option>
	
	<option  value="10">美妆</option>
	<option  value="11">母婴</option>
	<option  value="12">皮具</option>
	
	<option  value="13">食品</option>
</select>


  <label>二级分类：</label>
<select id="stament2">
	<option value=""></option>
	<option  value="5">皮包</option>
	<option  value="4">彩电</option>
	<option  value="2">皮靴</option>
	
</select>

<label>名称：</label>
<input type="text" id="account"/>

<br>
<label>价格：</label>
<input type="text" id="price1"  style="width: 50px"/>
～
<input type="text" id="price2" style="width: 50px"/>

<label>销量：</label>
<input type="text" id="sale1"  style="width: 50px"/>
～
<input type="text" id="sale2" style="width: 50px"/>

<input type="button" id="but1" value="查询" onclick="selectproduct();"/>



</div>
<div style="background-color: #3399FF;width: 1020px;height: 32px;border: 1px solid;line-height: 30px;border-top: 0px;border-bottom: 0px;">
详细信息
</div>

<div id="result">
</div>

<input type="button" id="butadd" value="新增商品" onclick="add();"/>
<input type="button" id="butdelall" value="批量删除" onclick="delcheckAll();"/>
<br>
	    	  <a href="#" style="text-decoration: none;" onclick="prePage();">上一页</a>
	 		  <a href="#" style="text-decoration: none;" onclick="nextPage();">下一页</a>

</body>
</html>