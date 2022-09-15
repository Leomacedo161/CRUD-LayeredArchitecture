package br.univille.apidacs2022;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import br.univille.apidacs2022.api.CidadeControllerAPI;
import br.univille.apidacs2022.api.ConsultaControllerAPI;
import br.univille.apidacs2022.api.MedicoControllerAPI;
import br.univille.apidacs2022.api.PacienteControllerAPI;
import br.univille.apidacs2022.api.ProcedimentoControllerAPI;

@SpringBootTest
@AutoConfigureMockMvc
class Apidacs2022ApplicationTests {

	@Autowired
	private PacienteControllerAPI pacienteControllerAPI;
	@Autowired
	private ConsultaControllerAPI consultaControllerAPI;
	@Autowired
	private ProcedimentoControllerAPI procedimentoControllerAPI;
	@Autowired
	private CidadeControllerAPI cidadeControllerAPI;
	@Autowired
	private MedicoControllerAPI medicoControllerAPI;
	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
		assertThat(medicoControllerAPI).isNotNull();
	}

	@Test
	void pacienteControllerAPIPOSTGETTest() throws Exception{
		MvcResult result = 
		mockMvc.perform(post("/api/v1/procedimentos")
			.content("{\"descricao\":\"Roberto ta com dengue\"}")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated()).andReturn();

		String resultStr = result.getResponse().getContentAsString();
		JSONObject objJason = new JSONObject(resultStr);

		mockMvc.perform(get("/api/v1/procedimentos/" + objJason.getString("id")))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.descricao", is("Roberto ta com dengue")));


	}


	// @Test
	// void contextLoads() {
	// 	assertThat(pacienteControllerAPI).isNotNull();
	// }

	// @Test
	// void pacienteControllerAPIPOSTGETTest() throws Exception{
	// 	MvcResult result = 
	// 	mockMvc.perform(post("/api/v1/pacientes")
	// 		.content("{\"nome\":\"Roberto\",\"sexo\":\"Masculino\"}")
	// 		.contentType(MediaType.APPLICATION_JSON))
	// 		.andExpect(status().isCreated()).andReturn();

	// 	String resultStr = result.getResponse().getContentAsString();
	// 	JSONObject objJason = new JSONObject(resultStr);

	// 	mockMvc.perform(get("/api/v1/pacientes/" + objJason.getString("id")))
	// 		.andExpect(status().isOk())
	// 		.andExpect(jsonPath("$.nome", is("Roberto")))
	// 		.andExpect(jsonPath("$.sexo", is("Masculino")));

	// }

}
