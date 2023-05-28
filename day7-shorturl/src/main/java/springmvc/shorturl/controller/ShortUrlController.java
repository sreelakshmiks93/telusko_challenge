package springmvc.shorturl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springmvc.shorturl.service.ShortUrlService;

/**
 * @author Sreelakshmi
 */
@Controller
public class ShortUrlController {

	@Autowired
	ShortUrlService shortUrlService;
	
	@RequestMapping(value={"/shorturl","/"})
	public String handler(Model model) {
		return "shorturl";
	}
	
	@PostMapping("/shorturl")
	public String handler(@ModelAttribute("url") String url, Model model) {
		String shortUrl = shortUrlService.getShortUrl(url);
		model.addAttribute("shorturl",shortUrl);
		model.addAttribute("url",url);
		return "shorturl";
	}
	
	
}