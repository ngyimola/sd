package entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Path {
    private int id;
    private Timestamp timestamp;
    private String city;
    private Package packageByPackageId;

    public Path() {
    }

    public Path(Timestamp timestamp, String city, Package packageByPackageId) {
        this.timestamp = timestamp;
        this.city = city;
        this.packageByPackageId = packageByPackageId;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "timestamp", nullable = true)
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Path path = (Path) o;
        return id == path.id &&
                Objects.equals(timestamp, path.timestamp) &&
                Objects.equals(city, path.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestamp, city);
    }

    @ManyToOne
    @JoinColumn(name = "package_id", referencedColumnName = "id", nullable = false)
    public Package getPackageByPackageId() {
        return packageByPackageId;
    }

    public void setPackageByPackageId(Package packageByPackageId) {
        this.packageByPackageId = packageByPackageId;
    }
}
