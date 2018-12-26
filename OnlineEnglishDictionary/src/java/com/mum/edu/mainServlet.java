package com.mum.edu;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * @author ranjan
 */

public class mainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchItem = request.getParameter("item");
        System.out.print(searchItem);
        DbConnection dbcon = new DbConnection();
        String result = dbcon.getDefinitionFromDB(searchItem);
        System.out.print(result);
        Map <String, Object> map = new HashMap <String, Object> ();
        map.put("result", result);
        write(response, map);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchItem = request.getParameter("item");
        System.out.print(searchItem);
        DbConnection dbcon = new DbConnection();
        String result = dbcon.getDefinitionFromDB(searchItem);
        System.out.print(result);
        Map <String, Object> map = new HashMap <String, Object> ();
        map.put("result", result);
        write(response, map);
    }

    private void write (HttpServletResponse response, Map <String, Object> map) throws IOException{
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(map));
    }
}
