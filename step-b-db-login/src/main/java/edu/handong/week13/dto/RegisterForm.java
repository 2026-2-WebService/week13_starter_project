package edu.handong.week13.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public class RegisterForm {
    @NotBlank @Size(min=3,max=30)
    private String username;
    @NotBlank @Size(min=6,max=72)
    private String password;
    public String getUsername(){return username;}
    public void setUsername(String x){username=x;}
    public String getPassword(){return password;}
    public void setPassword(String x){password=x;}
}
