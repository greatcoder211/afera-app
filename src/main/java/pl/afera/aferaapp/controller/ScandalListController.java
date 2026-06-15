package pl.afera.aferaapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.afera.aferaapp.Party;
import pl.afera.aferaapp.Politician;
import pl.afera.aferaapp.Scandal;
import pl.afera.aferaapp.repository.ScandalRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/all-scandals")
public class ScandalListController {
    private final ScandalRepository scandalRepository;
    public ScandalListController(ScandalRepository scandalRepository) {
        this.scandalRepository = scandalRepository;
    }
    @GetMapping()
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
}
