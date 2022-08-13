package com.artur.cadastroalunosspring.services;

import com.artur.cadastroalunosspring.dto.requests.ResponsavelRequest;
import com.artur.cadastroalunosspring.dto.responses.ResponsavelResponse;
import com.artur.cadastroalunosspring.entities.Responsavel;
import com.artur.cadastroalunosspring.exceptions.ResponsavelNotFoundException;
import com.artur.cadastroalunosspring.repositories.ResponsavelRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//Junit + mockito + springboot
@SpringBootTest
class ResponsavelServiceTest {

    @MockBean
    private ResponsavelRepository responsavelRepository;

    @Autowired
    private ResponsavelService responsavelService;

    @Test
    void salvarSucesso() {

        //cenario
        ResponsavelRequest responsavelRequest =  new ResponsavelRequest();
        responsavelRequest.setNome("Responsavel Test.");
        responsavelRequest.setTelefone("0987654321");

        Responsavel responsavel = new Responsavel();
        responsavel.setId(1L);
        responsavel.setNome("Responsavel Teste.");
        responsavel.setTelefone("4002-8922");

        when(responsavelRepository.save(any()))
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
    void obterSucesso() {
        //cenario
        Long id = 1L;

        Responsavel responsavel = getResponsavel(1L);

        when(responsavelRepository.findById(Mockito.any()))
                .thenReturn(Optional.of(responsavel));

        //execução
        ResponsavelResponse responsavelResponse = responsavelService.obter(id);

        //verificação
        assertEquals(id, responsavelResponse.getId());
    }

    @Test
    void deletarSucesso() {
        //cenario
        Long idResponsavel = 1L;

        when(responsavelRepository.findById(any()))
                .thenReturn( Optional.of( getResponsavel(1L) ) );

        //execução
        responsavelService.deletar(idResponsavel);
        //verificação em delete não é necessario
    }

    @Test
    void atualizarSucesso() {
        //cenario
        Long idResponsavel = 1L;
        ResponsavelRequest responsavelRequest = getResponsavelRequest();

        Responsavel responsavel = new Responsavel();
        responsavel.setId(idResponsavel);
        responsavel.setNome(responsavelRequest.getNome());
        responsavel.setTelefone(responsavelRequest.getTelefone());

        when(responsavelRepository.save(any()))
                .thenReturn(responsavel);

        when(responsavelRepository.findById(any()))
                .thenReturn(Optional.of(responsavel));

        //teste - execução
        ResponsavelResponse responsavelResponse = responsavelService.atualizar(idResponsavel, responsavelRequest);

        //Verificação
        assertEquals(responsavelRequest.getNome(), responsavelResponse.getNome());
        assertEquals(responsavelRequest.getTelefone(), responsavelResponse.getTelefone());
        assertEquals(1L, responsavelResponse.getId());
        assertNotNull(responsavelResponse.getId());
    }

    @Test
    void listarTodosSucesso() {
        //cenario
        Responsavel responsavel = getResponsavel(1L);
        Responsavel responsavel2 = getResponsavel(2L);
        Responsavel responsavel3 = getResponsavel(3L);
        Responsavel responsavel4 = getResponsavel(4L);


        List<Responsavel> responsavelList = List.of(responsavel, responsavel2, responsavel3, responsavel4);

        when(responsavelRepository.findAll())
                .thenReturn(responsavelList);

        //execução
        List<ResponsavelResponse> responsavelResponseList = responsavelService.listarTodos();

        //verificação
       assertTrue(responsavelResponseList.size() > 0);
       assertEquals(4, responsavelResponseList.size());
       assertEquals(1L, responsavelResponseList.get(0).getId());
       assertEquals(2L, responsavelResponseList.get(1).getId());
       assertEquals(3L, responsavelResponseList.get(2).getId());
       assertEquals(4L, responsavelResponseList.get(3).getId());

    }

    //testes esperando falha---------------------------------------------------------------------

    @Test
    void salvarFalha() {//Neste teste espero que dê erro... mas não está dando erro..

        //cenario
        ResponsavelRequest responsavelRequest =  getResponsavelRequest();

        Responsavel responsavel = null;

        when(responsavelRepository.save(any()))
                .thenThrow(new RuntimeException("Simulando erro ao chamar função salve do repository"));

        //execução, espero que dê erro de RuntimeException
        assertThrows(
                RuntimeException.class,
                () -> responsavelService.salvar(responsavelRequest)
        );
    }

    @Test
    void atualizarFalha() {
        //cenario
        Long idResponsavel = 1L;
        ResponsavelRequest responsavelRequest = getResponsavelRequest();

        Responsavel responsavel = null;

        when(responsavelRepository.save(any()))
                .thenReturn(responsavel);

        when(responsavelRepository.findById(any()))
                .thenReturn(Optional.ofNullable(responsavel));

        //teste - execução
        assertThrows(
                NoSuchElementException.class,
                () -> responsavelService.atualizar(idResponsavel, responsavelRequest)
        );
    }

    @Test
    void obterFalha() {
        //cenario
        Long id = 1L;

        Responsavel responsavel = null;

        when(responsavelRepository.findById(Mockito.any()))
                .thenReturn(Optional.ofNullable(responsavel));

        //execução
        assertThrows(
                ResponsavelNotFoundException.class,
                () -> responsavelService.obter(id)
        );
    }

    @Test
    void deletarFalha() {
        //cenario
        Long idResponsavel = 1L;

        when(responsavelRepository.findById(any()))
                .thenReturn( Optional.ofNullable( null ) );

        //execução
        assertThrows(
                ResponsavelNotFoundException.class,
                () -> responsavelService.deletar(1L)
        );

        //verificação em delete não é necessario
    }

    @Test
    void listarTodosFalha() {
        //cenario
        Responsavel responsavel = getResponsavel(1L);
        Responsavel responsavel2 = getResponsavel(2L);
        Responsavel responsavel3 = getResponsavel(3L);
        Responsavel responsavel4 = getResponsavel(4L);

        List<Responsavel> responsavelList = List.of(responsavel, responsavel2, responsavel3, responsavel4);

        when(responsavelRepository.findAll())
                .thenReturn(null);

        //execução
        assertThrows(
                NullPointerException.class,
                () -> responsavelService.listarTodos()
        );

    }

    private ResponsavelRequest getResponsavelRequest(){
        ResponsavelRequest responsavelRequest =  new ResponsavelRequest();
        responsavelRequest.setNome("Responsavel Test.");
        responsavelRequest.setTelefone("0987654321");

        return responsavelRequest;
    }

    private Responsavel getResponsavel(Long id){

        Responsavel responsavel = new Responsavel();
        responsavel.setId(id);
        responsavel.setNome("Responsavel Teste." + id);
        responsavel.setTelefone("4002-8922");

        return responsavel;
    }
}