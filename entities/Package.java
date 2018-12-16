package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Package {
    private int id;
    private String name;
    private String description;
    private String senderCity;
    private String destinationCity;
    private Byte tracking;
    private User userBySender;
    private User userByReceiver;

    public Package() {
    }

    public Package(String name, String description, String senderCity, String destinationCity, Byte tracking, User userBySender, User userByReceiver) {
        this.name = name;
        this.description = description;
        this.senderCity = senderCity;
        this.destinationCity = destinationCity;
        this.tracking = tracking;
        this.userBySender = userBySender;
        this.userByReceiver = userByReceiver;
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
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 45)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "sender_city", nullable = true, length = 45)
    public String getSenderCity() {
        return senderCity;
    }

    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }

    @Basic
    @Column(name = "destination_city", nullable = true, length = 45)
    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    @Basic
    @Column(name = "tracking", nullable = true)
    public Byte getTracking() {
        return tracking;
    }

    public void setTracking(Byte tracking) {
        this.tracking = tracking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        return id == aPackage.id &&
                Objects.equals(name, aPackage.name) &&
                Objects.equals(description, aPackage.description) &&
                Objects.equals(senderCity, aPackage.senderCity) &&
                Objects.equals(destinationCity, aPackage.destinationCity) &&
                Objects.equals(tracking, aPackage.tracking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, senderCity, destinationCity, tracking);
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sender", referencedColumnName = "id", nullable = false)
    public User getUserBySender() {
        return userBySender;
    }

    public void setUserBySender(User userBySender) {
        this.userBySender = userBySender;
    }

    @ManyToOne
    @JoinColumn(name = "receiver", referencedColumnName = "id", nullable = false)
    public User getUserByReceiver() {
        return userByReceiver;
    }

    public void setUserByReceiver(User userByReceiver) {
        this.userByReceiver = userByReceiver;
    }
}
