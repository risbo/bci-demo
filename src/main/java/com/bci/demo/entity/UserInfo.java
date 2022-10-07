package com.bci.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class UserInfo {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id")
    private String id;
    private String name;
    private String email;
    private String password;
    @Column(name = "last_login")
    private String lastLogin;
    @Column(name = "created")
    @CreationTimestamp
    private Timestamp created;
    @Column(name = "modified")
    @UpdateTimestamp
    private Timestamp modified;
    @Column(name = "is_active")
    private boolean isActive;
    private String token;

    @ElementCollection
    @CollectionTable(name = "user_phone", joinColumns = @JoinColumn(name = "user_info_id"))
    private List<UserPhone> phones;

}
