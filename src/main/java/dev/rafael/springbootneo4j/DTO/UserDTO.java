package dev.rafael.springbootneo4j.DTO;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class UserDTO {
    private String name;
    private String username;
    private String roles;

    public UserDTO( String name, String username, String roles ) {
        this.name = name;
        this.username = username;
        this.roles = roles;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public void setUsername( String username ) {
        this.username = username;
    }

    public void setRoles( String roles ) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getRoles() {
        return roles;
    }
}
