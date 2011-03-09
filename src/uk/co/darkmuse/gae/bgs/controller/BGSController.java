package uk.co.darkmuse.gae.bgs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uk.co.darkmuse.gae.bgs.model.Player;
import uk.co.darkmuse.gae.bgs.model.PlayerDAO;


@Controller
public class BGSController  {
	
	private final PlayerDAO playerDAO;
	
	@Autowired
	BGSController(PlayerDAO playerDAO) {
		this.playerDAO = playerDAO;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String renderMainJsp(Model model) {
		List<Player>players=playerDAO.getPlayers();
		model.addAttribute("players", players);
		return "userrank";
	}
	


}
