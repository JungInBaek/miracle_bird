package com.multi.miraclebird.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class storeController {
	@RequestMapping("store/storeMain")
	public String main() {
		return "store/storeMain";
	}
}
