package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Controller
public class Controlleur {
	@Autowired
	private produitsRepository produitsrepository;
	@Autowired
	private categoryRepository categoryrepository;
	@Autowired
	private souscategorieRepository souscategoryrepository;
	public Controlleur(){
		
	}
	@ResponseBody //annonce une méthode qui fabrique une réponse web
	@RequestMapping("/") //définit l'url http://127.0.0.1:8080/
	public String home() {
	String href = "/categories/";
	String href2 = "/produits/";
	
	String html = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n"
			+ "<html>\r\n"
			+ "<head>\r\n"
			+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n"
			+ "<title>E-commerce</title>\r\n"
			+ "</head>\r\n"
			+ "<body>\r\n"
			+"<br><br><br>"
			+ "<h1 style=\"color:blue;font-size:large\" >E-commerce</h1>\r\n"
			+ "<br><a  href=\"/categories/\" style=\"text-decoration:none;color:blue;font-size:large\"> Liste des categories</a>\r\n"
			+ "<br><a href=\"/produits/\" style=\"text-decoration:none;color:blue;font-size:large\"> Liste des produits</a>\r\n"
			+ "</body>\r\n"
			+ "</html>";
	return html;
	}
	@ResponseBody
	@GetMapping("/categories/")
	public String Category() {
		String html = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n"
			+ "<html>\r\n"
			+ "<head>\r\n"
			+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n"
			+ "<title>Titre de la page</title>\r\n"
			+ "</head>\r\n"
			+ "<body>\r\n"
			+"<p><a href=/  style=\"text-decoration:none;color:grey;font-size:large\"><-- </a><h1 style=\"color:blue;font-size:large\"><br>Les categories sont : <br></h1></p>\r\n";

		Iterable<category> ar = categoryrepository.findAll();
		
		for (category p : ar) {
			String href = "/souscategories/categories/"+String.valueOf(p.getId());
			html = html+"<br><a href="+href+" style=\"text-decoration:none;color:blue;font-size:large\">La categorie "+p.getNom()+"</a><br>\r\n";
		}
		html = html+"</body>\r\n"+"</html>";
		
		return html;
	}

	@ResponseBody
	@GetMapping("/souscategories/categories/{categorie}")
	public String SousCategory(@PathVariable Integer categorie) {
		category lacategorie =  categoryrepository.findbyid2(categorie); 
		String html = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n"
			+ "<html>\r\n"
			+ "<head>\r\n"
			+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n"
			+ "<title>Titre de la page</title>\r\n"
			+ "</head>\r\n"
			+ "<body>\r\n"
			+"<p><a href=/categories/ style=\"text-decoration:none;color:grey;font-size:large\"><-- </a><h1 style=\"color:blue;font-size:large\"><br>Les sous categories de la categorie "
			+lacategorie.getNom() 
			+" : <br></h1></p>\r\n";
		
		Iterable<souscategory> ar = souscategoryrepository.findbySousCategorie(categorie);
		for (souscategory p : ar) {

			String href = "/souscategories/produits/"+String.valueOf(p.getId());
			html = html+"<br><a href="+href+" style=\"text-decoration:none;color:blue;font-size:large\">La sous categorie "+p.getNom()+"</a><br>\r\n";
		}
		html = html+"</body>\r\n"+"</html>";
		return html;
	}
	

	@ResponseBody
	@GetMapping("/souscategories/produits/{souscategorie}")
	public String ProduitsbySousCategory(@PathVariable Integer souscategorie) {
		souscategory refsouscategorie = souscategoryrepository.findbyId(souscategorie);
		
		Iterable<produits> ar = produitsrepository.findbyCategory(refsouscategorie.getCategory(),refsouscategorie.getSouscategory());
		String html = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n"
				+ "<title>Titre de la page</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+"<p><a href=/souscategories/categories/"+refsouscategorie.getCategory()+" style=\"text-decoration:none;color:grey;font-size:large\"><-- </a><h1 style=\"color:blue;font-size:large\"><br>Les produits de la sous categorie "
				+refsouscategorie.getNom() 
				+" : <br></h1></p>\r\n";
		for (produits p : ar) {

			String href = "/produits/"+String.valueOf(p.getId());
			html = html+"<br><a href="+href+" style=\"text-decoration:none;color:blue;font-size:large\">Le produit "+p.getNom()+"</a><br>\r\n";
		}
		return html;
	}
	@ResponseBody
	@GetMapping("/produits")
	public String produits() {
		String html = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n"
			+ "<html>\r\n"
			+ "<head>\r\n"
			+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n"
			+ "<title>Titre de la page</title>\r\n"
			+ "</head>\r\n"
			+ "<body>\r\n"
			+"<p><a href=/  style=\"text-decoration:none;color:grey;font-size:large\"><-- </a><h1 style=\"color:blue;font-size:large\"><br>Les produits sont : <br></h1></p>\r\n";
		Iterable<produits> ar2 = produitsrepository.findAll();
		for (produits p : ar2) {

			String href = "/produits/"+String.valueOf(p.getId());
			html = html+"<br><a href="+href+" style=\"text-decoration:none;color:blue;font-size:large\">Le produit "+p.getNom()+"</a><br>\r\n";
		}
		
		html = html+"</body>\r\n"+"</html>";
		return html;
	}
	@ResponseBody
	@GetMapping("/produits/{id}")
	public String produitsbyid(@PathVariable Integer id) {
		produits p = produitsrepository.findbyId2(id);
		String style = "color:blue;font-size:large";
		String html = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n"
				+ "<title>Titre de la page</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+"<p><a href=/souscategories/produits/"+p.getSousCategory()+"  style=\"text-decoration:none;color:grey;font-size:large\"><-- </a>"
				+"<h1 style=\"color:blue;font-size:large\"><br>Les informations du produit sont :  <br></h1></p>\r\n"

				+"<text style="+style+">- Son nom est "+p.getNom()+"</text><br>"
				+"<text style="+style+">- Son id est "+p.getId()+"</text><br>"
				+"<text style="+style+">- Son stock est "+p.getStock()+"</text><br>"
				+"<text style="+style+">- Sa discription est "+p.getDiscription() +"</text><br>"
				+"<text style="+style+">- Sa categorie est "+p.getCategory() +"</text><br>"
				+"<text style="+style+">- Sa sous categorie est "+p.getSousCategory() +"</text><br>"
				+" : <br></p>\r\n";
		return html;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pagedeux")
	public String deux(HttpSession session) {
	 System.out.println("Page deux: l'utilisateur est " + session.getAttribute("user") );
	 String html = "";
	 html += ("Page deux. L'utilisateur est:" + session.getAttribute("user")+ "<br><ul>");
	 html += " <li><a href='/suite'>Retour suite</a></li>";
	 html += "</ul>";
	 html += "<br> <li><a href='/logout'>logout</a></li>";
	 return html;
	}
	 @RequestMapping("/login")
	 public String login() {
		 return "login"; //retourne la JSP login.jsp
	 }
}
