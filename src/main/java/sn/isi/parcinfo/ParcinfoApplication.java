package sn.isi.parcinfo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sn.isi.parcinfo.entities.Ingenieur;
import sn.isi.parcinfo.service.IIngenieurService;

@SpringBootApplication
public class ParcinfoApplication implements CommandLineRunner {
	//Injection de dependence du service pour les traitements
	private IIngenieurService iIngenieurService;

	public ParcinfoApplication(IIngenieurService iIngenieurService) {
		this.iIngenieurService = iIngenieurService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ParcinfoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Creation d'un objet ingenieur à inserer
		Ingenieur ingenieur = new Ingenieur();
		ingenieur.setNom("LO");
		ingenieur.setPrenom("Mouhamed");
		ingenieur.setEmail("mhd.lo14@gmail.com");
		ingenieur.setPassword("Passer457;");

		//Insertion dans la base de données
		ingenieur = iIngenieurService.save(ingenieur);
		System.out.println(ingenieur.getId());
	}
}
