package com.expehris.springmvc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.expehris.springmvc.model.Admin;
import com.expehris.springmvc.model.Comptable;
import com.expehris.springmvc.model.Employeur;
import com.expehris.springmvc.model.FileBucket;
import com.expehris.springmvc.model.Search;
import com.expehris.springmvc.model.User;
import com.expehris.springmvc.model.UserBulletin;
import com.expehris.springmvc.model.UserDocument;
import com.expehris.springmvc.service.UserDocumentService;
import com.expehris.springmvc.service.UserService;
import com.expehris.springmvc.service.EmployeurService;
import com.expehris.springmvc.service.AdminService;
import com.expehris.springmvc.service.ComptableService;
import com.expehris.springmvc.util.FileValidator;

import com.expehris.springmvc.model.Login;



@Controller
@RequestMapping("/")

public class AppController {

	@Autowired
	UserService userService;
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	ComptableService comptableService;

	@Autowired
	EmployeurService employeurService;
	
	@Autowired
	UserDocumentService userDocumentService;
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	FileValidator fileValidator;
	
	@InitBinder("fileBucket")
	protected void initBinder(WebDataBinder binder) {
	   binder.setValidator(fileValidator);
	}
	
	  @RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("login");
	    mav.addObject("login", new Login());
	    return mav;
	  }
	  
		@RequestMapping(value="/logout",method = RequestMethod.GET)
		public String logout(HttpServletRequest request){
		    HttpSession httpSession = request.getSession();
		    request.getSession().removeAttribute("logedUser");
		    httpSession.invalidate();
		    return "redirect:/login";
		}

	  
	  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("login") Login login) {
	    ModelAndView mav = null;
	    request.getSession().setAttribute("logedUser", login.getUsername());
	    User user = userService.findByLoginPassword(login.getUsername(),login.getPassword());
	    if (user != null ) {
		    mav = new ModelAndView("redirect:/listdocumentbulletins-"+login.getUsername()+"-2017");
		    mav.addObject("username", user.getLogin());
		    mav.addObject("user", user);
		    request.getSession().setAttribute("role", "employe");
		    request.getSession().setAttribute("isEmployee", true);

		    
	    }else {
	    	Comptable comptable = comptableService.findByLoginPassword(login.getUsername(),login.getPassword());
	    	if (comptable != null) {
			    mav = new ModelAndView("redirect:/list");
			    request.getSession().setAttribute("role", "comptable");

	    	}else {
		    	Employeur employeur = employeurService.findByLoginPassword(login.getUsername(),login.getPassword());
	    		if(employeur != null) {
				    mav = new ModelAndView("redirect:/listEmployees");
				    request.getSession().setAttribute("role", "employeur");

	    		}else{
	    			Admin admin = adminService.findByLoginPassword(login.getUsername(),login.getPassword());
	    			if(admin != null) {
	    				  mav = new ModelAndView("redirect:/list-comptables");
					    mav = new ModelAndView("redirect:/list-employeurs");
					  
					    request.getSession().setAttribute("role", "admin");

	    			}else {
					    mav = new ModelAndView("login");
					    mav.addObject("message", "Login/Mot de passe incorrect !!");
		    				
	    			}
	    		}
	    	}
	    }
	    return mav;
	  }
	  
	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String listUsers(HttpServletRequest request,ModelMap model) {
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");
		

		if(logedUser == null || logedUser.equals("") || loggedRole == null || !loggedRole.equals("comptable") ){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}
		List<User> users = userService.findAllByCreateur(logedUser);
		model.addAttribute("users", users);
		model.addAttribute("isEmployeur", false);
		return "userslist";
	}

	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = { "/listEmployees" }, method = RequestMethod.GET)
	public String listEmployees(HttpServletRequest request,ModelMap model) {
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");
		
		if(logedUser == null || logedUser.equals("") || loggedRole == null || !loggedRole.equals("employeur") ){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}

		String year=	(String) request.getSession().getAttribute("searchedyear");
		if(year==null || year.equals(""))
		{
			request.getSession().setAttribute("searchedyear","2017");	
		}

		Employeur emp = employeurService.findByLogin(logedUser);
		String entreprise = emp.getEntreprise();
		List<User> users = userService.findAllByEntreprise(entreprise);
		model.addAttribute("users", users);
		
		model.addAttribute("isEmployeur", true);
		return "userListEmployeur";
	}
	

	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
	public String newUser(HttpServletRequest request,ModelMap model) {
		 
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || !loggedRole.equals("comptable")){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		return "registration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String saveUser(HttpServletRequest request, @Valid User user, BindingResult result,
			ModelMap model) {

		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || !loggedRole.equals("comptable") ){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}
		System.out.println("createur begin:");
		if (result.hasErrors()) {
			return "registration";
		}

		/*
		 * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique annotation 
		 * and applying it on field [sso] of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */
		if(!isUserUnique( user.getLogin())){
			FieldError ssoError =new FieldError("user","login",messageSource.getMessage("non.unique.login", new String[]{user.getLogin()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}
		
		String createur = (String) request.getSession().getAttribute("logedUser");
		System.out.println("createur :"+createur);
		user.setCreateur(createur);
		userService.saveUser(user);
		
		model.addAttribute("user", user);
		model.addAttribute("success", "L'employ� " + user.getFirstName() + "  "+ user.getLastName() + " est enregistr� avec succ�s");
		//return "success";
		return "registrationsuccess";
	}


	private boolean isUserUnique(String login) {
		
		
		User user = userService.findByLogin(login);
		Comptable comptable = comptableService.findByLogin(login);
		Employeur employeur = employeurService.findByLogin(login);
		Admin admin = adminService.findByLogin(login);
	    if (user != null) {
	    	return false;		    
	    }
	   
	    else if (comptable != null) {
	    		return false;	
	    	}
	    
	    else if(employeur != null) {
	    			return false;			    
	    		}
	    			
	    else if(admin != null) {
	    				return false;			    				
	    			}
	    else {
					    return true;	
	    			}
	    		
	    	
	    
	}
	

	
	/**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/edit-user-{login}" }, method = RequestMethod.GET)
	public String editUser(HttpServletRequest request,@PathVariable String login, ModelMap model) {
		
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || !loggedRole.equals("comptable")){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}
		User user = userService.findByLogin(login);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		return "registration";
	}
	
	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-user-{login}" }, method = RequestMethod.POST)
	public String updateUser(HttpServletRequest request,@Valid User user, BindingResult result,
			ModelMap model, @PathVariable String login) {
		
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || !loggedRole.equals("comptable")){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}

		if (result.hasErrors()) {
			return "registration";
		}

		userService.updateUser(user);

		model.addAttribute("success", "La modification de " + user.getFirstName() + " "+ user.getLastName() + " est effectu�e!");
		return "registrationsuccess";
	}

	
	/**
	 * This method will delete an user by it's SSOID value.
	 */
	@RequestMapping(value = { "/delete-user-{login}" }, method = RequestMethod.GET)
	public String deleteUser(HttpServletRequest request,@PathVariable String login) {
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || !loggedRole.equals("comptable") ){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}
		
		userService.deleteUserByLogin(login);
		return "redirect:/list";
	}
	

	
	@RequestMapping(value = { "/add-document-{login}" }, method = RequestMethod.GET)
	public String addDocuments(HttpServletRequest request,@PathVariable String login, ModelMap model) {
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("")  || loggedRole == null || !loggedRole.equals("comptable" ) ){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}
		
		User user = userService.findByLogin(login);
		model.addAttribute("user", user);
		
		LinkedList<String> listAnnee = getListAnne();
		LinkedList<String> listTypes = getListType();
		LinkedList<String> listMois = getListMois();
		model.addAttribute("Annees", listAnnee);
		model.addAttribute("Types", listTypes);
		model.addAttribute("Mois", listMois);
		model.addAttribute("paie", true);
		
		FileBucket fileModel = new FileBucket();
		model.addAttribute("fileBucket", fileModel);

		List<UserDocument> documents = userDocumentService.findAllByLogin(login);
		model.addAttribute("documents", documents);
		
		return "managedocuments";
	}
	

	@RequestMapping(value = { "/download-document-{login}-{docId}" }, method = RequestMethod.GET)
	public String downloadDocument(HttpServletRequest request,@PathVariable String login, @PathVariable int docId, HttpServletResponse response) throws IOException {
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || loggedRole.equals("admin" )){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}
		
		UserDocument document = userDocumentService.findById(docId);
		response.setContentType(document.getType());
        response.setContentLength(document.getContent().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + document.getName() +"\"");
 
        FileCopyUtils.copy(document.getContent(), response.getOutputStream());
 
 		return "redirect:/add-document-"+login;
	}

	@RequestMapping(value = { "/delete-document-{login}-{docId}" }, method = RequestMethod.GET)
	public String deleteDocument(HttpServletRequest request,@PathVariable String login, @PathVariable int docId) {
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || !loggedRole.equals("comptable") ){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}
		userDocumentService.deleteById(docId);
		return "redirect:/add-document-"+login;
	}

	@RequestMapping(value = { "/add-document-{login}" }, method = RequestMethod.POST)
	public String uploadDocument(HttpServletRequest request,@Valid FileBucket fileBucket, BindingResult result, ModelMap model, @PathVariable String login) throws IOException{
		
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || !loggedRole.equals("comptable") ){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}
		if (result.hasErrors()) {
			System.out.println("validation errors");
			User user = userService.findByLogin(login);
			model.addAttribute("user", user);
			LinkedList<String> listAnnee = getListAnne();
			LinkedList<String> listTypes = getListType();
			LinkedList<String> listMois = getListMois();
			model.addAttribute("Annees", listAnnee);
			model.addAttribute("Types", listTypes);
			model.addAttribute("Mois", listMois);
			model.addAttribute("paie", true);

			List<UserDocument> documents = userDocumentService.findAllByLogin(login);
			model.addAttribute("documents", documents);
			
			return "managedocuments";
		} else {
			
			System.out.println("Fetching file");
			
			User user = userService.findByLogin(login);
			model.addAttribute("user", user);

			saveDocument(fileBucket, user);

			return "redirect:/add-document-"+login;
		}
	}
	
	private void saveDocument(FileBucket fileBucket, User user) throws IOException{
		
		UserDocument document = new UserDocument();
		
		MultipartFile multipartFile = fileBucket.getFile();
		
		document.setName(multipartFile.getOriginalFilename());
		document.setDescription(fileBucket.getDescription());
		document.setType(multipartFile.getContentType());
		document.setContent(multipartFile.getBytes());
		document.setAnnee(fileBucket.getAnnee());
		document.setMois(fileBucket.getMois());
		document.setTypedocument(fileBucket.getType());
		document.setUser(user);
		String dateCreation = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		document.setDateCreation(dateCreation);


		userDocumentService.saveDocument(document);
	}
	

	private LinkedList<String> getListAnne(){
	    LinkedList<String> list = new LinkedList<String>();
	    
	    for(int cpt=2000; cpt<=2100;cpt++) {
		    list.add(""+cpt); 
	    }
	    return list;
	}

	private LinkedList<String> getListMois(){
	    LinkedList<String> list = new LinkedList<String>();
	    list.add("Janvier");		
		list.add("F�vrier");	
		list.add("Mars");	
		list.add("Avril");	
		list.add("Mai");
		list.add("Juin");		
		list.add("Juillet");
		list.add("Aout");		
		list.add("Septembre");	
		list.add("Octobre");	
		list.add("Nouvembre");	
		list.add("D�cembre");
	
	    return list;
	}

	private LinkedList<String> getListType(){
	    LinkedList<String> list = new LinkedList<String>();
	
	    list.add("Bulletin de paie");
	    list.add("Autres");
	
	    return list;
	}
	
	


	@RequestMapping(value = { "/listbulletins-{year}" }, method = RequestMethod.GET)
	public String getListBulletinofYear(HttpServletRequest request, ModelMap model, @PathVariable String year) throws IOException{
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || !loggedRole.equals("employeur")){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}
		
		Employeur emp = employeurService.findByLogin(logedUser);
		String entreprise = emp.getEntreprise();
		List<User> users = userService.findAllByEntreprise(entreprise);
		
		LinkedList<String> listAnnee = getListAnne();
		model.addAttribute("Annees", listAnnee);
		model.addAttribute("year", year);
		Search search = new Search();
		search.setYear(year);
		model.addAttribute("search", search);
		
		List<UserBulletin> documents = userDocumentService.findBulletinByYear(users, year);
		model.addAttribute("bulletins", documents);
		
		return "consultbulletins";
	}
	


	@RequestMapping(value = { "/doSearchBulletin" }, method = RequestMethod.GET)
	public String searchBulletinYear(HttpServletRequest request,ModelMap model,@ModelAttribute("search") Search search) throws IOException{
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || !loggedRole.equals("employeur") ){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}
		
		Employeur emp = employeurService.findByLogin(logedUser);
		String entreprise = emp.getEntreprise();
		List<User> users = userService.findAllByEntreprise(entreprise);

		model.addAttribute("year", search.getYear());
        System.out.println("year :"+search.getYear());

		request.getSession().setAttribute("searchedyear", search.getYear());
        List<UserBulletin> documents = userDocumentService.findBulletinByYear(users, search.getYear());
		model.addAttribute("bulletins", documents);
		
		return "redirect:/listbulletins-"+search.getYear();
	}

	
	@RequestMapping(value ={"/listdocumentbulletins-{login}-{year}" }, method = RequestMethod.GET)
	public String getListDocument(HttpServletRequest request, ModelMap model, @PathVariable String login, @PathVariable String year) throws IOException{
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || loggedRole.equals("admin") /*|| ! loggedRole.equals("employeur") || !loggedRole.equals("employe") || !loggedRole.equals("comptable")*/){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}
		
		User user = userService.findByLogin(login);
		model.addAttribute("user", user);
		LinkedList<String> listAnnee = getListAnne();
		model.addAttribute("Annees", listAnnee);
		model.addAttribute("year", year);
		Search search = new Search();
		search.setYear(year);
		model.addAttribute("search", search);
		request.getSession().setAttribute("login", login);
		
		List<UserDocument> documents = userDocumentService.findAllBulletin(login, year, "Bulletin de paie");
		model.addAttribute("bulletindocuments", documents);

		List<UserDocument> otherDoc = userDocumentService.findOtherDocuments(login, "Autres");
		model.addAttribute("otherdocuments", otherDoc);
		
		return "consultdocument-bulletinsdepaie";
	}
	
	
	@RequestMapping(value ={"/listdocumentbulletinsComptable-{login}-{year}" }, method = RequestMethod.GET)
	public String getListDocuments(HttpServletRequest request, ModelMap model, @PathVariable String login, @PathVariable String year) throws IOException{
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || loggedRole.equals("admin") /*|| ! loggedRole.equals("employeur") || !loggedRole.equals("employe") || !loggedRole.equals("comptable")*/){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}
		
		User user = userService.findByLogin(login);
		model.addAttribute("user", user);
		LinkedList<String> listAnnee = getListAnne();
		model.addAttribute("Annees", listAnnee);
		model.addAttribute("year", year);
		Search search = new Search();
		search.setYear(year);
		model.addAttribute("search", search);
		request.getSession().setAttribute("login", login);
		
		List<UserDocument> documents = userDocumentService.findAllBulletin(login, year, "Bulletin de paie");
		model.addAttribute("bulletindocuments", documents);

		List<UserDocument> otherDoc = userDocumentService.findOtherDocuments(login, "Autres");
		model.addAttribute("otherdocuments", otherDoc);
		
		return "consultdocument-bulletinsdepaie-comptable";
	}
	
	
	
	@RequestMapping(value = { "/listdocumentautres-{login}" }, method = RequestMethod.GET)
	public String getListDocumentautres(HttpServletRequest request, ModelMap model, @PathVariable String login) throws IOException{
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || loggedRole.equals("admin") /*|| ! loggedRole.equals("employeur") || !loggedRole.equals("employe") || !loggedRole.equals("comptable")*/){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}
		String year=	(String) request.getSession().getAttribute("searchedyear");
		if(year==null || year.equals(""))
		{
			year="2017";
			
		}

		User user = userService.findByLogin(login);
		model.addAttribute("user", user);
		LinkedList<String> listAnnee = getListAnne();
		model.addAttribute("Annees", listAnnee);
		model.addAttribute("year", year);
		Search search = new Search();
		search.setYear(year);
		model.addAttribute("search", search);
		request.getSession().setAttribute("login", login);
		

		List<UserDocument> otherDoc = userDocumentService.findOtherDocuments(login, "Autres");
		model.addAttribute("otherdocuments", otherDoc);
		
		return "consultdocuments-autres";
	}
	
	@RequestMapping(value = { "/listdocsComptable-{login}" }, method = RequestMethod.GET)
	public String getListDocumentautrescomptable(HttpServletRequest request, ModelMap model, @PathVariable String login) throws IOException{
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || loggedRole.equals("admin") /*|| ! loggedRole.equals("employeur") || !loggedRole.equals("employe") || !loggedRole.equals("comptable")*/){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}
		String year=	(String) request.getSession().getAttribute("searchedyear");
		if(year==null || year.equals(""))
		{
			year="2017";
			
		}

		User user = userService.findByLogin(login);
		model.addAttribute("user", user);
		LinkedList<String> listAnnee = getListAnne();
		model.addAttribute("Annees", listAnnee);
		model.addAttribute("year", year);
		Search search = new Search();
		search.setYear(year);
		model.addAttribute("search", search);
		request.getSession().setAttribute("login", login);
		

		List<UserDocument> otherDoc = userDocumentService.findOtherDocuments(login, "Autres");
		model.addAttribute("otherdocuments", otherDoc);
		
		return "consultdocsComptable";
	}
	


	@RequestMapping(value = { "/doSearch/{login}" }, method = RequestMethod.GET)
	public String searchDocument(HttpServletRequest request,ModelMap model,@ModelAttribute("search") Search search, @PathVariable String login) throws IOException{

		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || loggedRole.equals("admin")){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}

		
		request.getSession().setAttribute("searchedyear", search.getYear());
		model.addAttribute("year", search.getYear());
        System.out.println("year :"+search.getYear());
		List<UserDocument> documents = userDocumentService.findAllBulletin(login, search.getYear(), "Bulletin de paie");
		model.addAttribute("bulletindocuments", documents);

		List<UserDocument> otherDoc = userDocumentService.findOtherDocuments(login, "Autres");
		model.addAttribute("otherdocuments", otherDoc);
		
		return "redirect:/listdocumentbulletins-"+login+"-"+search.getYear();
	}
	
	

	@RequestMapping(value = { "/listdocumentEmpl-{login}-{year}" }, method = RequestMethod.GET)
	public String getListDocumentEmpl(HttpServletRequest request, ModelMap model, @PathVariable String login, @PathVariable String year) throws IOException{
		
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || !loggedRole.equals("employeur")){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}
		
		User user = userService.findByLogin(login);
		model.addAttribute("user", user);
		LinkedList<String> listAnnee = getListAnne();
		model.addAttribute("Annees", listAnnee);
		model.addAttribute("year", year);
		Search search = new Search();
		search.setYear(year);
		model.addAttribute("search", search);
		request.getSession().setAttribute("login", login);
		
		List<UserDocument> documents = userDocumentService.findAllBulletin(login, year, "Bulletin de paie");
		model.addAttribute("bulletindocuments", documents);

		List<UserDocument> otherDoc = userDocumentService.findOtherDocuments(login, "Autres");
		model.addAttribute("otherdocuments", otherDoc);
		
		return "consultdocumentempl";
	}
	


	@RequestMapping(value = { "/doSearchEmpl/{login}" }, method = RequestMethod.GET)
	public String searchDocumentEmpl(HttpServletRequest request,ModelMap model,@ModelAttribute("search") Search search, @PathVariable String login) throws IOException{

		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || !loggedRole.equals("employeur") ){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}
		
		model.addAttribute("year", search.getYear());
        System.out.println("year :"+search.getYear());

		request.getSession().setAttribute("searchedyear", search.getYear());
		List<UserDocument> documents = userDocumentService.findAllBulletin(login, search.getYear(), "Bulletin de paie");
		model.addAttribute("bulletindocuments", documents);

		List<UserDocument> otherDoc = userDocumentService.findOtherDocuments(login, "Autres");
		model.addAttribute("otherdocuments", otherDoc);
		
		return "redirect:/listdocumentEmpl-"+login+"-"+search.getYear();
	}
