package com.firok.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	
	@RequestMapping("/transaction")
    public String getTransactionPage() {
		//return transaction.html
        return "transaction";
    }
}
