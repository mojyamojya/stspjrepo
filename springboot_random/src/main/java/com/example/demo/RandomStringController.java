package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RandomStringController {

	@Autowired
//	RandomStringGenerator gen;
	
	@RequestMapping("/")
	public String index() {
		return "random";
	}
	
	@RequestMapping(value="/generate", method=RequestMethod.POST)
	public ModelAndView generate(
			@RequestParam("charLength") int charLength,
			@RequestParam(name="withNumber", defaultValue="") String withNumber,
			ModelAndView mv) {
		boolean withNumberFlg = "1".equals(withNumber);
		List<String> randomStringList = RandomStringGenerator.stGenerate(charLength, withNumberFlg);
//		List<String> randomStringList = gen.generate(charLength, withNumberFlg);
		mv.addObject("randomList", randomStringList);
		
		mv.setViewName("random");
		return mv;
	}
}