// Traitement comptable  ------------------------------------------------------------------------


	@RequestMapping(value = { "/list-employeurs" }, method = RequestMethod.GET)
	public String listEmployeurs(HttpServletRequest request,ModelMap model) {
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || !loggedRole.equals("admin")){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}
		
		List<Employeur> Employeurs = employeurService.findAllEmployeurs();
		model.addAttribute("employeurs", Employeurs);
		
		return "Admin-Employeurs";
	}
	
	
	@RequestMapping(value = { "/list-comptables" }, method = RequestMethod.GET)
	public String listComptables(HttpServletRequest request,ModelMap model) {
		
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || !loggedRole.equals("admin")){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}

		List<Comptable> Comptables = comptableService.findAllComptables();
		model.addAttribute("comptables", Comptables);
		
		
		return "Admin-Comptables";
	}
	
	
	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/newcomptable" }, method = RequestMethod.GET)
	public String newComptable(HttpServletRequest request,ModelMap model) {
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || !loggedRole.equals("admin")){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}
		
		Comptable user = new Comptable();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		return "registrationcompta";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newcomptable" }, method = RequestMethod.POST)
	public String saveComptable(HttpServletRequest request,@Valid Comptable user, BindingResult result,
			ModelMap model) {
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || !loggedRole.equals("admin") ){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}

		if (result.hasErrors()) {
			model.addAttribute("user", user);
			model.addAttribute("edit", false);
			return "registrationcompta";
		}

		/*
		 * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique annotation 
		 * and applying it on field [sso] of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */

		if(!isUserUnique( user.getLogin())){
			FieldError ssoError =new FieldError("user","login",messageSource.getMessage("non.unique.login", new String[]{user.getLogin()}, Locale.getDefault()));
		    result.addError(ssoError);
			model.addAttribute("user", user);
			model.addAttribute("edit", false);
			return "registrationcompta";
		}
		
		comptableService.saveComptable(user);
		
		model.addAttribute("user", user);
		model.addAttribute("success", "Le comptable " + user.getPrenom() +" "+ user.getNom() + " est enregistr� avec succ�s");
		//return "success";
		return "registrationsuccesscompta";
	}


	/**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/edit-comptable-{login}" }, method = RequestMethod.GET)
	public String editComptable(HttpServletRequest request,@PathVariable String login, ModelMap model) {
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || !loggedRole.equals("admin") ){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}
		
		Comptable user = comptableService.findByLogin(login);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		return "registrationcompta";
	}
	
	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-comptable-{login}" }, method = RequestMethod.POST)
	public String updateComptable(@Valid Comptable user, BindingResult result,
			ModelMap model, @PathVariable String login,HttpServletRequest request) {
		
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || !loggedRole.equals("admin") ){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}

		if (result.hasErrors()) {
			model.addAttribute("user", user);
			model.addAttribute("edit", false);
			return "registrationcompta";
		}

		comptableService.updateComptable(user);

		model.addAttribute("success", "La modification de " + user.getNom() + " "+ user.getPrenom() + " est effectu�e !");
		return "registrationsuccesscompta";
	}

	
	/**
	 * This method will delete an user by it's SSOID value.
	 */
	@RequestMapping(value = { "/delete-comptable-{login}" }, method = RequestMethod.GET)
	public String deleteComptable(@PathVariable String login,HttpServletRequest request) {
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || !loggedRole.equals("admin")){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}
		comptableService.deleteUserComptable(login);
		return "redirect:/list-comptables";
	}
	

	// ----------------------------- Traitement Employeur -----------------
	

	
	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/newemployeur" }, method = RequestMethod.GET)
	public String newEmployeur(ModelMap model,HttpServletRequest request) {
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || !loggedRole.equals("admin")){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}
		
		Employeur user = new Employeur();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		return "registrationempl";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newemployeur" }, method = RequestMethod.POST)
	public String saveEmployeur(HttpServletRequest request,@Valid Employeur user, BindingResult result,
			ModelMap model) {
		
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || !loggedRole.equals("admin") ){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}

		if (result.hasErrors()) {
			model.addAttribute("user", user);
			model.addAttribute("edit", false);
			return "registrationempl";
		}
		/*
		 * Preferred way to achieve uniqueness of field [sso] should be implementing custom @Unique annotation 
		 * and applying it on field [sso] of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */
		
		if(!isUserUnique( user.getLogin())){
			FieldError ssoError =new FieldError("user","login",messageSource.getMessage("non.unique.login", new String[]{user.getLogin()}, Locale.getDefault()));
		    result.addError(ssoError);
			model.addAttribute("user", user);
			model.addAttribute("edit", false);
			return "registrationempl";
		}
		
		employeurService.saveEmployeur(user);
		
		model.addAttribute("user", user);
		model.addAttribute("success", "L'employeur " + user.getPrenom() + " "+ user.getNom() + " est enregistr� avec succ�s");
		//return "success";
		return "registrationsuccessempl";
	}
	

	/**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/edit-employeur-{login}" }, method = RequestMethod.GET)
	public String editEmployeur(HttpServletRequest request,@PathVariable String login, ModelMap model) {
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || !loggedRole.equals("admin")){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}
		Employeur user = employeurService.findByLogin(login);
		if(user != null) {
		     System.out.println("employeur nom : "+user.getNom());
		}
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		return "registrationempl";
	}
	
	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-employeur-{login}" }, method = RequestMethod.POST)
	public String updateEmployeur(HttpServletRequest request,@Valid Employeur user, BindingResult result,
			ModelMap model, @PathVariable String login) {
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || !loggedRole.equals("admin")){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}

		if (result.hasErrors()) {
			model.addAttribute("user", user);
			model.addAttribute("edit", false);
			return "registrationempl";
		}

		employeurService.updateEmployeur(user);

		model.addAttribute("success", "La modification de " + user.getNom() + " "+ user.getPrenom() + " est effectu�e !");
		return "registrationsuccessempl";
	}

	
	/**
	 * This method will delete an user by it's SSOID value.
	 */
	@RequestMapping(value = { "/delete-employeur-{login}" }, method = RequestMethod.GET)
	public String deleteEmployeur(HttpServletRequest request,@PathVariable String login) {
		String logedUser = (String) request.getSession().getAttribute("logedUser");
		String loggedRole = (String) request.getSession().getAttribute("role");

		if(logedUser == null || logedUser.equals("") || loggedRole == null || !loggedRole.equals("admin")){
			ModelAndView mav = new ModelAndView("login");
		    mav.addObject("login", new Login());
		    return "redirect:/login";
		}
		employeurService.deleteUserEmployeur(login);
		return "redirect:/list-employeurs";
	}
}
