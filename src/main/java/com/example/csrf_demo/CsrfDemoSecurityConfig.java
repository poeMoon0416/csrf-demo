package com.example.csrf_demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class CsrfDemoSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        // CSRFトークン無効化, これをコメントアウトするとキチンと403でCSRFが防がれる
        // httpSecurity.csrf(csrf -> {
        //     csrf
        //             .disable();
        // });
        // デフォルト設定の明示
        // httpSecurity.csrf(Customizer.withDefaults());

        // 全てのページで認証(指定なしだと全ページ認証不要になる)
        httpSecurity.authorizeHttpRequests(authorize -> {
            authorize
                    .anyRequest().authenticated();
        });

        // ログイン成功時"/"に遷移(指定なしだと403エラーになる, 成功時の挙動が未定義だから？)
        httpSecurity.formLogin(form -> {
            form
                    .defaultSuccessUrl("/");
        });

        return httpSecurity.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        // ユーザー作成, デフォルトだとuser:<ログのパスワード>がつくられる
        return new InMemoryUserDetailsManager(
                User
                        .withUsername("guest")
                        .password(
                                // String直接指定するとパスワードエンコーダーを使うようにしろという例外発生
                                PasswordEncoderFactories
                                        .createDelegatingPasswordEncoder()
                                        .encode("qwerty"))
                        .build());
    }
}
