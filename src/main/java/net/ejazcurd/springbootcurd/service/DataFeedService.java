package net.ejazcurd.springbootcurd.service;

import net.ejazcurd.springbootcurd.model.DataFeed;
import net.ejazcurd.springbootcurd.model.Kpireport;

import java.util.List;

public interface DataFeedService {

    DataFeed saveEmp(DataFeed dataFeed);

  //  List<DataFeed> findBtType();

    DataFeed findByType();
    Kpireport findreport();
    Kpireport getNeacrWest();
    Kpireport getFiberbase();
    List<DataFeed> listAll();
}
