package com.magalufinder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import com.google.maps.DirectionsApi.RouteRestriction;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.TravelMode;

@RunWith(SpringRunner.class)
public class SearchProductServiceTest {

//	@InjectMocks
//	private UsuarioService usuarioService;
//	
//	@Mock
//	private UsuarioRepository repository;
//	
//	@Mock
//	private BCryptPasswordEncoder passwordEncoder;
//
//    @Before
//    public void initMocks(){
//        MockitoAnnotations.initMocks(this);
//    }
//
//	public UsuarioServiceTest() {
//		usuarioService = new UsuarioService();
//	}
//
//	@Rule
//	public ExpectedException thrown = ExpectedException.none();
	
	
	@Test
	public void testValidarObrigatoriedadeCampoGrupo() throws ApiException, InterruptedException, IOException {
		//set up key
	   	GeoApiContext distCalcer = new GeoApiContext.Builder()
			    .apiKey("AIzaSyDHQK4QkkI03DtshOCz7w6lZqCLRSX-OXs")
			    .build();
	   	
	   	DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(distCalcer); 
	       DistanceMatrix result = req.origins("76125-000")
	               .destinations("74590-800", "76120-000")
	               .mode(TravelMode.DRIVING)
	               .avoid(RouteRestriction.TOLLS)
	               .language("en-US")
	               .await();
	       
				long distApart = result.rows[0].elements[0].distance.inMeters; 
				System.out.println(distApart);
	}
	
