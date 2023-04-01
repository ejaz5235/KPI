package net.ejazcurd.springbootcurd.service;

import net.ejazcurd.springbootcurd.model.DataFeed;
import net.ejazcurd.springbootcurd.model.Kpireport;
import net.ejazcurd.springbootcurd.repository.DataFeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DataFeedServiceImpl implements DataFeedService{

    static int axia_target_age= 90;
    static int neacr_target_age= 30;
    static int fiberbase_target_age= 90;

    @Autowired
    private DataFeedRepository dataFeedRepository;
    @Override
    public DataFeed saveEmp(DataFeed dataFeed) {

        DataFeed save = dataFeedRepository.save(dataFeed);
        return save;
    }

    @Override
    public DataFeed findByType() {
        long noOfDaysBetween = 0;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        DataFeed axia = dataFeedRepository.findByTypeReturn();
        Date date = axia.getDatafeedendtime();


        Date currentdate = new Date();
        System.out.println("formatter.forma "+formatter.format(date));
        System.out.println("current date "+formatter.format(currentdate));
        System.out.println("last date "+date);
        noOfDaysBetween = ChronoUnit.DAYS.between (date.toInstant(),currentdate.toInstant());
        System.out.println("Number of day "+noOfDaysBetween);

        System.out.println ("Days: " + noOfDaysBetween);
        return axia;
    }

    @Override
    public Kpireport findreport() {
        long noOfDaysBetween = 0;
        DataFeed dataFeed = new DataFeed();
        DataFeed result = dataFeedRepository.findByTypeReturn();
        Date result_date = result.getDatafeedendtime();
        String result_datafeed_name = result.getDatafeedtype();

        int noOfDaysBetween_int = getNoOfDaysBetweenInt(result_date);

        //System.out.print("Current date: "+today);
        Kpireport kpireport = new Kpireport();
        kpireport.setJobName(result_datafeed_name);
        kpireport.setTargetAge(axia_target_age);
        kpireport.setExecuteddate(result_date);
        kpireport.setAge(noOfDaysBetween_int);
        kpireport.setDelta(axia_target_age - noOfDaysBetween_int);

        String color =noOfDaysBetween_int<25?"green" :noOfDaysBetween_int >=25 && noOfDaysBetween_int<=30?"yellow" :"red";
        //System.out.println(color);
        kpireport.setStatus(color);
        //if color == "yellow" send the reminder mail to CGI and BELL
        return kpireport;
    }

    @Override
    public Kpireport getNeacrWest() {
        long noOfDaysBetween = 0;
        DataFeed dataFeed = new DataFeed();
        DataFeed byTypeNeacrWest = dataFeedRepository.findByTypeNeacrWest();
        Date result_date = byTypeNeacrWest.getDatafeedendtime();
        String result_datafeed_name = byTypeNeacrWest.getDatafeedtype();

        int noOfDaysBetween_int = getNoOfDaysBetweenInt(result_date);

        //System.out.print("Current date: "+today);
        Kpireport kpireport = new Kpireport();
        kpireport.setJobName(result_datafeed_name);
        kpireport.setTargetAge(neacr_target_age);
        kpireport.setExecuteddate(result_date);
        kpireport.setAge(noOfDaysBetween_int);
        kpireport.setDelta(neacr_target_age - noOfDaysBetween_int);

        String color =noOfDaysBetween_int<25?"green" :noOfDaysBetween_int >=25 && noOfDaysBetween_int<=30?"yellow" :"red";
        //System.out.println(color);
        kpireport.setStatus(color);
        //if color == "yellow" send the reminder mail to CGI and BELL
        return kpireport;
    }

    @Override
    public Kpireport getFiberbase() {
        long noOfDaysBetween = 0;
        DataFeed dataFeed = new DataFeed();
        DataFeed result = dataFeedRepository.findByTypeFiberbase();
        Date result_date = result.getDatafeedendtime();
        String result_datafeed_name = result.getDatafeedtype();

        int noOfDaysBetween_int = getNoOfDaysBetweenInt(result_date);

        //System.out.print("Current date: "+today);
        Kpireport kpireport = new Kpireport();
        kpireport.setJobName(result_datafeed_name);
        kpireport.setTargetAge(fiberbase_target_age);
        kpireport.setExecuteddate(result_date);
        kpireport.setAge(noOfDaysBetween_int);
        kpireport.setDelta(fiberbase_target_age - noOfDaysBetween_int);

        String color =noOfDaysBetween_int<80?"green" :noOfDaysBetween_int >=80 && noOfDaysBetween_int<=90?"yellow" :"red";
        //System.out.println(color);
        kpireport.setStatus(color);
        //if color == "yellow" send the reminder mail to CGI and BELL
        return kpireport;
    }

    @Override
    public List<DataFeed> listAll() {
        List<DataFeed> list = new ArrayList();
        DataFeed result1 = dataFeedRepository.findByTypeFiberbase();
        DataFeed byTypeNeacrWest = dataFeedRepository.findByTypeNeacrWest();
        DataFeed result = dataFeedRepository.findByTypeReturn();
        list.add(result);
        list.add(byTypeNeacrWest);
        list.add(result1);
        return list;
    }

    private static int getNoOfDaysBetweenInt(Date result_date) {
        long noOfDaysBetween;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date currentdate = new Date();
        noOfDaysBetween = ChronoUnit.DAYS.between (result_date.toInstant(),currentdate.toInstant());
        int noOfDaysBetween_int = (int) noOfDaysBetween;
        return noOfDaysBetween_int;
    }

    private String toDate(long timestamp) {
        LocalDate date = Instant.ofEpochMilli(timestamp * 1000).atZone(ZoneId.systemDefault()).toLocalDate();
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}
