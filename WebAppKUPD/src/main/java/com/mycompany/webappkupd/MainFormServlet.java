package com.mycompany.webappkupd;

import KUDP.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "MainFormServlet", urlPatterns = {"/MainFormServlet"})
public class MainFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request
            , HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<Way> way1 = new ArrayList<>();
        ArrayList<Way> way2 = new ArrayList<>();
        ArrayList<Way> workWay;
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        
        //Получаем параметры с главной страницы
        String filePath = request.getParameter("filePath");
        String way = request.getParameter("way");
        String outputSize = request.getParameter("outputSize");
        String filter = request.getParameter("filter");
        String timeFilter = request.getParameter("timeFilter");
        String timeFrom = request.getParameter("timeFrom");
        String timeTo = request.getParameter("timeTo");
        String fileName = request.getParameter("fileName");
          
        //Сохранение параметров в сессию
        HttpSession session = request.getSession();
        session.setAttribute("filePath", filePath);
        session.setAttribute("way", way);
        session.setAttribute("outputSize", outputSize);
        session.setAttribute("filter", filter);
        session.setAttribute("timeFilter", timeFilter);
        session.setAttribute("timeFrom", timeFrom);
        session.setAttribute("timeTo", timeTo);
        
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
        
        if (timeFilter != null && timeFilter.equals("ДА")) 
            workWay = WayHandler
                .TimeFilter(workWay, timeFrom, timeTo);
        
        //Создание нового файла
        if (!fileName.isEmpty() || fileName != null) 
            CSVWriter.Writer(fileName, workWay);
        
        getServletContext().getRequestDispatcher("/report.jsp").forward(request, response);
    }
}
