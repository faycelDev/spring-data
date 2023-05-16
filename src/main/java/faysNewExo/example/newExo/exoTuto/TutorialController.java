package faysNewExo.example.newExo.exoTuto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TutorialController {

    @Autowired

    private TutorialRepository tutorialRepository;

    @GetMapping(value = "/tuto")
    public List<Tutorial> getAllFind(){

        return tutorialRepository.findAll();
    }

    @GetMapping(value = "/tuto/{id}")
    public Optional<Tutorial> getById(@PathVariable ("id") Long id)
    {
        return tutorialRepository.findById(id);
    }

    @DeleteMapping(value = "/tuto/{id}")
    public void delteById(@PathVariable ("id") Long id)
    {
        tutorialRepository.deleteById(id);
    }

    @PostMapping(value = "tuto")
    public void create(@RequestBody Tutorial tutorial)
    {

        tutorialRepository.save(tutorial);
    }

    @PutMapping(value = "/tuto/{id}")
    public void update(@PathVariable ("id") Long id, @RequestBody Tutorial tutorial2)
    {
        var tuto = tutorialRepository.findById(id);
        if(tuto.isPresent()){
            tutorial2.getId();
            tutorial2.setId(id);
            tutorialRepository.save(tutorial2);
        }
    }

}
