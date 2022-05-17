package prj.news.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String label;

    @OneToMany(fetch = FetchType.LAZY , cascade=CascadeType.ALL ,mappedBy = "categories")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<News> news;

    public Categories() {

    }





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Categories(Long id, String label) {
        this.id = id;
        this.label = label;
    }

}
