package net.ejazcurd.springbootcurd.controller;

import net.ejazcurd.springbootcurd.model.DataFeed;
import net.ejazcurd.springbootcurd.model.Kpireport;
import net.ejazcurd.springbootcurd.service.DataFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin()
public class DataFeedcontroller {

    @Autowired
    private DataFeedService dataFeedService;
    @PostMapping("/datafeed/save")
    public ResponseEntity<DataFeed> create(@Valid @RequestBody DataFeed dataFeed )
    {
        DataFeed dataFeedsave  = dataFeedService.saveEmp(dataFeed);
        return new ResponseEntity<DataFeed>(dataFeedsave , new HttpHeaders(), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public DataFeed getallemployee()
    {
       return dataFeedService.findByType();
       // return new ResponseEntity<DataFeed>(employee,HttpStatus.OK);
    }

    @GetMapping("/kpireport/axia")
    public Kpireport getKpi()
    {
        return dataFeedService.findreport();
        // return new ResponseEntity<DataFeed>(employee,HttpStatus.OK);
    }
    @GetMapping("/kpireport/neacr")
    public Kpireport getKpi_neacr()
    {
        return dataFeedService.getNeacrWest();
        // return new ResponseEntity<DataFeed>(employee,HttpStatus.OK);
    }
    @GetMapping("/kpireport/fiberbase")
    public Kpireport getKpi_fiberbase()
    {
        return dataFeedService.getFiberbase();
        // return new ResponseEntity<DataFeed>(employee,HttpStatus.OK);
    }

    @GetMapping("/kpireport/all")
    public List<DataFeed> getAll()
    {
        return dataFeedService.listAll();
        // return new ResponseEntity<DataFeed>(employee,HttpStatus.OK);
    }

    @GetMapping("/kpireport/getAllKpi")
    public List<Kpireport> getAllKpi()
    {
        List<Kpireport> list = new ArrayList<>();
        Kpireport fiberbase = dataFeedService.getFiberbase();
       Kpireport neacrWest = dataFeedService.getNeacrWest();
        Kpireport find = dataFeedService.findreport();
        list.add(fiberbase);
        list.add(neacrWest);
        list.add(find);
        
        return list;
        // return new ResponseEntity<DataFeed>(employee,HttpStatus.OK);
    }
}
