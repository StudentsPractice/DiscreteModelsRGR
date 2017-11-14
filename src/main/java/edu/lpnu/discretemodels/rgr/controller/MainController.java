package edu.lpnu.discretemodels.rgr.controller;

import java.io.IOException;

import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;

import edu.lpnu.discretemodels.rgr.service.MainService;

@Controller
public class MainController {

	@Autowired
	private MainService service;
	
	@GetMapping(value = "/")
    public String labOnePage(Model model) {
        return "main";
    }

    @PostMapping("/")
    public String submitData(@RequestPart("inputFile") Part inputDataFile, Model model) {
    	try {
    		service.makeCalculation(inputDataFile);
    		model.addAttribute("edgesFlow", service.getEdgesFlow());
    		model.addAttribute("maxFlow", service.getMaxFlowValue());
    		model.addAttribute("json", service.getJsonForInputMatrix());
		} catch (IOException e) {
			model.addAttribute("error", "Помилка при роботі з файлом!");
		}
        return "results";
    }

	
}
