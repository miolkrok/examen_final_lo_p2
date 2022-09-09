package com.uce.edu.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uce.edu.demo.repository.modelo.ReservaPasajeTO;
import com.uce.edu.demo.repository.modelo.Vuelo;
import com.uce.edu.demo.repository.modelo.VueloTO;
import com.uce.edu.demo.service.IGestorClienteService;

@Controller
@RequestMapping("/clientes/")
public class GestorClienteController {
	
	@Autowired
	private IGestorClienteService gestorClienteService;
	
	@GetMapping("buscarVuelos")
	public String obtenerPaginaDatos(VueloTO vueloTO, Model modelo) {
		
		return "buscaVuelos";
	}
	
	@GetMapping("mostrar/vuelosDisponibles")
	public String mostrarVuelos(VueloTO vueloTO,BindingResult result, Model modelo, RedirectAttributes redirectAttributes) {
		
		
		
		modelo.addAttribute("vuelos", this.gestorClienteService.buscarVuelosDispon(vueloTO.getOrigen(), vueloTO.getDestino(), vueloTO.getFechaVuelo()));
		return "mostrarVuelos";

	}
	//////////////////////2/////////////////////
	@GetMapping("reservar")
	public String obtenerPagIngDatos(ReservaPasajeTO reservaPasajeTO) {
		
		return "reservar";
		
	}
	@PostMapping("ingresoDatos")
	public String ingresarDatosCompra(ReservaPasajeTO reservaPasajeTO, BindingResult result, Model modelo,RedirectAttributes redirectAttributes) {
		
		ReservaPasajeTO resePasTO = this.gestorClienteService.vueloNumero(reservaPasajeTO.getNumeroVuelo());
		if(resePasTO != null) {
			modelo.addAttribute("vuelo", resePasTO);
			modelo.addAttribute("busqueda1", true);
			modelo.addAttribute("busqueda2", true);
			return "reservar";
		}
		redirectAttributes.addFlashAttribute("mensaje", "Vuelo no Disponible");
		return "redirect:/clientes/reservar";	
	}
	@PostMapping("comprar")
	public String generarCompra(ReservaPasajeTO reservaPasajeTO, BindingResult result, Model modelo, RedirectAttributes redirectAttributes) {
		
		Boolean valor = this.gestorClienteService.reservarPasajesAereos(reservaPasajeTO.getCantidadAsientosComprados(), reservaPasajeTO.getNumeroTarjeta(), reservaPasajeTO.getNumeroVuelo());
		
		if(valor) {
			redirectAttributes.addFlashAttribute("mensaje", "Compra Realizada");
		}else {
			redirectAttributes.addFlashAttribute("mensaje","no se puede comprar mas de los asientos disponibles");
		}
		return "redirect:/clientes/reservar";
		
	}
	
	
	

}
