package me.jimmyx.gcm;

// Controller class
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

@Controller
public class GCMNotificationController {
	private static final long serialVersionUID = 1L;

	// Put  Google API Server Key here
	private static final String GOOGLE_SERVER_KEY = "AIzaSyDA5dlLInMWVsJEUTIHV0u7maB82MCsZbU";//dummy api key
	static final String MESSAGE_KEY = "message";

	public GCMNotificationController() {
		super();
	}

	// get method to bind view gcm.jsp with model GCMMessage as POJO form binding
	// for sending GCM message
	@RequestMapping(value = "/gcm", method = RequestMethod.GET)
	public ModelAndView student() {
		// view name , model name and object name
		return new ModelAndView("gcm", "command", new GCMMessage());
	}

	// post service function to send a GCM message and prepare a resultant model
	// object for view result.jsp
	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	public String sendMessage(@ModelAttribute("SpringWeb") GCMMessage msg,
			ModelMap model) {

		// get post parameters
		String message = msg.getMessage(); // message to be sent
		String regId = msg.getRegId(); // device regsitration id
		String status; // GCM status

		// add message and device reg id attribute to model object
		model.addAttribute("message", message);
		model.addAttribute("id", regId);

		try {
			// set gcm api key
			Result result = null;
			Sender sender = new Sender(GOOGLE_SERVER_KEY);

			// create GCM message
			Message userMessage = new Message.Builder().timeToLive(30)
					.delayWhileIdle(true).addData(MESSAGE_KEY, message).build();
			// System.out.println("regId: " + regId);

			// send GCM message to GCM server
			result = sender.send(userMessage, regId, 1);

			// save the staus of result
			status = result.toString();

		} catch (IOException ioe) {
			ioe.printStackTrace();
			status = ioe.toString();
		} catch (Exception e) {
			status = e.toString();
		}

		// add GCM status to model attribute
		model.addAttribute("status", status);

		// return result view to render result.jsp
		return "result";
	}

}