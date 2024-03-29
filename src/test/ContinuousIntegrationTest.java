import br.com.fatesg.eventos.persistence.CategoriaPersistence;
import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

/**
 * Teste Criar Nova Categoria
 *
 */
//@WebIntegrationTest(value = "server.port=9000")
//@SeleniumTest(driver = ChromeDriver.class, baseUrl = "http://localhost:9000")
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class ContinuousIntegrationTest {

	private CategoriaPersistence categoriaDao;
	private WebDriver driver;

	@Before
	public void startBrowser() {
		EnvironmentManager.initWebDriver();
	}

//	@Test
//	public static void main(String[] args) throws InterruptedException {
	@Test
	public void ciTest() throws InterruptedException{

		driver = RunEnvironment.getWebDriver();

		driver.get("http://localhost/#/acesso");

		// Maximiza o navegador
		driver.manage().window().maximize();
		Thread.sleep(3000);

		// Login
		driver.findElement(By.id("usuario")).sendKeys("test_robot");
		driver.findElement(By.id("senha")).sendKeys("123456");
		driver.findElement(By.className("btn-primary")).click();
		Thread.sleep(3000);

		// Cadastro de Categoria
		driver.findElement(By.id("categoria")).click();
		Thread.sleep(3000);

		driver.findElement(By.className("btn-info")).click();
		Thread.sleep(3000);

		driver.findElement(By.id("nome-categoria")).sendKeys("Teste Automatizado");
		driver.findElement(By.className("btn-info")).click();
		Thread.sleep(3000);

		driver.findElement(By.id("descricao-categoria")).sendKeys("Descrição do Teste Automatizado");
		Thread.sleep(3000);

		driver.findElement(By.className("btn-info")).click();
		Thread.sleep(3000);

		// (TODO: Add unit test.)"
//		long id =1;
//		assertTrue("teste", categoriaDao.findById(id).isPresent());
//		Boolean present = categoriaDao.findById(id).isPresent();
//		System.out.println(present);

		// Filtrar Categoria
		driver.findElement(By.id("filtrar-categoria")).sendKeys("Teste Automatizado");

		// Editar de Categoria
		driver.findElement(By.id("editar-categoria")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("nome-categoria")).clear();
		driver.findElement(By.id("nome-categoria")).sendKeys("Teste Automatizado Atualizado");
		driver.findElement(By.id("descricao-categoria")).clear();
		driver.findElement(By.id("descricao-categoria")).sendKeys("Descrição do Teste Automatizado " +
				"Atualizado");
		driver.findElement(By.className("btn-info")).click();

		// Filtrar Categoria
		driver.findElement(By.id("filtrar-categoria")).clear();
		driver.findElement(By.id("filtrar-categoria")).sendKeys("Teste Automatizado Atualizado");

		// Excluir de Categoria
		driver.findElement(By.id("excluir-categoria")).click();

		// Atualiza Pagina
		driver.navigate().refresh();
		Thread.sleep(5000);
	}

	@After
	public void tearDown() {
		EnvironmentManager.shutDownDriver();
	}
}