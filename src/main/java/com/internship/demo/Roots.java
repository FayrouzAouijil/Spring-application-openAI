package com.internship.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.internship.Controllers.OpenAiController;
import com.internship.Controllers.CsvController;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class Roots{

    @GetMapping("/")
    public String index(Model model){
        return "index";
    }

    @PostMapping("/")
    public String hello(Model model,HttpServletRequest request){
        String question = request.getParameter("question");
        OpenAiController op = new OpenAiController();
        Map<String, Object> mapThis = new HashMap();
        mapThis.put("model", "text-davinci-003");
        mapThis.put("prompt", question);
        mapThis.put("max_tokens", 4000);
        mapThis.put("temperature", 1.0);

        // op.generateCompletion(mapThis);
        String answer = op.generateCompletion(mapThis);
        model.addAttribute("question", question);
        model.addAttribute("answer", answer);

        CsvController.appendDataToCSV(question.replace("\n",""),answer.replace("\n","") );

        return "index";
    }
}