package com.example.BloggingPlatformAPI.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Setter
@Getter
@MappedSuperclass
public class BaseModel {
    @JsonIgnore
    @CreatedDate
    Date createdDate;
    @JsonIgnore
    @UpdateTimestamp
    Date lastUpdated;
    @JsonIgnore
    Boolean isActive;
}
