package com.barney.wonderlabzdeveloperassessmentcore.common;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 21/4/2021
 * Time        : 21:49
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
@ToString
public class AuditedEntity  implements Serializable {

    @Column(name = "created", updatable = false)
    @CreationTimestamp
    protected LocalDateTime created;

    @Column(name = "last_modified")
    @UpdateTimestamp
    protected LocalDateTime lastModified;

    @Column(name = "created_by")
    @CreatedBy
    protected String createdBy;


    @Column(name = "last_modified_by")
    @LastModifiedBy
    protected String modifiedBy;
}
