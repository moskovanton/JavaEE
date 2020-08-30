<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="KUDP.*"%>
<%@page import="com.mycompany.webappkupd.MainFormServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="base" tagdir="/WEB-INF/tags/"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Report</title>
    </head>
    <body>
        <base:navbar></base:navbar>
        <h1>Отчет</h1>
        <%
        String filePath = null;
        String way = null;
        String outputSize = null;
        String filter = null;
        String timeFilter = null;
        String timeFrom = null;
        String timeTo = null;
        
        if (session.getAttribute("filePath") != null)    
        filePath = session.getAttribute("filePath").toString();
        if (session.getAttribute("way") != null)
        way = session.getAttribute("way").toString();
        if (session.getAttribute("outputSize") != null)
        outputSize = session.getAttribute("outputSize").toString();
        if (session.getAttribute("filter") != null)
        filter = session.getAttribute("filter").toString();
        if (session.getAttribute("timeFilter") != null)
        timeFilter = session.getAttribute("timeFilter").toString();
        if (session.getAttribute("timeFrom") != null)
        timeFrom = session.getAttribute("timeFrom").toString();
        if (session.getAttribute("timeTo") != null)
        timeTo = session.getAttribute("timeTo").toString();
        
        ArrayList<Way> way1 = new ArrayList<>();
        ArrayList<Way> way2 = new ArrayList<>();
        ArrayList<Way> workWay;
        
        if ((filePath != null) && (filePath != "") && (way != null) 
        && (outputSize != null) && (filter != null)){
            //Считывание данных из файла и запись их в коллекцию
            CSVReader.Reader(filePath, way1, way2);
        
            //Выбор пути
            if (way.equals("first")) workWay = new ArrayList<>(way1);
            else workWay = new ArrayList<>(way2);
        
            //Выбор размера вывода
            if (outputSize.equals("full")) ;
            else WayHandler.RedundantInformationDeleter(workWay);
        
            //Применение фильтров
            if (filter.equals("ROAZ")) workWay = WayHandler
                .ROAZFilter(workWay);
            else if (filter.equals("OpenASD")) workWay = WayHandler
                .OpenASDFilter(workWay);
        
            //Применение диапазонов
            if (timeFilter != null && timeFrom != null 
            && timeTo != null && timeFilter.equals("ДА")) 
                workWay = WayHandler
                .TimeFilter(workWay, timeFrom, timeTo);        
        
            //Вывод
            try {
                if (way.equals("first")) out.println("<h3>I путь</h3>\n");
                else out.println("<h3>II путь</h3> \n");
                out.println("<table border=\"1px\"><thead> <tr>\n" 
                    + "<th>Время</th>\n" 
                    + "<th>РОАЗ</th>\n" 
                    + "<th>РНП</th>\n" 
                    + "<th>ФД-1</th>\n" + "<th>ФД-2</th>\n"
                    + "<th>ФД-3</th>\n" + "<th>ФД-4</th>\n" 
                    + "<th>Откр. АСД</th>\n" 
                    + "<th>Закр. АСД</th>\n" + "</tr></thead>");
                for (int i = 0; i < workWay.size() - 1; i++) {
                    out.println("<tr><td>" + workWay.get(i).getTime() 
                    + "</td><td>" + workWay.get(i).getROAZ()
                    + "</td><td>" + workWay.get(i).getRNP()
                    + "</td><td>" + workWay.get(i).getFD1()
                    + "</td><td>" + workWay.get(i).getFD2()
                    + "</td><td>" + workWay.get(i).getFD3()
                    + "</td><td>" + workWay.get(i).getFD4()
                    + "</td><td>" + workWay.get(i).getOpenASD()
                    + "</td><td>" + workWay.get(i).getCloseASD()
                    + "</td></tr>");
                }
                out.println("</table>");
            } catch(IOException ex){
             
            System.out.println(ex.getMessage());
            }
            
            out.close();
        }
        %>
    </body>
</html>