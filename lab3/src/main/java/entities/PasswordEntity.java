package entities;

import javax.persistence.*;

@Entity
@Table(name = "users_passwords", schema = "public", catalog = "postgres")
public class PasswordEntity {

    private Integer userId;
    private String username;
    private String password;

    public PasswordEntity(String username, String password) {
        this.username = username;
        this.password = password;
        this.userId = this.hashCode();
    }

    public PasswordEntity() {
    }

    @Id
    @Column(name = "user_id", nullable = false)
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 50)
    public String getUsername() { return username; }
    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PasswordEntity that = (PasswordEntity) o;

        if (userId != that.userId) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
