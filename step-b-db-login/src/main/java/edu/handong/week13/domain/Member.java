package edu.handong.week13.domain;
import jakarta.persistence.*;
@Entity
@Table(name="members")
public class Member {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false,unique=true,length=60)
    private String username;
    @Column(nullable=false,length=255)
    private String password;
    @Enumerated(EnumType.STRING) @Column(nullable=false,length=20)
    private Role role = Role.USER;
    public Long getId(){return id;}
    public String getUsername(){return username;}
    public void setUsername(String x){username=x;}
    public String getPassword(){return password;}
    public void setPassword(String x){password=x;}
    public Role getRole(){return role;}
    public void setRole(Role x){role=x;}
}
