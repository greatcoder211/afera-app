package pl.afera.aferaapp.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.afera.aferaapp.Party;
import pl.afera.aferaapp.Scandal;
import pl.afera.aferaapp.ScandalReport;
import pl.afera.aferaapp.repository.PartyRepository;
import pl.afera.aferaapp.repository.ScandalReportRepository;
import pl.afera.aferaapp.repository.ScandalRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/report")
public class ScandalReportController {
    private final ScandalReportRepository scandalReportRepository;
    public ScandalReportController(ScandalReportRepository scandalReportRepository) {
        this.scandalReportRepository = scandalReportRepository;
    }
/*    @GetMapping("/request")
    public String requestScandalReport(Model model){
        model.addAttribute("report", new ScandalReport());
        return "reportForm";
    }*/
    @GetMapping("/show")
    public String showReportForm(Model model) {
        model.addAttribute("report", new ScandalReport());
        return "reportForm";
    }
    @PostMapping("/request")
    public String requestScandalReport(@Valid @ModelAttribute("report") ScandalReport report, Errors errors) {
        if(errors.hasErrors()){
            return "reportForm";
        }
        log.info("Request has been submitted: " + report);
        scandalReportRepository.save(report);
        return "redirect:/all-scandals";
    }
}