	@Test
	public void lookupAddr() throws ApiException, InterruptedException, IOException {
		
		//set up key
		GeoApiContext lookupDoodad = new GeoApiContext.Builder()
				 .apiKey("AIzaSyDHQK4QkkI03DtshOCz7w6lZqCLRSX-OXs")
			    .build();
			GeocodingResult[] results =  GeocodingApi.geocode(lookupDoodad,
			    "74590800").await();
			
			//converts results into usable address
			
			String address = (results[0].formattedAddress);
			System.out.println(address);
	}
	
//	
//	
//	@Test
//	public void testValidarObrigatoriedadeCampoNome() {
//		
//		Usuario usuario =  new UsuarioBuilder()
//				.comEmail("henriquesantiagofranco@gmail.com")
//				.comSenha("123456")
//				.grupos(getGrupo(1L)).build();
//		
//		thrown.expect(BusinessException.class);
//		thrown.expectMessage("Nome é um campo obrigatório!");
//
//		usuarioService.criarNovoUsuario(usuario);
//	}
//	
//	@Test
//	public void testValidarObrigatoriedadeCampoEmail() {
//		
//		Usuario usuario =  new UsuarioBuilder()
//				.comNome("USUARIO-TESTE")
//				.comSenha("123456")
//				.grupos(getGrupo(1L)).build();
//		
//		thrown.expect(BusinessException.class);
//		thrown.expectMessage("E-mail é um campo obrigatório!");
//
//		usuarioService.criarNovoUsuario(usuario);
//	}
//	
//	@Test
//	public void testValidarObrigatoriedadeCampoSenha() {
//		
//		Usuario usuario =  new UsuarioBuilder()
//				.comNome("USUARIO-TESTE")
//				.comEmail("henriquesantiagofranco@gmail.com")
//				.grupos(getGrupo(1L)).build();
//		
//		thrown.expect(BusinessException.class);
//		thrown.expectMessage("Senha é um campo obrigatório!");
//
//		usuarioService.criarNovoUsuario(usuario);
//	}
//	
//	@Test	
//	public void testValidarObrigatoriedadeClinicas() {
//		
//		Usuario usuario =  new UsuarioBuilder()
//				.comNome("USUARIO-TESTE")
//				.comEmail("henriquesantiagofranco@gmail.com")
//				.comSenha("123456")
//				.comTelefone("14545")
//				.grupos(getGrupo(1L)).build();
//		
//		thrown.expect(BusinessException.class);
//		thrown.expectMessage("É necessário informar no mínimo uma clinica!");
//		
//		usuarioService.criarNovoUsuario(usuario);
//	}
//	
//	@Test
//	public void testValidarSeTipoUsuarioEhAdministradorConta() {
//		
//		Usuario usuario =  new UsuarioBuilder()
//				.comNome("USUARIO-TESTE")
//				.comEmail("fran@gmail.com")
//				.comSenha("123456")
//				.comTelefone("123123")
//				.clinicas(getClinica(1L))
//				.grupos(getGrupo(1L)).build();
//		
//		Optional<Usuario> usuarioEmail = Optional.of(new Usuario());
//		
//		when(repository.findByEmail("fran@gmail.com")).thenReturn(usuarioEmail);
//		
//		usuarioService.realizarCadastro(usuario);
//		
//		assertEquals(Boolean.TRUE, usuario.isAdministradorConta());
//	}
//	
//	@Test
//	public void testValidarObrigatoriedadeCampoNomeAdmConta() {
//		
//		Usuario usuario =  new UsuarioBuilder().build();
//		
//		thrown.expect(BusinessException.class);
//		thrown.expectMessage("Nome é um campo obrigatório!");
//		
//		usuarioService.realizarCadastro(usuario);
//	}
//	
//	@Test
//	public void testValidarObrigatoriedadeCampoEmailAdmConta() {
//		
//		Usuario usuario =  new UsuarioBuilder()
//				.comNome("USUARIO-ADM")
//				.build();
//		
//		thrown.expect(BusinessException.class);
//		thrown.expectMessage("E-mail é um campo obrigatório!");
//		
//		usuarioService.realizarCadastro(usuario);
//	}
//	
//	@Test
//	public void testValidarObrigatoriedadeCampoSenhaAdmConta() {
//		
//		Usuario usuario =  new UsuarioBuilder()
//				.comNome("USUARIO-ADM")
//				.comEmail("henriquesantiagofranco@gmail.com")
//				.build();
//		
//		thrown.expect(BusinessException.class);
//		thrown.expectMessage("Senha é um campo obrigatório!");
//		
//		usuarioService.realizarCadastro(usuario);
//	}
//	
//	@Test
//	public void testValidarObrigatoriedadeCampoTelefoneAdmConta() {
//		
//		Usuario usuario =  new UsuarioBuilder()
//				.comNome("USUARIO-ADM")
//				.comEmail("henriquesantiagofranco@gmail.com")
//				.comSenha("123456").build();
//		
//		thrown.expect(BusinessException.class);
//		thrown.expectMessage("Telefone é um campo obrigatório!");
//		
//		usuarioService.realizarCadastro(usuario);
//	}
//	
//	
//	@Test
//	public void testValidarDuplicidadeEmail() {
//		
//		Usuario usuario =  new UsuarioBuilder()
//				.comNome("USUARIO-ADM")
//				.comTelefone("345454")
//				.comEmail("henriquesantiagofranco@gmail.com")
//				.comSenha("123456").build();
//
//		thrown.expect(BusinessException.class);
//		thrown.expectMessage("E-mail já utilizado!");
//		
//		Optional<Usuario> usuarioEmail = Optional.of(usuario);
//		
//		when(repository.findByEmail("henriquesantiagofranco@gmail.com")).thenReturn(usuarioEmail);
//		
//		usuarioService.realizarCadastro(usuario);
//	}
//	
//	
//	@Test
//	public void testValidarObrigatoriedadeGrupoDefinido() {
//		
//		Usuario usuario =  new UsuarioBuilder()
//				.comNome("USUARIO-TESTE")
//				.comEmail("aaa@gmail.com")
//				.comSenha("123456")
//				.comTelefone("5487")
//				.clinicas(getClinica(1L))
//				.grupos(getGrupo(1L)).build();
//		
//		Optional<Usuario> usuarioEmail = Optional.ofNullable(new Usuario());
//		
//		when(repository.findByEmail("aaa@gmail.com")).thenReturn(usuarioEmail);
//		
//		usuarioService.realizarCadastro(usuario);
//		
//		assertEquals(Boolean.TRUE, usuario.isAdministradorConta());
//	}
//	
//	private Set<Clinica> getClinica(Long id) {
//		Set<Clinica> clinicas = new HashSet<>();
//		clinicas.add(new Clinica(id));
//		return clinicas; 
//	}
//
//
//	private Set<Grupo> getGrupo(Long id) {
//		Set<Grupo> grupos = new HashSet<>();
//		grupos.add(new Grupo(id));
//		return grupos; 
//	}

}
