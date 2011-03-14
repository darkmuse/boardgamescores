package uk.co.darkmuse.gae.bgs.controller.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import uk.co.darkmuse.gae.bgs.model.Player;
import uk.co.darkmuse.gae.bgs.model.PlayerDAO;
import uk.co.darkmuse.gae.bgs.validation.PlayerValidator;

/**
 * JavaBean Form controller that is used to edit an existing <code>Player</code>.
 * 
 * @author Gary Barker
 */
@Controller
@RequestMapping(value="/players/{username}/edit")
public class EditPlayerForm {
	
	private final PlayerDAO playerDAO;
	
	@Autowired
	EditPlayerForm(PlayerDAO playerDAO) {
		this.playerDAO = playerDAO;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(@PathVariable("username") String username, Model model) {
		Player player = playerDAO.getPlayer(username);
		if (player == null) {
			player = new Player(username, 0);
		}
		model.addAttribute(player);
		return "players/form";
	}

	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.POST})
	public String processPut(@ModelAttribute Player player, BindingResult result, SessionStatus status) {
		new PlayerValidator().validate(player, result);
		if (result.hasErrors()) {
			return "players/form";
		}
		else {
			playerDAO.addPlayer(player);
			status.setComplete();
			return "redirect:/players/" + player.getUsername();
		}
	}

}
