package com.artur.cadastroalunosspring.services;

import com.artur.cadastroalunosspring.dto.requests.ResponsavelRequest;
import com.artur.cadastroalunosspring.dto.responses.ResponsavelResponse;
import com.artur.cadastroalunosspring.entities.Responsavel;
import com.artur.cadastroalunosspring.repositories.ResponsavelRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//Junit + mockito + springboot
@SpringBootTest
class ResponsavelServiceTest {

    @MockBean
    private ResponsavelRepository responsavelRepository;

    @Autowired
    private ResponsavelService responsavelService;

    @Test
    void salvarTest() {

        //cenario
        ResponsavelRequest responsavelRequest =  new ResponsavelRequest();
        responsavelRequest.setNome("Responsavel Test.");
        responsavelRequest.setTelefone("0987654321");

        Responsavel responsavel = new Responsavel();
        responsavel.setId(1L);
        responsavel.setNome("Responsavel Teste.");
        responsavel.setTelefone("4002-8922");

        Mockito.
                when(responsavelRepository.save(Mockito.any()))
                .thenReturn(responsavel);

        //execução
        ResponsavelResponse responsavelResponse = responsavelService.salvar(responsavelRequest);

        //verificação
        assertNotNull(responsavelResponse.getId());
        assertEquals(1L, responsavelResponse.getId());
        assertEquals("Responsavel Teste.", responsavelResponse.getNome());
        assertEquals("4002-8922", responsavelResponse.getTelefone());
    }

    @Test
    void obter() {
    }

    @Test
    void deletar() {
    }

    @Test
    void atualizar() {
    }

    @Test
    void listarTodos() {
    }
}