package com.SpringEx.Security.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="usertab")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private Integer userId;
    @Column(name = "uname")
    private String userName;
    @Column(name = "umail")
    private String userEmail;
    @Column(name = "upwd")
    private String userPwd;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "roles_tab", joinColumns = @JoinColumn(name = "uid"))
    @Column(name = "urole")
    private List<String> userRoles;

}
