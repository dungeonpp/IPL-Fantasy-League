package Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/home")
	public String Home()
	{
		return "index.jsp";
	}
	
	@RequestMapping("/")
	public String register()
	{
		return "BidderRegistration.jsp";
	}
}
