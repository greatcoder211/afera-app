package pl.afera.aferaapp.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebController implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //jest to odpowiednik controllera home- taki controller statyczny, uzywany dla widokow statycznych(np. o nas)
        //nie ma dostepu do modelu- w takich sytuacjach jest kategorycznie zabroniony
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login");
    }
}
