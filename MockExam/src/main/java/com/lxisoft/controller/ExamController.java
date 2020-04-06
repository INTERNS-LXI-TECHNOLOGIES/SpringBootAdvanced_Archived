package com.lxisoft.controller;
import java.io.IOException;
import java.util.Map;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.lxisoft.model.Exam;
import com.lxisoft.service.ExamService;
 
@Controller

public class ExamController {
	private static final Logger logger = Logger
            .getLogger(ExamController.class);
 
    public ExamController() {
        System.out.println("ExamController()");
    }
    @RequestMapping(value="/")
    public String home(Map<String, Object> model) {
        model.put("message", "HowToDoInJava Reader !!");
        return "index";
    }
 
    @Autowired
    private ExamService examService;
 
    @RequestMapping(value = "/home")
    public ModelAndView listExam(ModelAndView model) throws IOException {
        List<Exam> listExam = examService.getAllExam();
        model.addObject("listExam", listExam);
        model.setViewName("home");
        return model;
    }
 
    @RequestMapping(value = "/newExam", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Exam exam = new Exam();
        model.addObject("exam", exam);
        model.setViewName("ExamForm");
        return model;
    }
 
    @RequestMapping(value = "/saveExam", method = RequestMethod.POST)
    public ModelAndView saveExam(@ModelAttribute Exam exam) {
        if (exam.getId() == 0) { // if exam id is 0 then creating the
            // exam other updating the exam
            examService.addExam(exam);
        } else {
            examService.updateExam(exam);
        }
        return new ModelAndView("redirect:/home");
    }
 
    @RequestMapping(value = "/deleteExam", method = RequestMethod.GET)
    public ModelAndView deleteExam(HttpServletRequest request) {
        int examId = Integer.parseInt(request.getParameter("id"));
        examService.deleteExam(examId);
        return new ModelAndView("redirect:/home");
    }
 
    @RequestMapping(value = "/editExam", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int examId = Integer.parseInt(request.getParameter("id"));
        Exam exam = examService.getExam(examId);
        ModelAndView model = new ModelAndView("ExamForm");
        model.addObject("exam", exam);
 
        return model;
    }
}
