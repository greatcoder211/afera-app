package pl.afera.aferaapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.afera.aferaapp.model.entity.Scandal;
import pl.afera.aferaapp.repository.ScandalRepository;

@Slf4j
@Controller
@RequestMapping("/scandals")
public class ScandalListController {
    private final ScandalRepository scandalRepository;
    public ScandalListController(ScandalRepository scandalRepository) {
        this.scandalRepository = scandalRepository;
    }
    @GetMapping("/all")
    public String overall(Model model){
        Iterable<Scandal> scandals = scandalRepository.findAll();
        model.addAttribute("scandals", scandals);
        return "all-scandals";
    }
    @GetMapping("/{id}")
    public String specificScandals(@PathVariable("id") Long id,Model model){
        Scandal scandal = scandalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Takiej afery nie mamy jeszcze w naszej bazie!"));
        model.addAttribute("scandal", scandal);
        return "specific-scandal";
    }
    @GetMapping("/full-report/{id}")
    public String scandalWithThieves(@PathVariable("id") Long id, Model model){
        Scandal scandal = scandalRepository.scandalWithPoliticians(id).orElseThrow();
        model.addAttribute("scandal", scandal);
        return "full-report";
    }
}
