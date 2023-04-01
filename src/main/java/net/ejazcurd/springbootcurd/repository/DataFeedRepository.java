package net.ejazcurd.springbootcurd.repository;

import net.ejazcurd.springbootcurd.model.DataFeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DataFeedRepository extends JpaRepository<DataFeed,Long> {

    //List<DataFeed> findByDate(Date date);
    //List<DataFeed> findByType(String datafeedtype);
    /*@Query("select * from data_feed_status where data_feed_end_time IN (select max(data_feed_end_time)from data_feed_status where data_feed_type :datafeedtype")
    //Stream<DataFeed> findByTypeReturn(@Param("datafeedtype") String datafeedtype);
    List<DataFeed> findByTypeReturn(@Param("datafeedtype") String datafeedtype);*/

    @Query(value  ="select * from data_feed_status where data_feed_end_time IN (select max(data_feed_end_time)from data_feed_status where data_feed_type='AXIA')",nativeQuery = true)
    DataFeed findByTypeReturn();

    @Query(value  ="select * from data_feed_status where data_feed_end_time IN (select max(data_feed_end_time)from data_feed_status where data_feed_type='NEACRWEST')",nativeQuery = true)
    DataFeed findByTypeNeacrWest();

    @Query(value  ="select * from data_feed_status where data_feed_end_time IN (select max(data_feed_end_time)from data_feed_status where data_feed_type='FIBERBASE')",nativeQuery = true)
    DataFeed findByTypeFiberbase();
}
