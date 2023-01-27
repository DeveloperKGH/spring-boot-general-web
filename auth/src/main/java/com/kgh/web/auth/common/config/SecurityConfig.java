package com.kgh.web.auth.common.config;

import com.kgh.web.auth.common.filter.JwtAuthenticationFilter;
import com.kgh.web.auth.common.util.JwtTokenProvider;
import com.kgh.web.global.domain.enums.MemberRole;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {
	private final JwtTokenProvider jwtTokenProvider;
	private final AuthenticationEntryPoint customAuthenticationEntryPoint;

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.cors()
			.and()
				.csrf()
					.disable()
				.exceptionHandling()
				.authenticationEntryPoint(customAuthenticationEntryPoint)
			.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
				.formLogin().disable()
				.authorizeRequests()
				.antMatchers("/**/signup", "/**/signin").permitAll()
				.antMatchers("/**/me").hasAnyAuthority(MemberRole.MEMBER.name(), MemberRole.ADMIN.name())
				.antMatchers("/**/members/{id}").hasAnyAuthority(MemberRole.ADMIN.name())
				.anyRequest().authenticated()
				.and()
				.addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
						UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

}

