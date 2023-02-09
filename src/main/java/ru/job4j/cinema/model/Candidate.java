//package ru.job4j.dreamjob.model;
//
//import java.io.Serializable;
//import java.time.LocalDateTime;
//import java.util.Map;
//import java.util.Objects;
//
//public class Candidate implements Serializable {
//
//    public static final Map<String, String> COLUMN_MAPPING = Map.of(
//            "id", "id",
//            "name", "name",
//            "description", "description",
//            "creation_date", "creationDate",
//            "visible", "visible",
//            "city_id", "cityId",
//            "file_id", "fileId"
//    );
//    private int id;
//    private String name;
//    private String description;
//    private LocalDateTime creationDate = LocalDateTime.now();
//    private boolean visible;
//    private int cityId;
//    private int fileId;
//
//    public Candidate() {
//    }
//
//    public Candidate(int id, String name, String description, LocalDateTime creationDate, boolean visible, int cityId, int fileId) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.creationDate = creationDate;
//        this.visible = visible;
//        this.cityId = cityId;
//        this.fileId = fileId;
//    }
//
//    public int getFileId() {
//        return fileId;
//    }
//
//    public void setFileId(int fileId) {
//        this.fileId = fileId;
//    }
//
//    public int getCityId() {
//        return cityId;
//    }
//
//    public void setCityId(int cityId) {
//        this.cityId = cityId;
//    }
//
//    public boolean getVisible() {
//        return visible;
//    }
//
//    public void setVisible(boolean visible) {
//        this.visible = visible;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public LocalDateTime getCreationDate() {
//        return creationDate;
//    }
//
//    public void setCreationDate(LocalDateTime creationDate) {
//        this.creationDate = creationDate;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (!(o instanceof Candidate)) {
//            return false;
//        }
//        Candidate candidate = (Candidate) o;
//        return getId() == candidate.getId();
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId());
//    }
//
//    @Override
//    public String toString() {
//        return "Candidate{"
//                + "id=" + id
//                + ", name='" + name + '\''
//                + ", description='" + description + '\''
//                + ", created=" + creationDate
//                + '}';
//    }
//}
//
//
//
///*package ru.job4j.dreamjob.model;
//
//import java.io.Serializable;
//import java.time.LocalDateTime;
//import java.util.Arrays;
//import java.util.Objects;
//
//public class Candidate implements Serializable {
//    private int id;
//    private String name;
//    private String description;
//    private LocalDateTime created;
//    private boolean visible;
//    private City city;
//    private byte[] photo;
//
//    private Candidate() {
//    }
//
//    public Candidate(int id, String name, String description, LocalDateTime created, boolean visible, City city, byte[] photo) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.created = created;
//        this.visible = visible;
//        this.city = city;
//        this.photo = photo;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public LocalDateTime getCreated() {
//        return created;
//    }
//
//    public void setCreated(LocalDateTime created) {
//        this.created = created;
//    }
//
//    public boolean isVisible() {
//        return visible;
//    }
//
//    public void setVisible(boolean visible) {
//        this.visible = visible;
//    }
//
//    public City getCity() {
//        return city;
//    }
//
//    public void setCity(City city) {
//        this.city = city;
//    }
//
//    public byte[] getPhoto() {
//        return photo;
//    }
//
//    public void setPhoto(byte[] photo) {
//        this.photo = photo;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (!(o instanceof Candidate)) {
//            return false;
//        }
//        Candidate candidate = (Candidate) o;
//        return getId() == candidate.getId();
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId());
//    }
//
//    @Override
//    public String toString() {
//        return "Candidate{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                ", created=" + created +
//                ", visible=" + visible +
//                ", city=" + city +
//                ", photo=" + Arrays.toString(photo) +
//                '}';
//    }
//}
//
// */
