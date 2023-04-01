package net.ejazcurd.springbootcurd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
//@Table(name = "employees")
@Table(name ="DATA_FEED_STATUS")
@NoArgsConstructor
@AllArgsConstructor
public class DataFeed {
    @Id
    @Column(name = "DATA_FEED_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "DATA_FEED_TYPE")
    private String datafeedtype;
    @Column(name = "DATA_FEED_STATUS")
    private String datafeedstatus;
    //@Temporal(TemporalType.TIMESTAMP)

    @CreationTimestamp
    @Column(name = "DATA_FEED_START_TIME",nullable = false,updatable = false)
    private Date datafeedstarttime;

    /*@PrePersist
    private void onCreate()
    {
        datafeedstarttime = new Date();
    }*/
    @UpdateTimestamp
    @Column(name = "DATA_FEED_END_TIME")
    private Date datafeedendtime;
    @Column(name = "DATA_FEED_REMARKS")
    private String datafeedremarks;

}
