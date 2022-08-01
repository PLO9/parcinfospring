package sn.isi.parcinfo.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.sql.DataSource;

@Configuration
@EnableAutoConfiguration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT email as principal, password as credentials, etat FROM ingenieur WHERE email =  ?")
                .authoritiesByUsernameQuery("SELECT ing.email as principal, r.nom as role FROM ingenieur ing, role r, ingenieur_roles ir WHERE ing.id = ir.ingenieur_id and r.id = ir.roles_id and ing.email = ?")
                .passwordEncoder(new BCryptPasswordEncoder());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.formLogin();//pour afficher un formulaire de connexion par defaut
        http.formLogin().loginPage("/login");//personnaliser le form de login
        //les droits dun ADMIN et SUPER_ADMIN
        http.authorizeRequests().antMatchers("/accueil")
                .hasAnyAuthority("ROLE_USER", "ROLE_ADMIN");
        http.authorizeRequests().antMatchers("/ingenieur/**")
                .hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers("/serveur/**")
                .hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers("/services/**")
                .hasAnyAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers("/role/**")
                .hasAnyAuthority("ROLE_ADMIN");
        //gestion des droits
        http.exceptionHandling().accessDeniedPage("/403");
        http.csrf().disable();
    }
}
