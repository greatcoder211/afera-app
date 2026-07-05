package pl.afera.aferaapp.repository.criteriaTraining;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.afera.aferaapp.repository.ScandalRepository;

@Controller
@RequestMapping("/analysis")
@RequiredArgsConstructor
public class AnalysisController {

    private final ScandalRepository scandalRepository;

    @GetMapping("/advanced-search")
    public String advancedSearch(@RequestParam(required = false) String keyword,
                                 @RequestParam(required = false) String partyName,
                                 Model model) {
        model.addAttribute("keyword", keyword);
        model.addAttribute("partyName", partyName);

        if (keyword != null || partyName != null) {
            model.addAttribute("scandals", scandalRepository.findAll(
                    AdvancedScandalSpecifications.descriptionOrParty(keyword, partyName)
            ));
        }
        return "advanced-search";
    }

    // Do ćwiczenia 2 (Group By DTO)
    @GetMapping("/party-summary")
    public String partySummary(Model model) {
        model.addAttribute("summaries", scandalRepository.getPartyScandalCount());
        return "party-summary";
    }

    // Do ćwiczenia 3 (Subquery)
    @GetMapping("/above-average")
    public String aboveAverage(Model model) {
        model.addAttribute("scandals", scandalRepository.findAll(
                ScandalSubquerySpecifications.aboveAverageConfirmedAmount()
        ));
        return "above-average";
    }
}