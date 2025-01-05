package com.smart.tolls.ucb.edu.bo.SmartTolls_PersonsService.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;

@Slf4j
@Embeddable
@Getter
@Setter
public class Audit<T> {

    @Column(name = "create_by")
    private String createBy;

    @NotBlank
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "delete_by")
    private String deleteBy;

    @Column(name = "delete_date")
    private LocalDateTime deleteDate;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "action")
    private String action;

    @Column(name = "previous_value")
    private String previousValue;

    @Column(name = "current_value")
    private String currentValue;

    @Column(name = "record_version")
    private Integer recordVersion;

    @PrePersist
    public void prePersist() {
        this.createDate = LocalDateTime.now();
        this.recordVersion = 1;
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attr != null) {
            HttpServletRequest request = attr.getRequest();
            this.setAction(request.getMethod());
            this.setIpAddress(request.getRemoteAddr());
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.updateDate = LocalDateTime.now();
        this.recordVersion = this.getRecordVersion() + 1;
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attr != null) {
            HttpServletRequest request = attr.getRequest();
            this.setAction(request.getMethod());
            this.setIpAddress(request.getRemoteAddr());
        }
    }
}
