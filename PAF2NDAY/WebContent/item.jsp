<%@ page import="models.Item" %>
<%@ page import ="javax.sql.*" %>
<%@page import="java.awt.ItemSelectable"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%
 models.Item item = new models.Item();
 String itemsGrid = item.getItems();
%>
    
 <%/*
	Item item = new Item(); 
	String itemsGrid = "";
	String rudFeedback = "";
	
 if(request.getParameter("hidMode") != null && request.getParameter("hidMode").equalsIgnoreCase("save"))
 {
	 rudFeedback = item.saveAnItem(request.getParameter("txtItemName"), request.getParameter("txtItemDesc"));
 }
 if(request.getParameter("hidMode") != null && request.getParameter("hidMode").equalsIgnoreCase("update"))
 {
	 rudFeedback = item.updateAnItem(request.getParameter("hidID"), request.getParameter("txtItemName"),
			 request.getParameter("txtItemDesc"));
 }
 if(request.getParameter("hidMode") != null && request.getParameter("hidMode").equalsIgnoreCase("remove"))
 {
	 rudFeedback = item.deleteAnItem(request.getParameter("hidId"));
 }
 
 itemsGrid = item.getItems();
 */
 %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta  charset=ISO-8859-1">
<title>Items</title>
<script type="text/javascript" src = Controllers/jQuery.js></script>
<script type="text/javascript" src = Controllers/controllerMain.js></script>
</head>
<body>
 <form id="formItems" action="items.jsp" method="post">
<input type="hidden" id="hidItemID" name="hidItemID" value="0">
 Item Name: <input type="text" id="txtItemName" name="txtItemName"> <br>
 Item Description: <input type="text" id="txtItemDesc" name="txtItemDesc">
<br><br>
<input type="button" id="btnSave" name="btnSave" value="Save">
<input type="button" id="btnRefresh" name="btnRefresh" value="Refresh">
<input type="button" id="btnLogout" name="btnLogout" value="Logout">
 <br><br>

<div id="divStsMsgItem"></div>
<div id="divItemsTable"><% out.println(itemsGrid); %></div>
 </form>

</body>
</html>