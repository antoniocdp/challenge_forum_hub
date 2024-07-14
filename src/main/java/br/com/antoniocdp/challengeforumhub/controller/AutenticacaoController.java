package br.com.antoniocdp.challengeforumhub.controller;

import br.com.antoniocdp.challengeforumhub.domain.usuario.DadosAutenticacao;
import br.com.antoniocdp.challengeforumhub.infra.security.DadosToken;
import jakarta.validation.Valid;
import org.apache.catalina.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.token.Token;
import org.springframework.security.core.token.TokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController<Usuario> {

    @Autowired
    private TokenService tokenService;
    private Authenticator authenticationManager;

    @PostMapping
    public ResponseEntity autenticar(@RequestBody @Valid DadosAutenticacao dadosAutenticacao) {
        var token = new UsernamePasswordAuthenticationToken(dadosAutenticacao.login(), dadosAutenticacao.senha());
        var authentication = authenticationManager.authenticate(token);

        Token tokenReturn;
        tokenReturn = tokenService.verifyToken((Usuario) authentication.getPrincipal());
        ResponseEntity<DadosToken> ok = ResponseEntity.ok(new DadosToken(tokenReturn));
        return ok;
    }
}
