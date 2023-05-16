package faysNewExo.example.newExo.exoTuto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Comments {
    @Column (name = "comment_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String comment_text;

    @JsonIgnore

    @ManyToOne
    @JoinColumn(name = "tutorial_id")
    private Tutorial tutorial;



    public Comments(){

    }

    public Comments(String comment_text,Long id) {
        this.comment_text = comment_text;
        this.id = id;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tutorial getTutorial() {
        return tutorial;
    }

    public void setTutorial(Tutorial tutorial) {
        this.tutorial = tutorial;
    }
}
