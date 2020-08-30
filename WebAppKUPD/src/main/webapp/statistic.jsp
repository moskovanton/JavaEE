<%@page import="java.util.ArrayList"%>
<%@page import="KUDP.*"%>
<%@page import="com.mycompany.webappkupd.MainFormServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="base" tagdir="/WEB-INF/tags/"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Statistic</title>
    </head>
    <body>
        <base:navbar></base:navbar>
        <h1>Статистика</h1>
        <% 
            ArrayList<Way> way1 = new ArrayList<>();
            ArrayList<Way> way2 = new ArrayList<>();
            ArrayList<Way> workWay;
            String filePath = null;
            String way = null;
            
            if (session.getAttribute("filePath") != null)
            filePath = session.getAttribute("filePath").toString();
            if (session.getAttribute("way") != null)
            way = session.getAttribute("way").toString();
            
            if ((filePath != null) && (filePath != "") 
                && (way != null)){
                //Считывание данных из файла и запись их в коллекцию
                CSVReader.Reader(filePath, way1, way2);
        
                //Выбор пути
                if (way.equals("first")) workWay = new ArrayList<>(way1);
                else workWay = new ArrayList<>(way2);
        
                WayHandler.RedundantInformationDeleter(workWay);
            
                out.println("<p>Фотодатчик №1 сработал " 
                    + Statistics.FD1Statistics(workWay) 
                    + " раз.</p>");
                out.println("<p>Фотодатчик №2 сработал " 
                    + Statistics.FD2Statistics(workWay) 
                    + " раз.</p>");
                out.println("<p>Фотодатчик №3 сработал " 
                    + Statistics.FD3Statistics(workWay) 
                    + " раз.</p>");
                out.println("<p>Фотодатчик №4 сработал " 
                    + Statistics.FD4Statistics(workWay) 
                    + " раз.</p>");
                out.println("<p>Количество прибывших поездов: " 
                    + Statistics.RNPStatistics(workWay) 
                    + " .</p>");
                out.println("<p>РОАЗ сработало " 
                    + Statistics.ROAZStatistics(workWay) 
                    + " раз.</p>");
                out.println("<p>Количество иклов откр/закр: " 
                    + Statistics.CloseASDStatistics(workWay) 
                    + " .</p>");    
                out.close();
            }
        %>
    </body>
</html>