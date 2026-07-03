package pl.afera.aferaapp.controller;

import org.hibernate.engine.spi.ManagedEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.afera.aferaapp.model.*;
import pl.afera.aferaapp.repository.ScandalReportRepository;
import pl.afera.aferaapp.repository.ScandalRepository;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    private final ScandalReportRepository scandalReportRepository;
    private final ScandalRepository scandalRepository;

    public AdminController(ScandalReportRepository scandalReportRepository, ScandalRepository scandalRepository) {
        this.scandalReportRepository = scandalReportRepository;
        this.scandalRepository = scandalRepository;
    }

    @GetMapping()
    public String adminHome() {
        return "admin-home";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("scandal", new Scandal());
        return "admin-add";
    }

    @PostMapping("/add")
    public String processAdd(Scandal scandal) {
        Set<Party> associatedParties = new HashSet<>();
        for(Politician politician: scandal.getAssociatedPoliticians()){
            politician.getMemberships().stream()
                    .filter(m -> m.getEntryDate().getYear() <= scandal.getEndYear() && m.getDepartureDate().getYear() >= scandal.getStartYear())
        }
        scandalRepository.save(scandal);
        return "redirect:/admin";
    }

    @GetMapping("/check")
    public String check(Model model) {
        Iterable<ScandalReport> allReports = scandalReportRepository.findAll();
        model.addAttribute("reports", allReports);
        return "admin-check";
    }
}