package com.api.marvel.controller;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.api.marvel.model.DataModel;
import com.api.marvel.model.Results;

@Controller
public class ApiMarvelConsumer {
	
	//seleção das variaveis 
	
	String publicKey = "ce97fad4a20c632bde78b471943aac47";
	
	String privateKey = "b227dab162d95097207d1c6801f49673a72b79a3";
	
	String finalHash = "5217adf0ea0dd8d977e005be283d9115";
	
	String baseUrl = "http://gateway.marvel.com/v1/public/characters?limit=30&ts=1&apikey=ce97fad4a20c632bde78b471943aac47&hash=5217adf0ea0dd8d977e005be283d9115";
	
	
	
	String userKey = "?ts=1&apikey=ce97fad4a20c632bde78b471943aac47&hash=5217adf0ea0dd8d977e005be283d9115";
	
	RestTemplate restTemplate = new RestTemplate();
	
	
	
	
		
		
	
	//retorna uma pagina inicial com um limite de personagens definido pelo parâmetro "limit=" na baseUrl.
	@RequestMapping(value="/")
	public ModelAndView retornaArrayDeNomesDeHerois() {
		
		ResponseEntity<DataModel> arrayDeHerois = restTemplate.getForEntity(baseUrl, DataModel.class);
		ModelAndView mvc = new ModelAndView("characters");
		
		
			//System.out.println(arrayDeHerois.getBody().getData().getResults().get(i).getName());
			
			
			List<Results> nomeCharacter = arrayDeHerois.getBody().getData().getResults();
			
			String imageThumb = arrayDeHerois.getBody().getData().getResults().get(18).getThumbnail().getPath();
			
			String extension = arrayDeHerois.getBody().getData().getResults().get(18).getThumbnail().getExtension();
			
			
			
			String completePathImage = imageThumb+"."+extension;
			
			arrayDeHerois.getBody().getData().setLimit(21);
			System.out.println(arrayDeHerois.getBody().getData().getLimit());
			mvc.addObject("thumbnaili", completePathImage);
			
			mvc.addObject("array",nomeCharacter);
	
		
		return mvc;
		
		
	}
	//Busca um personagem pelo começo do nome
	@RequestMapping(value="/buscar")
	public ModelAndView buscaPersonagem(@RequestParam("buscar") String nomeCharacterBusca ) {
		
		String baseUrlBusca = "http://gateway.marvel.com/v1/public/characters?nameStartsWith="+nomeCharacterBusca+"&limit=100&ts=1&apikey=ce97fad4a20c632bde78b471943aac47&hash=5217adf0ea0dd8d977e005be283d9115";
		
		ModelAndView mvc = new ModelAndView("characters");
		
		ResponseEntity<DataModel> responseSearch = restTemplate.getForEntity(baseUrlBusca, DataModel.class);
		
		List<Results> resultadoBusca = responseSearch.getBody().getData().getResults();
		
		if(responseSearch.getBody().getData().getCount() == 0) {
			String hasError = "Nenhum personagem encontrado, tente apenas pelo primeiro nome.";
			mvc.addObject("hasError", hasError );
			
		}
		

		mvc.addObject("array", resultadoBusca);
		return mvc;
		
	}
	
	//Retorna as series relacionadas ao personagem clicado buscando pelo "id"
	@RequestMapping(value="/series")
	public ModelAndView seriesRelacionadas(int idPersonagem) {
		
		String urlSeries = "http://gateway.marvel.com/v1/public/characters/" + idPersonagem + "/series?limit=100&ts=1&apikey=ce97fad4a20c632bde78b471943aac47&hash=5217adf0ea0dd8d977e005be283d9115";
		
		ModelAndView mvc = new ModelAndView("characters");
		
		ResponseEntity<DataModel> responseSeries = restTemplate.getForEntity(urlSeries, DataModel.class);
		
		List<Results> resultadoSeries = responseSeries.getBody().getData().getResults();
		
		if(responseSeries.getBody().getData().getCount() == 0) {
			String hasError = "Nenhum Quadrinho encontrado :,(";
			mvc.addObject("hasError", hasError );
			
		}
		
		mvc.addObject("series", resultadoSeries);
		
		return mvc;
	}
	
	
}
