package com.kamaduino.controller;

import com.kamaduino.dto.HumedadDTO;
import com.kamaduino.dto.UserDTO;
import com.kamaduino.service.HumedadService;
import com.kamaduino.service.UserService;
import com.kamaduino.utils.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

	@Autowired
	UserService userService;

	@Autowired
	HumedadService humedadService;

	@RequestMapping(value = Constantes.LOGIN, method = RequestMethod.GET)
	public ResponseEntity<HttpStatus> login(@RequestParam("user") String user,@RequestParam("pass") String pass){
		UserDTO userLogin = new UserDTO(user, pass);
		if(userService.loginUser(userLogin)){
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

//	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody String create(@RequestParam("covere") String covere, @RequestParam("title") String title,
//									   @RequestParam("username") String username, @RequestParam("usernameto") String usernameto) {
//		try {
//			mailService.sendMail(covere, title, username, usernameto);
//			return "sendmail";
//		} catch (MailException e) {
//			e.printStackTrace();
//		}
//		return "sendmail";
//	}

	@RequestMapping(value = "/api/test", method = RequestMethod.GET)
	public ResponseEntity<List<HumedadDTO>> test(){
		List<HumedadDTO> humedadList = humedadService.getAllData();
		return new ResponseEntity<>(humedadList, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/post", method = RequestMethod.GET)
	public ResponseEntity<List<HumedadDTO>> testPost(){
		List<HumedadDTO> humedadList = humedadService.getAllData();
		return new ResponseEntity<>(humedadList, HttpStatus.OK);
	}

//	@GetMapping(value = "/offers/{offerId}/{offerCode}")
//	@Secured
//	public ResponseEntity<Offer> getFullOffer(@PathVariable("offerId") String offerId,
//											  @PathVariable("offerCode") String offerCode) throws IOException {
//
//		return new ResponseEntity<>(offerService.getFullOffer(this.getUserContext(), offerId, offerCode), HttpStatus.OK);
//	}
}
