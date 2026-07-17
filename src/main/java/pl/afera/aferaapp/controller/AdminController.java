package pl.afera.aferaapp.controller;

import jakarta.validation.Valid;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.afera.aferaapp.model.entity.Party;
import pl.afera.aferaapp.model.entity.Politician;
import pl.afera.aferaapp.model.entity.Scandal;
import pl.afera.aferaapp.model.entity.ScandalReport;
import pl.afera.aferaapp.repository.criteriaTraining.SearchKeyParameters;
import pl.afera.aferaapp.repository.PartyRepository;
import pl.afera.aferaapp.repository.PoliticianRepository;
import pl.afera.aferaapp.repository.ScandalReportRepository;
import pl.afera.aferaapp.repository.ScandalRepository;
import pl.afera.aferaapp.service.ScandalService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    private final ScandalReportRepository scandalReportRepository;
    private final ScandalRepository scandalRepository;
    private final PartyRepository partyRepository;
    private final PoliticianRepository politicianRepository;
    private final ScandalService scandalService;

    public AdminController(ScandalReportRepository scandalReportRepository, ScandalRepository scandalRepository, PartyRepository partyRepository, PoliticianRepository politicianRepository, ScandalService scandalService) {
        this.scandalReportRepository = scandalReportRepository;
        this.scandalRepository = scandalRepository;
        this.partyRepository = partyRepository;
        this.politicianRepository = politicianRepository;
        this.scandalService = scandalService;
    }

    @GetMapping()
    public String adminHome() {
        //hier noch "szukaj afer"
        return "admin-home";
    }

    @GetMapping("/search")
    public String scandalSearch(@Valid @ModelAttribute("parameters") SearchKeyParameters parameters, Model model){
        Specification<Scandal> specification = Specification.where(
                ScandalService.beginAt(parameters.getStartYear())
                        .and(ScandalService.hasPoliticianLastName(parameters.getPoliticianLastName()))
                        .and(ScandalService.containsNameSnippet(parameters.getScandalNameSnippet())));
        List<Scandal> scandals = scandalRepository.findAll(specification);
        model.addAttribute("scandals", scandals);
        return "scandal-search";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("scandal", new Scandal());
        model.addAttribute("allPoliticians", politicianRepository.findAll());
        return "admin-add";
    }

    @PostMapping("/add")
    public String processAdd(Scandal scandal) {
//TODO: wynieść do serwisu
        Set<Party> associatedParties = new HashSet<>();
        for(Politician politician: scandal.getAssociatedPoliticians()){
            //moze byc w kilku partiach i wszystkie moga byc zamieszane w daną afere
            politician.getMemberships().stream()
                    .filter(m -> (m.getEntryDate().compareTo(scandal.getEndDate()) <= 0) && (m.getDepartureDate().compareTo(scandal.getStartDate()) >= 0))
                    .forEach(m -> associatedParties.add((m.getParty())));
        }
        scandal.setAssociatedPoliticalParties(associatedParties);
        scandalRepository.save(scandal);
        return "redirect:/admin";
    }

    @GetMapping("/check")
    public String check(Model model) {
        Iterable<ScandalReport> allReports = scandalReportRepository.findAll();
        model.addAttribute("reports", allReports);
        return "admin-check";
    }

    @GetMapping("/close/{id}")
    public String closeScandal(@PathVariable Long id, Model model){
        Scandal scandal = scandalRepository.findById(id).orElseThrow();
        scandalService.close(id);
        model.addAttribute("scandal", scandal);
        return "close-scandal";
    }
}