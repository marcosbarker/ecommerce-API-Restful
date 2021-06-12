package com.residencia.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.residencia.ecommerce.entities.Cliente;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
//	@Override
 //   protected void configure(HttpSecurity httpSecurity) throws Exception {
 //       httpSecurity.csrf().disable()
//                .authorizeRequests().anyRequest().authenticated()
//                .and().httpBasic();
//    }
	
	
	public void configure(AuthenticationManagerBuilder auth, Cliente cliente)throws Exception {
		auth.inMemoryAuthentication().withUser(cliente.getUsername()).password(cliente.getSenha()).roles("Admin").and().withUser("maria").password("{noop}123456").roles("User");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/pedido").access("HasAuthority('Admin')")
		.anyRequest().authenticated()
		.and()
		.httpBasic()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
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
}