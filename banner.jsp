<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Title</title>
<style type="text/css">
<!--
body {
	font: 100%/1.4 Verdana, Arial, Helvetica, sans-serif;
	background-color: #42413C;
	margin: 0;
	padding: 0;
	color: #000;
}

/* ~~ Ԫ��/��ǩѡ���� ~~ */
ul, ol, dl { /* ���������֮��Ĳ��죬������������б��н����ͱ߾඼����Ϊ�㡣Ϊ�˱���һ�£��������ڴ˴�ָ����Ҫ����ֵ��Ҳ�������б����������б��LI��DT �� DD����ָ����Ҫ����ֵ����ע�⣬���Ǳ�дһ����Ϊ�����ѡ�������������ڴ˴����е����ý������� .nav �б� */
	padding: 0;
	margin: 0;
}
h1, h2, h3, h4, h5, h6, p {
	margin-top: 0;	 /* ɾ���ϱ߾���Խ���߾�ᳬ��������� div �����⡣ʣ����±߾����ʹ div �������κ�Ԫ�ر���һ�����롣 */
	padding-right: 15px;
	padding-left: 15px; /* �� div �ڵ�Ԫ�ز�ߣ������� div ����������ɱ���ʹ���κη���ģ����ѧ�����⣬Ҳ�ɽ����в������Ƕ�� div ������������� */
}
a img { /* ��ѡ������ɾ��ĳЩ���������ʾ��ͼ����Χ��Ĭ����ɫ�߿򣨵���ͼ�������������ʱ�� */
	border: none;
}
/* ~~ վ�����ӵ���ʽ���뱣�ִ�˳�򣬰������ڴ�����ͣЧ����ѡ���������ڡ� ~~ */
a:link {
	color: #42413C;
	text-decoration: underline; /* ���ǽ��������óɼ�Ϊ���ص������ʽ����������ṩ�»��ߣ��Ա�ɴ��Ӿ��Ͽ���ʶ�� */
}
a:visited {
	color: #6E6C64;
	text-decoration: underline;
}
a:hover, a:active, a:focus { /* ����ѡ������Ϊ���̵������ṩ�����ʹ������ͬ����ͣ���顣 */
	text-decoration: none;
}

/* ~~ �˹̶��������������������Ԫ�� ~~ */
.container {
	width: 960px;
	background-color: #FFF;
	margin: 0 auto; /* ��ߵ��Զ�ֵ���Ƚ��ʹ�ã����Խ����־��ж��� */
}

/* ~~ ����δָ����ȡ�������չ�����ֵ�������ȡ��������һ��ͼ��ռλ������ռλ��Ӧ�滻Ϊ���Լ������ӻձ� ~~ */
.header {
	background-color: #B0C4DE;
}

.menu {
	background-color: #EEE;
}

/* ~~ ���ǲ�����Ϣ�� ~~ 

1) ���ֻ������� div �Ķ�����/��ײ����� div �е�Ԫ�ز�߻�����䡣�����������Ա���ʹ���κΡ�����ģ����ѧ������ע�⣬����� div ��������κβ������߿���Щ�������߿���������Ŀ����ӣ��ó� *�ܼ�* ��ȡ���Ҳ����ѡ��ɾ�� div �е�Ԫ�ص���䣬���ڸ�Ԫ�����������һ��û���κο�ȵ���������������� div��

*/
.content {

	padding: 10px 0;
}

/* ~~ ��ע ~~ */
.footer {
	padding: 10px 0;
	background-color: #CCC49F;
}

/* ~~ ��������/����� ~~ */
.fltrt {  /* �����������ҳ����ʹԪ�����Ҹ���������Ԫ�ر���λ������ҳ���ϵ�����Ԫ��֮ǰ�� */
	float: right;
	margin-left: 8px;
}
.fltlft { /* �����������ҳ����ʹԪ�����󸡶�������Ԫ�ر���λ������ҳ���ϵ�����Ԫ��֮ǰ�� */
	float: left;
	margin-right: 8px;
}
.clearfloat { /* ����� .container ��ɾ���� overflow:hidden������Խ���������� <br /> ��� div �У���Ϊ #container �����һ������ div ֮�������Ԫ�� */
	clear:both;
	height:0;
	font-size: 1px;
	line-height: 0px;
}
.search-field .shadow-x{
   position:absolute;
   top:0;
   left:1px;
   width:438px;
   height:0;
   border-top:1px solid #d0d0d0;
   border-bottom:1px solid #f0f0f0;
   overflow:hidden;
   z-index:1;
}
.search-field .shadow-y{
   position:absolute;
   top:0;
   left:0;
   width:0;
   height:30px;
   border-left:1px solid #d0d0d0;
   border-right:1px solid #f0f0f0;
   overflow:hidden;
}
-->
</style>
<link href="/CTest2.4/css/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
<script src="/CTest2.4/css/SpryMenuBar.js" type="text/javascript"></script>

</head>
<body>




  <div class="header">
  
    <table border="0" width="960" align="center">
      <tr>
        <td>
          <a href="index.jsp"><img src="/CTest2.4/images/chelp.png" alt="insert logo" name="Insert_logo" width="400" height="100" id="Insert_logo" style="background-color: #B0C4DE; display:block;" /></a>
        </td>
        <td>
          <form name="searchForm" method="post" action="/CTest2.4/search_results.jsp">
			<label for="textfield"></label>
        	<input type="text" name="keyWord" id="textfield" />
        	<input type="submit" name="button" id="button" value="����" />
          </form>
        </td>
      </tr>
    </table>
    
  <!-- end .header --></div>
  
      <div class="menu">
	      <table width="960" border="0" align="center">
	        <tr>
	          <td><ul id="MenuBar1" class="MenuBarHorizontal">
	            <li><a href="/CTest2.4/index.jsp">��ҳ</a>              </li>
	            <li><a href="#" class="MenuBarItemSubmenu">��¼</a>
	              <ul>
	                <li><a href="/CTest2.4/user_login.jsp">ѧ����¼</a></li>
	                <li><a href="/CTest2.4/register.jsp">ע�����û�</a></li>
	                <li><a href="/CTest2.4/login.jsp">����Ա��¼</a></li>
	              </ul>
	            </li>
	            <li><a class="MenuBarItemSubmenu" href="#">����ѧϰ</a>
	              <ul>
	                <li><a href="/CTest2.4/materials.jsp?file_name=c-tutorial">ѧϰ����</a></li>
	                <li><a href="/CTest2.4/chapters.jsp">�½�����</a></li>
	                <li><a href="/CTest2.4/simulation.jsp">ģ������</a></li>
	                <li><a href="/CTest2.4/olds.jsp">��������</a></li>
	              </ul>
	            </li>
	            <li><a href="#">ģ��ѵ��</a></li>
	            <li><a href="videos.jsp?page=1">��Ƶ����</a></li>
	            <li><a href="#">Ԥ������</a></li>
	          </ul></td>
	          <td>
	          
	          <%String username = (String)session.getAttribute("username"); 
				if (username == null || "".equals(username)) {
					out.print("<a href=\"/CTest2.4/user_login.jsp\">��δ��¼</a>");
				} else {
					out.print("�û���" + username + "&nbsp;&nbsp;");
					out.print("<a href=\"/CTest2.4/personal.jsp\">[��������]</a>");
				}
				
				%>
	          
	          </td>
	        </tr>
	      </table>
      </div>
      <div class="search"></div>
    



 <script type="text/javascript">
var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown:"/CTest2.4/css/SpryMenuBarDownHover.gif", imgRight:"/CTest2.4/css/SpryMenuBarRightHover.gif"});
</script>
</body>
</html>