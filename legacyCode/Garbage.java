package pl.afera.aferaapp.legacyCode;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.afera.aferaapp.Party;
import pl.afera.aferaapp.Politician;
import pl.afera.aferaapp.Scandal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Garbage {

/*    @GetMapping("/overall")
    public String overall(Model model){
        // 1. Miller i SLD
        Politician miller = new Politician("Leszek", "Miller", BigDecimal.ZERO, BigDecimal.valueOf(70000000.0));
        Party sld = new Party(BigDecimal.ZERO, BigDecimal.valueOf(70000000.0));
        sld.setMembers(new ArrayList<>(List.of(miller)));
        Scandal rywina = new Scandal("Afera Rywina", 2002, 2003, new ArrayList<>(List.of(sld)), BigDecimal.ZERO, BigDecimal.valueOf(70000000.0));
        rywina.getAssociatedPoliticalParties().add(sld);
        // 2. Chlebowski i PO
        Politician chlebowski = new Politician("Zbigniew", "Chlebowski", BigDecimal.ZERO, BigDecimal.valueOf(550000000.0));
        Party po = new Party(BigDecimal.ZERO, BigDecimal.valueOf(550000000.0));
        po.setMembers(new ArrayList<>(List.of(chlebowski)));
        Scandal hazardowa = new Scandal("Afera Hazardowa", 2009, 2009, new ArrayList<>(List.of(po)), BigDecimal.ZERO, BigDecimal.valueOf(550000000.0));
        hazardowa.getAssociatedPoliticalParties().add(po);
        // 3. Romanowski i PiS
        Politician romanowski = new Politician("Marcin", "Romanowski", BigDecimal.valueOf(280000000.0), BigDecimal.ZERO);
        Party pis = new Party(BigDecimal.valueOf(280000000.0), BigDecimal.ZERO);
        pis.setMembers(new ArrayList<>(List.of(romanowski)));
        Scandal funduszSprawiedliwosci = new Scandal("Afera funduszu sprawiedliwosci", 2018, 2024, new ArrayList<>(List.of(pis)), BigDecimal.valueOf(280000000.0), BigDecimal.ZERO);
        funduszSprawiedliwosci.getAssociatedPoliticalParties().add(pis);

        List<Scandal> scandals = List.of(rywina, hazardowa, funduszSprawiedliwosci);
        model.addAttribute("scandals", scandals);
        return "all-scandals";
    }
    @ModelAttribute(name = "scandal")
    public Scandal scandal(){
        return new Scandal();
    }
    @ModelAttribute(name = "party")
    public Party party(){
        return new Party();
    }

            model.addAttribute("activeScandals",
                scandals.stream().filter(s -> s.getEndYear() >= 2026 || s.getEndYear() == 0).toList());

        model.addAttribute("historicalScandals",
                scandals.stream().filter(s -> s.getEndYear() < 2026 && s.getEndYear() != 0).toList());
    @GetMapping("/show")
    public String showReportForm(Model model) {
        List<Scandal> scandals = new ArrayList<>();
        scandalRepository.findAll().forEach(scandals::add);

        model.addAttribute("report", new ScandalReport());
        return "reportForm";
    }
    @PostMapping("/scandal-process")
    public String processScandal(
            @ModelAttribute Scandal scandal, Errors scandalErrors,
            @Valid Party party, Errors partyErrors,
            @Valid Politician politician, Errors politicianErrors) {
        if (scandalErrors.hasErrors() || partyErrors.hasErrors() || politicianErrors.hasErrors()) {
            return "design";
        }
        scandal.getAssociatedPoliticalParties().add(party);
        scandal.getAssociatedPoliticians().add(politician);
//        scandalRepository.save(scandal);
        return "redirect:/all-scandals";
    }
    @PostMapping("/party-process")
    public String processParty(
            @ModelAttribute Party party, Errors partyErrors,
            @Valid Politician politician, Errors politicianErrors
    ){
        if (partyErrors.hasErrors() || politicianErrors.hasErrors()) {
            return "design";
        }
        party.getMembers().add(politician);
//        partyRepository.save(party);
        return "redirect:/all-parties";
    }
    @PostMapping("/report")
    public String processScandalReport(Scandal scandal){
        log.info("New request was received: " + scandal.getName());
        //repo save
        return "redirect:/all-scandals";
    }

     */

//    niebawem bedzie package
}
/*
    private final int Id;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private String name;
    private final int startYear;
    private int endYear;
    private List<Party> associatedPoliticalParties = new ArrayList<>();
    private BigDecimal confirmedEmbezzledAmountOfMoney;
    private BigDecimal unconfirmedEmbezzledAmountOfMoney;
 @Override
    public Scandal findById(String id) { // Zmieniłem String na int, bo w klasie masz int Id
        return jdbc.queryForObject(
                "select * from Scandal where id=?",
                this::mapRowToScandal,
                id
        );
    }
            jdbc.update(
                "insert into Scandal(Id, name, createdAt, updatedAt, startYear, endYear, confirmedEmbezzledAmountOfMoney, unconfirmedEmbezzledAmountOfMoney) values (?, ?, ?, ?, ?, ?,?, ?)",
                scandal.getId(),
                scandal.getName(),
                scandal.getCreatedAt(),
                scandal.getUpdatedAt(),
                scandal.getStartYear(),
                scandal.getEndYear(),
                scandal.getAssociatedPoliticalParties(),
                scandal.getConfirmedEmbezzledAmountOfMoney(),
                scandal.getUnconfirmedEmbezzledAmountOfMoney()
        );
        return scandal;

    */
