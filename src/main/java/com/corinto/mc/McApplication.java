package com.corinto.mc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.corinto.mc.domain.Categoria;
import com.corinto.mc.domain.Cidade;
import com.corinto.mc.domain.Cliente;
import com.corinto.mc.domain.Endereco;
import com.corinto.mc.domain.Estado;
import com.corinto.mc.domain.Produto;
import com.corinto.mc.domain.enums.TipoCliente;
import com.corinto.mc.repositories.CategoriaRepository;
import com.corinto.mc.repositories.CidadeRepository;
import com.corinto.mc.repositories.ClienteRepository;
import com.corinto.mc.repositories.EnderecoRepository;
import com.corinto.mc.repositories.EstadoRepository;
import com.corinto.mc.repositories.ProdutoRepository;

@SpringBootApplication
public class McApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriarepository;
	@Autowired
	private ProdutoRepository produtorepository;
	@Autowired
	private EstadoRepository estadorepository;
	@Autowired
	private CidadeRepository cidaderepository;
	@Autowired
	private ClienteRepository clienterepository;
	@Autowired
	private EnderecoRepository enderecorepository;

	public static void main(String[] args) {
		SpringApplication.run(McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "escritorio");
		
		Produto p1 = new Produto(null, "produto1", 2000.00);
		Produto p2 = new Produto(null, "produto2", 3000.00);
		Produto p3 = new Produto(null, "produto3", 4000.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriarepository.saveAll(Arrays.asList(cat1, cat2));
		produtorepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Sao Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "Sao Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadorepository.saveAll(Arrays.asList(est1, est2));
		cidaderepository.saveAll(Arrays.asList(c1, c2, c3));
	
		Cliente cli1 = new Cliente(null, "Boris Dog", "borisdog@email.com", "66666666669", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("232323232", "12345678"));
		
		Endereco e1 = new Endereco(null, "Rua da rua", "123", "Apto 123", "Bairro", "1234567", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua da rua2", "1233", "Sala 123", "Bairro2", "5555555", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienterepository.saveAll(Arrays.asList(cli1));
		enderecorepository.saveAll(Arrays.asList(e1,e2));
	}

}

