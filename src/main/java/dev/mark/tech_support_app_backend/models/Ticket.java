package dev.mark.tech_support_app_backend.models;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tickets")
public class Ticket {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_ticket")
    private Long id;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private Date created_date;

    @Column(name = "modified_date")
    @LastModifiedDate
    private Date modified_date;

    @Column
    private String problem_type;

    @Column
    private String description;

    @Column
    private String status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = true)
    @JsonBackReference
    private User user;

    @Transient
    private Long userId;

    public Ticket() {
    }

    public Ticket(String problem_type, String description, String status, User user, Long userId) {
        this.problem_type = problem_type;
        this.description = description;
        this.status = status;
        this.user = user;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProblem_type() {
        return problem_type;
    }

    public void setProblem_type(String problem_type) {
        this.problem_type = problem_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getModified_date() {
        return modified_date;
    }

    public void setModified_date(Date modified_date) {
        this.modified_date = modified_date;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
