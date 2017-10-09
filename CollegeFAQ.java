import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.HashMap;


public class CollegeFAQ {

	public static void main(String[] args) throws Exception{
		String[] urls = {"https://www.ugrad.vcu.edu/why/faqs/admissions.html#visit",
						"https://admission.virginia.edu/faq",
						"http://www.wm.edu/admission/undergraduateadmission/how-to-apply/transfers/faqs-OLD/index.php",
						};
        
        //https://admissions.vt.edu/about/faqs.html
        
        for(String url : urls) {
	        	Document document = Jsoup.connect(url).get();
	             
	             String webpage = document.toString();
	             
	             String pattern = "<h\\d.*>((\\s+)|)((Who|What|Where|When|Why|Do|Does|If|Is|I|I've|How|Can|Are|Should).+\\?)<\\/h\\d.*>((\\s+)+|)<.>(.+)<.+>";
	             
	             //webpage = webpage.replaceAll("<li>.+<\\/li>", "");
	             webpage = webpage.replaceAll("<a.*>(.+)<\\/a>", "$1");
	             webpage = webpage.replaceAll("<li>", "<p>");
	             webpage = webpage.replaceAll("<\\/li>", "</p>");
	             webpage = webpage.replaceAll("<blockquote>", "");
	             webpage = webpage.replaceAll("<\\/blockquote>", "");
	             webpage = webpage.replaceAll("<ul>", "");
	             webpage = webpage.replaceAll("<\\/ul>", "");
	             webpage = webpage.replaceAll("<br \\/>", "");
	             //webpage = webpage.replaceAll("\t", "");
	             //webpage = webpage.replaceAll("&nbsp;", "$2" + " ");
	             
	             //System.out.println(webpage);
	             
	             Pattern r = Pattern.compile(pattern);
	
	             // Now create matcher object.
	             Matcher m = r.matcher(webpage);
	             
	             // Create HashMap for question and answer values
	             HashMap <String, String> myMap = new HashMap<String, String>();
	             
	             while(m.find()) {
	//             		for (int i = 0; i <= m.groupCount(); i++) {
	//             			System.out.println("Found value: " + m.group(i));
	//             		}
	             		myMap.put(m.group(3), m.group(7));
	             		
	             		//System.out.println(myMap);
	             		System.out.println(m.group(3));
	             		System.out.println(m.group(7));
	             		System.out.println();
	             } 
	             
	             //System.out.println(myMap);
	             
	     	}
        }
        

}
