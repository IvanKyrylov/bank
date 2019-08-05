package com.cursach.controller;

import com.cursach.dao.AccountDao;
import com.cursach.entity.CreditAccount;
import com.cursach.entity.DepositAccount;
import com.cursach.entity.User;
import com.cursach.service.AccountService;
import com.cursach.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService<CreditAccount> accountServiceCredit;

    @Autowired
    private AccountService<DepositAccount> accountServiceDeposit;

    @GetMapping("/user")
    public String userMenu(Model model, Principal principal) {
        model.addAttribute("depositList", accountServiceDeposit.findCreditByUserId(userService.getByUsername(principal.getName()).getId()));
        model.addAttribute("creditList", accountServiceCredit.findCreditByUserId(userService.getByUsername(principal.getName()).getId()));
        return "user";
    }
//
//    @PostMapping("/userSelect")
//    public String createAccount(Principal principal, String type) {
//        if (type.equals("Deposit"))accountServiceDeposit.addCredit(userService.getByUsername(principal.getName()));
//        else accountServiceCredit.addCredit(userService.getByUsername(principal.getName()));
//        return "user";
//    }
}
