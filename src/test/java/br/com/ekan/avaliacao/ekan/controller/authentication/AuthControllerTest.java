package br.com.ekan.avaliacao.ekan.controller.authentication;

import br.com.ekan.avaliacao.ekan.entity.beneficiary.Beneficiary;
import br.com.ekan.avaliacao.ekan.record.beneficiary.BeneficiaryRequestRecord;
import br.com.ekan.avaliacao.ekan.repository.beneficiary.BeneficiaryRepository;
import br.com.ekan.avaliacao.ekan.utils.UtilsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;

import static br.com.ekan.avaliacao.ekan.utils.UtilsTest.objectToJson;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class AuthControllerTest {

  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Autowired
  private BeneficiaryRepository beneficiaryRepository;


  @Value("${security.token.test.secret}")
  private String secret;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders
      .webAppContextSetup(webApplicationContext)
      .apply(SecurityMockMvcConfigurers.springSecurity())
      .build();
  }

  @Test
  @DisplayName("should be able to create a new beneficiary")
  void should_be_able_to_create_a_new_beneficiary() throws Exception {

    Beneficiary beneficiary = Beneficiary.builder()
      .username("pablojg9")
      .password("123456")
      .name("Pablo Junior")
      .telephone("123456577")
      .dateBirth(LocalDateTime.now())
      .build();

    beneficiaryRepository.saveAndFlush(beneficiary);

    BeneficiaryRequestRecord beneficiaryRequestRecord =
      new BeneficiaryRequestRecord("pablojg9_test", "123456", "Pablo Junior", "12345678", "24/09/2024", 1);


    mockMvc.perform(MockMvcRequestBuilders.post("/beneficiarys/save")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectToJson(beneficiaryRequestRecord)).header("Authorization", UtilsTest.generateToken(beneficiary.getId(), secret)))
      .andExpect(status().isCreated());
  }
}