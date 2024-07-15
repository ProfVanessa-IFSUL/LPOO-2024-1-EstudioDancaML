/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import br.edu.ifsul.cc.lpoo.studiodanca.lpoo_studiodanca.dao.PersistenciaJPA;
import br.edu.ifsul.cc.lpoo.studiodanca.lpoo_studiodanca.model.Aluno;
import br.edu.ifsul.cc.lpoo.studiodanca.lpoo_studiodanca.model.Contrato;
import br.edu.ifsul.cc.lpoo.studiodanca.lpoo_studiodanca.model.FolhaPagamento;
import br.edu.ifsul.cc.lpoo.studiodanca.lpoo_studiodanca.model.FormaPgto;
import br.edu.ifsul.cc.lpoo.studiodanca.lpoo_studiodanca.model.Modalidade;
import br.edu.ifsul.cc.lpoo.studiodanca.lpoo_studiodanca.model.Pacote;
import br.edu.ifsul.cc.lpoo.studiodanca.lpoo_studiodanca.model.Pagamento;
import br.edu.ifsul.cc.lpoo.studiodanca.lpoo_studiodanca.model.Professor;
import java.util.Calendar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vanessalagomachado
 */
public class TestePersistenciaObjetos {
    PersistenciaJPA jpa = new PersistenciaJPA();
    public TestePersistenciaObjetos() {
        
    }
    
    @Before
    public void setUp() {
        jpa.conexaoAberta();
    }
    
    @After
    public void tearDown() {
        jpa.fecharConexao();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void test() throws Exception {
         Modalidade m = new Modalidade();
         m.setDescricao("Dança Livre");
         
       
         
         Pacote pct = new Pacote();
         pct.setDescricao("3x");
         pct.setValor(100);
         pct.setModalidade(m);
         
         
         
         
         
         
         
         
         Aluno a = new Aluno();
         a.setNome("Juka");
         a.setFone("+55(54) 99999-1234");
         a.setDataPgto(10);
         
         
         Contrato c = new Contrato();
         c.setValor(20.678);
         c.setForma_pgto(FormaPgto.PIX);
         c.setAluno(a);
         
         Pagamento p = new Pagamento();
         p.setValor(200.00);
         p.setDataVcto(Calendar.getInstance());
         p.setContrato(c);
        
         Professor prof1 = new Professor();
         prof1.setNome("Joao da Silva");
         prof1.setFone("+55(54)90123-1233");
         prof1.setDataAdmissao(Calendar.getInstance());
         
         
         FolhaPagamento f = new FolhaPagamento();
         f.setDataPgto(Calendar.getInstance());
         f.setValorReceber(5000);
         
         prof1.addFolhaPagamentoMes(f);
         prof1.addModalidade(m);
         
//         Persistir Entidades em Ordem Correta para evitar violações de restrições.
         
         jpa.persist(prof1);
         jpa.persist(a);
         jpa.persist(f);
         jpa.persist(m);
         
         jpa.persist(c);
         
         jpa.persist(p);
         jpa.persist(pct);
     }
}
