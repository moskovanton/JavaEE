<%@page import="java.util.ArrayList"%>
<%@page import="KUDP.*"%>
<%@page import="com.mycompany.webappkupd.MainFormServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="base" tagdir="/WEB-INF/tags/"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recommendation</title>
    </head>
    <body>
        <base:navbar></base:navbar>
        <h1>Рекомендации</h1>
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
            
            if ((filePath != null) && (filePath != "") && (way != null)){
                
                //Считывание данных из файла и запись их в коллекцию
                CSVReader.Reader(filePath, way1, way2);
        
                //Выбор пути
                if (way.equals("first")) workWay = new ArrayList<>(way1);
                else workWay = new ArrayList<>(way2);
        
                WayHandler.RedundantInformationDeleter(workWay);
            
                out.println("<p>" + Recommendations
                    .FD1Recommendation(workWay)
                    + "</p>");
                out.println("<p>" + Recommendations
                    .FD2Recommendation(workWay) 
                    + "</p>");
                out.println("<p>" + Recommendations
                    .FD3Recommendation(workWay) 
                    + "</p>");
                out.println("<p>" + Recommendations
                    .FD4Recommendation(workWay) 
                    + "</p>");
                out.println("<p>" + Recommendations
                    .TrainLightRecommendation(workWay) 
                    + "</p>");
                out.println("<p>" + Recommendations
                    .RelayNPRecommendation(workWay) 
                    + "</p>");
                //out.println("<p>" + Recommendations
                //    .RelayOAZRecommendation(workWay) 
                //    + "</p>");
                out.println("<p>" + Recommendations
                    .RelayOCRecommendation(workWay) 
                    + "</p>");
                out.close();
            }
        %>
    </body>
</html>