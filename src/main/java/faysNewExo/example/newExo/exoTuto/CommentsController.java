package faysNewExo.example.newExo.exoTuto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentsController {

    @Autowired

    private CommentsRepository commentsRepository;
    @Autowired
    private TutorialRepository tutorialRepository;

    @GetMapping(value = "/com")
    public List<Comments> getFindAll() {

        return commentsRepository.findAll();
    }

    @GetMapping(value = "/com/{id}")
    public Optional<Comments> getFindById(@PathVariable("id") Long id) {
        return commentsRepository.findById(id);
    }

    @DeleteMapping("/com/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        commentsRepository.deleteById(id);
    }

    @PutMapping(value = "/com{id}")
    public void update(@PathVariable("id") Long id, @RequestBody Comments comments) {
        var comm = commentsRepository.findById(id);
        if (comm.isPresent()) {
            comments.getId();
            comments.setId(id);
            commentsRepository.save(comments);

        }
    }

    @PostMapping(value = "/com/{id}")
    public void create(@PathVariable("id") Long id, @RequestBody Comments comments2)
    {
            var tuto = tutorialRepository.findById(id);
            if(tuto.isPresent())
            {
                comments2.setTutorial(tuto.get());
                commentsRepository.save(comments2);
            }


        }
    }

