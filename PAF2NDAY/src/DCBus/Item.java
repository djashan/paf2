package DCBus;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.collections.MappingChange.Map;


@WebServlet("/Item")
public class Item extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Item() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		models.Item item = new models.Item();
		response.getWriter().append(item.getItems()); 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		models.Item item = new models.Item();
		response.getWriter().append(
		 item.saveAnItem(request.getParameter("txtItemName"),
		 request.getParameter("txtItemDesc"))); 
	}
	
	private static Map getParasMap(HttpServletRequest request)
	{
	 Map<String, String> map = (Map<String, String>) new HashMap<String, String>();

	try
	 {
	 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");

	 String queryString = scanner.hasNext() ?
	 scanner.useDelimiter("\\A").next() : "";

	 scanner.close();

	 String[] params = queryString.split("&");


	 for (String param : params)
	 {
	 String [] p=param.split("=");
	 ((HashMap<String, String>) map).put(p[0], p[1]);
	 }
	 }
	catch(Exception e) {}

	return map;
	}
	
	
	//UPDATE
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
	 Map paras = getParasMap(request);
	 models.Item item = new models.Item();
	response.getWriter().append(item.updateItem(((HashMap<String, String>) paras).get("hidItemID").toString
	(), ((HashMap<String, String>) paras).get("txtItemName").toString(),((HashMap<String, String>) paras).get("txtItemDesc").toString()));
	}


	//DELETE
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
	 Map paras = getParasMap(request);
	 models.Item item = new models.Item();
	 //response.getWriter().append(item.deleteItem(((HashMap<String, String>) paras).get("itemID").toString()));
	}


}
