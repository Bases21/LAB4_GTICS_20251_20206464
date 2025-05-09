package Controller;

import Entity.Tower;
import Entity.TowerState;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import Repository.TowerRepository;
import Repository.TowerStateRepository;

@Controller
@RequestMapping("/torres")
public class TowerController {

    @Autowired
    private TowerRepository towerRepository;

    @Autowired
    private TowerStateRepository towerStateRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaTorres", towerRepository.findAll());
        return "tower/lista";
    }

    @GetMapping("/nueva")
    public String nuevaTorre(Model model) {
        model.addAttribute("tower", new Tower());
        model.addAttribute("estados", towerStateRepository.findAll());
        return "tower/formulario";
    }

    @PostMapping("/guardar")
    public String guardarTorre(@Valid @ModelAttribute("tower") Tower tower, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("estados", towerStateRepository.findAll());
            return "tower/formulario";
        }
        towerRepository.save(tower);
        return "redirect:/torres";
    }

    @GetMapping("/editar/{id}")
    public String editarTorre(@PathVariable("id") Integer id, Model model) {
        Tower tower = towerRepository.findById(id).orElse(null);
        model.addAttribute("tower", tower);
        model.addAttribute("estados", towerStateRepository.findAll());
        return "tower/formulario";
    }

    @GetMapping("/borrar/{id}")
    public String borrarTorre(@PathVariable("id") Integer id) {
        towerRepository.deleteById(id);
        return "redirect:/torres";
    }
}
