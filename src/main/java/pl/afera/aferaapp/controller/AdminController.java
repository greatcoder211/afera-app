package pl.afera.aferaapp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.afera.aferaapp.Scandal;
import pl.afera.aferaapp.ScandalReport;
import pl.afera.aferaapp.repository.ScandalReportRepository;
import pl.afera.aferaapp.repository.ScandalRepository;

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
        scandalRepository.save(scandal);
        return "redirect:/admin/home";
    }

    @GetMapping("/check")
    public String check(Model model) {
        Iterable<ScandalReport> allReports = scandalReportRepository.findAll();
        model.addAttribute("reports", allReports);
        return "admin-check";
    }
}