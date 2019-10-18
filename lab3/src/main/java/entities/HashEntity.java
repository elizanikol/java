package entities;

import javax.persistence.*;

@Entity
@Table(name = "users_hashes", schema = "public", catalog = "postgres")
public class HashEntity {

    private Integer userId;
    private String username;
    private String hash;

    public HashEntity(String username, String hash) {
        this.username = username;
        this.hash = hash;
        this.userId = this.hashCode();
    }

    public HashEntity() {
    }

    @Id
    @Column(name = "user_id", nullable = false)
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    @Basic
    @Column(name = "username", nullable = false, length = 50)
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @Basic
    @Column(name = "hash", nullable = false, length = 50)
    public String getHash() { return hash; }
    public void setHash(String password) { this.hash = password; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashEntity that = (HashEntity) o;

        if (userId != that.userId) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (hash != null ? !hash.equals(that.hash) : that.hash != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (hash != null ? hash.hashCode() : 0);
        return result;
    }
}
