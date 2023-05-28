package springmvc.shorturl.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

/**
 * @author Sreelakshmi
 */
@Service
public class ShortUrlService {
	
	Map<String, String> map = new HashMap<>();

	public String getShortUrl(String url) {
		String s = generateShortUrl(url);
		if(s != null)
		return "telusko://"+s;
		else
			return "Kindly type a Url before clicking Submit";
	}
	
	private String generateShortUrl(String url) {
		int urlLength = 6;
		if(url != null && !"".equals(url)){
		  if(map.containsKey(url)) {
			 return map.get(url);
		  }else {
			  String charactersToBeUsed = url.replaceAll("[^a-zA-Z0-9 ]", "");  
			  StringBuilder shortUrl = new StringBuilder();
			  
			  for(int i=0; i < urlLength; i++) {
				  Random random = new Random();
				  int j = random.nextInt(charactersToBeUsed.length() - 1);
				  char s = charactersToBeUsed.charAt(j);
				  shortUrl.append(s);
			  }
			  map.put(url, shortUrl.toString());
			  return shortUrl.toString();
			  
		  }
		}
		return null;
		
	}
}
