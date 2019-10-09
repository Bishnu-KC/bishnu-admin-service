package com.idexcel.adminservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.idexcel.adminservice.dto.LenderCreateDTO;
import com.idexcel.adminservice.dto.LenderListByStatusDTO;
import com.idexcel.adminservice.dto.LenderListDTO;
import com.idexcel.adminservice.dto.LenderPatchDTO;
import com.idexcel.adminservice.dto.LenderUpdateDTO;
import com.idexcel.adminservice.entity.Lender;
import com.idexcel.adminservice.service.LenderService;

@RestController
@RequestMapping(value="lenders")
public class LenderController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Qualifier("lenderServiceImpl")
	@Autowired
	private LenderService service;
	
	
	@ResponseStatus(code=HttpStatus.OK)
	@GetMapping
	public List<LenderListDTO> findAll(){
		List<Lender> lenderList=service.findAll();
		return lenderList.stream().map(lender -> modelMapper.map(lender, LenderListDTO.class)).collect(Collectors.toList());
	}

	
	@ResponseStatus(code=HttpStatus.OK)
	@GetMapping(value ="{lenderId}")
	public LenderListByStatusDTO findById(@PathVariable("lenderId") String lenderId) {
		Lender lender =service.findById(lenderId);
		return modelMapper.map(lender,LenderListByStatusDTO.class);
	}
	
	
	@PostMapping
	public ResponseEntity<Object> createLender(@Valid @RequestBody LenderCreateDTO lenderCreateDTO, HttpServletRequest request){
		
		Lender lender=modelMapper.map(lenderCreateDTO, Lender.class);
		String id=service.create(lender);
		
		HttpHeaders responseHeaders=new HttpHeaders();
		responseHeaders.add("Location", request.getRequestURL().toString()+"/"+id);
		return new ResponseEntity<>("Id:"+id, responseHeaders, HttpStatus.CREATED);
	}
	
	
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	@PutMapping(value="{lenderId}")
	public void updateLender(@PathVariable("lenderId") String lenderId, @Valid @RequestBody LenderUpdateDTO lenderUpdateDTO) {
		
		Lender lender=service.updateById(lenderId);
		modelMapper.map(lenderUpdateDTO, lender);
		service.update(lenderId, lender);
	}
	
	
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	@DeleteMapping(value="{lenderId}")
	public void deleteLender(@PathVariable("lenderId")String lenderId){
		service.delete(lenderId);
	}
	
	
	
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	@PatchMapping(value="{lenderId}")
	public void patchLender(@PathVariable("lenderId") String lenderId, @Valid @RequestBody LenderPatchDTO lenderPatchDTO) {
		Lender lender=service.findById(lenderId);
		modelMapper.map(lenderPatchDTO,lender);
		service.update(lenderId, lender);
	}
	
	
	@ResponseStatus(code=HttpStatus.OK)
	@RequestMapping(value="{lenderId}",method=RequestMethod.HEAD)
	public void getStatus(@PathVariable("lenderId") String lenderId) {
		service.findById(lenderId);
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
