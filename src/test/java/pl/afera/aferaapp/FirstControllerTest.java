package pl.afera.aferaapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import pl.afera.aferaapp.controller.ScandalListController;
import pl.afera.aferaapp.controller.ScandalReportController;
import pl.afera.aferaapp.controller.WebConfig;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest({WebConfig.class, ScandalListController.class, ScandalReportController.class})
public class FirstControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testFirstPage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("first"))
                .andExpect(content().string(containsString("Witaj w..." )));
    }
    @Test
    public void testFirstScandalsView() throws Exception {
        mockMvc.perform(get("/all-scandals/overall"))
                .andExpect(status().isOk())
                .andExpect(view().name("all-scandals"))
                .andExpect(model().attributeExists("scandals"))
                .andExpect(content().string(containsString("Afera Rywina")))
                .andExpect(content().string(containsString("Leszek Miller")))
                .andExpect(content().string(containsString("Afera Hazardowa")))
                .andExpect(content().string(containsString("70 000 000")));
    }
}
