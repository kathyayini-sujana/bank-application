package com.cg.bankapp.controller;

import java.util.List;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cg.bankapp.model.Customer;
import com.cg.bankapp.model.Transaction;
import com.cg.bankapp.service.CustomerService;
import com.cg.bankapp.service.TransactionService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private TransactionService transactionService;

	int customerId;

	@PostMapping("validate")
	public ModelAndView requestLogin(@RequestParam int id, @RequestParam String password) {
		ModelAndView modelAndView;
		//System.out.print(id+" "+password);
		if (id ==13 && password.equals("013")) {
			//System.out.print("manager");
			modelAndView = new ModelAndView("ManagerHomePage");
			return modelAndView;
		} else {
			Customer customer = customerService.findByIdAndPassword(id, password);
			if (customer != null) {
				customerId = id;
				modelAndView = new ModelAndView("CustomerHomePage");

			} else {
				modelAndView = new ModelAndView("index");
			}
		}
		return modelAndView;

	}

	@PostMapping("save")
	public ModelAndView save(@RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String userName, @RequestParam String password) {
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setUserName(userName);
		customer.setPassword(password);
		customer.setAccountBalance(0);
		customerService.save(customer);

		List<Customer> customerslist = customerService.findAll();
		ModelAndView modelAndView = new ModelAndView("customerslist");
		modelAndView.addObject("CUSTOMERSLIST", customerslist);
		return modelAndView;

	}

	@PostMapping("/deposit")
	public ModelAndView deposit(@RequestParam Integer amount) {
		System.out.println("deposited");
		ModelAndView modelAndView;
		
		Customer customer = customerService.findById(customerId);
		int currentBalance = customer.getAccountBalance();
		currentBalance += amount;
		customer.setAccountBalance(currentBalance);
		customerService.save(customer);
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setType("Deposited");
		transaction.setCustomer(customer);
		transactionService.save(transaction);
		modelAndView = new ModelAndView("showBalance");
		modelAndView.addObject("CURRENTBALANCE", currentBalance);
		
		return modelAndView;
	}

	@GetMapping("/showBalance")
	public ModelAndView showBalance() {
		Customer customer = customerService.findById(customerId);
		int accountBalance = customer.getAccountBalance();
		ModelAndView modelAndView = new ModelAndView("showBalance");
		modelAndView.addObject("CURRENTBALANCE", accountBalance);
		return modelAndView;
	}

	@PostMapping("/withdraw")
	public ModelAndView withdraw(@RequestParam Integer amount) {
		ModelAndView modelAndView;
		Customer customer = customerService.findById(customerId);
		int currentBalance = customer.getAccountBalance();
		if (currentBalance < amount) {
			modelAndView = new ModelAndView("error");
			return modelAndView;
		} else {
			currentBalance -= amount;
			customer.setAccountBalance(currentBalance);
			customerService.save(customer);
			Transaction transaction = new Transaction();
			transaction.setAmount(amount);
			transaction.setType("WITHDRAWN");
			transaction.setCustomer(customer);
			transactionService.save(transaction);
			modelAndView = new ModelAndView("showBalance");
			modelAndView.addObject("CURRENTBALANCE", currentBalance);
		}
		return modelAndView;
	}

	@PostMapping("/transfer")
	public ModelAndView transferFund(@RequestParam int id, @RequestParam int amount) {
		ModelAndView modelAndView;
		Customer sender =customerService.findById(customerId);
		Customer receiver= customerService.findById(id);
	int senderBalance=sender.getAccountBalance();
	if(senderBalance<amount) {
		modelAndView=new ModelAndView("error");
	}
	else {
		senderBalance=sender.getAccountBalance()-amount;
		int receiverBalance=receiver.getAccountBalance()+amount;
		sender.setAccountBalance(senderBalance);
		receiver.setAccountBalance(receiverBalance);
		customerService.save(sender);
		customerService.save(receiver);
		Transaction senderTransaction=new Transaction();
		senderTransaction.setAmount(amount);
		senderTransaction.setType("DEBITED");
		senderTransaction.setCustomer(sender);
		transactionService.save(senderTransaction);
		Transaction receiverTransaction = new Transaction();

		
		receiverTransaction.setAmount(amount);
		receiverTransaction.setType("CREDITED");
		receiverTransaction.setCustomer(receiver);
		transactionService.save(receiverTransaction);
		modelAndView = new ModelAndView("TransferDetails");
		modelAndView.addObject("FROMACCOUNTNO", sender.getId());
		modelAndView.addObject("TOACCOUNTNO", receiver.getId());
		modelAndView.addObject("AMOUNTTRANSFERRED", amount);
		modelAndView.addObject("SENDERBALANCE", senderBalance);
	}
	return modelAndView;
	}

	@GetMapping("showTransaction")
	public ModelAndView showTransaction() {

		// Find all the transactions made by the customer with the Id
		List<Transaction> transactionsList = transactionService.findByCustomerId(customerId);

		// Display the JSP page
		ModelAndView modelandview = new ModelAndView("showTransaction");
		modelandview.addObject("TRANSACTIONSLIST", transactionsList);

		// Return the JSP page
		return modelandview;

	}
}












