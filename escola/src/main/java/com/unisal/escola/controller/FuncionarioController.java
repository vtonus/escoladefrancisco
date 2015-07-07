package com.unisal.escola.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.unisal.escola.dao.FuncionarioDao;
import com.unisal.escola.miscellaneous.Converter;
import com.unisal.escola.modelo.Funcionario;

@Controller
public class FuncionarioController {
	
	
	
	@RequestMapping("/buscaFuncionario")
	public ModelAndView buscaFuncionario(
			@Valid @RequestParam("nome") String nome,
			@Valid @RequestParam("telefone") String telefone,
			@Valid @RequestParam("dataMin") String dataMin, 
			@Valid @RequestParam("dataMax") String dataMax,
			@Valid @RequestParam("precoMin") float precoMin, 
			@Valid @RequestParam("precoMax") float precoMax,
			@Valid @RequestParam("funcao") String funcao,
			@Valid @RequestParam("especialidade") String especialidade,
			@Valid @RequestParam("cpf") long cpf) {

		FuncionarioDao fd = new FuncionarioDao();
		Funcionario funcionario;
		ModelAndView mav;
		try{
			if (cpf > 0){
				funcionario = fd.buscaFuncionarioCpf(cpf);
				mav = new ModelAndView("/funcionario_resultado");
				mav.addObject("funcionario", funcionario);
				return mav;
			}

		}catch(NullPointerException e){};
		
		List<Funcionario> funcionarios;
		Date dataMin2 = Converter.StringToDate(dataMin);
		Date dataMax2 = Converter.StringToDate(dataMax);
		
		funcionarios = fd.buscaFuncionario(nome, telefone, dataMin2, dataMax2, precoMin, precoMax, funcao, especialidade);
		
		mav = new ModelAndView("/funcionario_resultado");
		mav.addObject("funcionario", funcionarios);

		return mav;
	}
	@RequestMapping("/novoFuncionario")
	public ModelAndView novoFuncionario(@Valid @ModelAttribute("funcionario") Funcionario parametro) {
		
		FuncionarioDao fd = new FuncionarioDao();
		
		fd.cadastraFuncionario(parametro);
		
		ModelAndView mav = new ModelAndView("/funcionario_resultado");
		mav.addObject("funcionario", parametro);
		
		return mav;
	}
	
	@RequestMapping("/editaFuncionario")
	public ModelAndView editaFuncionario(@Valid @ModelAttribute("funcionario") Funcionario parametro) {
		
		FuncionarioDao fd = new FuncionarioDao();
		
		fd.editaFuncionario(parametro);
		
		ModelAndView mav = new ModelAndView("/funcionario_resultado");
		mav.addObject("funcionario", parametro);
		
		return mav;
	}
	
	@RequestMapping("/deletaFuncionario")
	public ModelAndView deletaFuncionario(@Valid @ModelAttribute("funcionario") Funcionario parametro) {
		
		FuncionarioDao fd = new FuncionarioDao();
		
		fd.deletaFuncionario(parametro.getCpf());
		
		ModelAndView mav = new ModelAndView("/funcionario_resultado");
		mav.addObject("funcionario", parametro);
		
		return mav;
	}
	
	
}
