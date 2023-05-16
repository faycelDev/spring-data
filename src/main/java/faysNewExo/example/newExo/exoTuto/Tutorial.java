package faysNewExo.example.newExo.exoTuto;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Tutorial {

    String description;
    int publication;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "tutorial_id")
    private Long id;

            @OneToMany
            (mappedBy = "tutorial")
            List<Comments> comments;



    public Tutorial() {

    }

    public Tutorial(String description, int publication, Long id) {
        this.description = description;
        this.publication = publication;
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPublication() {
        return publication;
    }

    public void setPublication(int publication) {
        this.publication = publication;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }
}
