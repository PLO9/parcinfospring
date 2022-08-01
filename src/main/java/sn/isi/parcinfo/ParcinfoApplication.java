package sn.isi.parcinfo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sn.isi.parcinfo.entities.Ingenieur;
import sn.isi.parcinfo.entities.Role;
import sn.isi.parcinfo.entities.Services;
import sn.isi.parcinfo.service.IIngenieurService;
import sn.isi.parcinfo.service.IRoleService;
import sn.isi.parcinfo.service.IServeurService;
import sn.isi.parcinfo.service.IServiceService;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class ParcinfoApplication implements CommandLineRunner {

	//Injection de dependence du service pour les traitements
	private IIngenieurService iIngenieurService;
	private IServeurService iServeurService;
	private IServiceService iServiceService;

	private IRoleService iRoleService;
	public ParcinfoApplication(IIngenieurService iIngenieurService, IServeurService iServeurService, IServiceService iServiceService,IRoleService iRoleService){
		this.iIngenieurService = iIngenieurService;
		this.iServeurService = iServeurService;
		this.iServiceService = iServiceService;
		this.iRoleService = iRoleService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ParcinfoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role role = new Role();
		role.setNom("ROLE_USER");

		role = iRoleService.save(role);
		//System.out.println(roles.getId());
		//Creation d'un objet ingenieur à inserer
		Ingenieur ingenieur = new Ingenieur();
		ingenieur.setNom("DIOP");
		ingenieur.setPrenom("Abdoulaye");
		ingenieur.setEmail("ab.diop14@gmail.com");
		BCryptPasswordEncoder pwdcrypt = new BCryptPasswordEncoder();
		String pwd = pwdcrypt.encode("passer123");
		ingenieur.setPassword(pwd);
		ingenieur.setEtat(1);
		List<Role> listRoles = new ArrayList<>();
		listRoles.add(iRoleService.get(1));
		ingenieur.setRoles(listRoles);
		//Insertion dans la base de données
		ingenieur = iIngenieurService.save(ingenieur);
		//System.out.println(ingenieur.getId());

		//Creation d'un objet serveur à inserer
		//Serveur serveur = new Serveur();
		//serveur.setAdrIp("192.168.10.1");
		//serveur.setNom("Web server");
		//serveur.setIngenieur(iIngenieurService.get(1));
		//Insertion de serveur dans la base de données
		//serveur = iServeurService.save(serveur);
		//System.out.println(serveur.getId());

		//Creation d'un objet service à inserer
		  //Services service = new Services();
		  //service.setNom("SSH");
		  //service.setPort(22);
		  //service.setIngenieur(iIngenieurService.get(1));
		  //service.setServeur(iServeurService.get(1));

		  //Insertion de serveur dans la base de données
		  //service = iServiceService.save(service);
		  //System.out.println(service.getId());


	}
}
