package com.residencia.ecommerce.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	//	@Override
 //   protected void configure(HttpSecurity httpSecurity) throws Exception {
 //       httpSecurity.csrf().disable()
//                .authorizeRequests().anyRequest().authenticated()
//                .and().httpBasic();
//    }
	
	

	
	  private static final String USUARIO_POR_LOGIN = "SELECT username, senha , 'true' as enable FROM client WHERE username=?";
	  
	  private static final String USUARIO_AUTHORITY = "SELECT username, 'ROLE_USER' as authority FROM client WHERE username = ?";
	     
	  @Autowired
	  private DataSource dataSource;
	 
	  @Override
	  protected void configure(AuthenticationManagerBuilder builder) throws Exception {
	    builder
	        .jdbcAuthentication()
	        .dataSource(dataSource)
	        .passwordEncoder(new BCryptPasswordEncoder())
	        .usersByUsernameQuery(USUARIO_POR_LOGIN)
	        .authoritiesByUsernameQuery(USUARIO_AUTHORITY)
	        .rolePrefix("ROLE_USER");
	  }
	
	@Override
	 protected void configure(HttpSecurity http) throws Exception {
		    http.csrf().disable().authorizeRequests()
			.antMatchers(HttpMethod.POST, "/cliente/cadastro").permitAll()
			.antMatchers(HttpMethod.POST, "/cliente/esqueci-senha").permitAll()
			.antMatchers(HttpMethod.GET, "/categoria/nome/{name}").permitAll()
			.antMatchers(HttpMethod.GET, "/categoria/listar-todos").permitAll()
			.antMatchers(HttpMethod.POST, "/categoria/nova-categoria").permitAll()
			.antMatchers(HttpMethod.DELETE, "/categoria/{nome}").permitAll()
			.antMatchers(HttpMethod.GET, "/produto/nome/{name}").permitAll()
			.antMatchers(HttpMethod.GET, "/produto/listar-todos").permitAll()
			.antMatchers(HttpMethod.POST, "/produto/novo-produto").permitAll()
	        .anyRequest().authenticated()
	        .and()
	        .httpBasic();
		  }
}

// GALERA, TAVA TESTANDO E POR ISSO CRIEI ESSES MÉTODOS AQUI
// TALVEZ DÊ PARA FAZER O LOGIN A PARTIR DISSO AQUI
// DEIXEI COMENTADO PORQUE NÃO PROSSEGUI COM MEDO DE FAZER BESTEIRA 
// ASS: IGUIN DO LOGIN
//	@Bean
//	public static @CryptPasswordEncoder passwordEncoder(){
//		return new @CryptPasswordEncoder();
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().anyRequest().authenticated().and().formLogin();
//	}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication().withUser(username "user")
//		.password(passwordEncoder().encode(newpassword "password")).authorities("USER");
//	}
