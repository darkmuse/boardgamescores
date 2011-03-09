package uk.co.darkmuse.gae.bgs.controller.player;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uk.co.darkmuse.gae.bgs.model.Player;
import uk.co.darkmuse.gae.bgs.model.PlayerDAO;

/**
 * JavaBean Form controller that is used to edit an existing <code>Owner</code>.
 * 
 * @author Gary Barker
 */
@Controller
//@SessionAttributes(types = Player.class)
public class FindPlayerForm {
	
	private final PlayerDAO playerDAO;
	
	@Autowired
	FindPlayerForm(PlayerDAO playerDAO) {
		this.playerDAO = playerDAO;
	}
	
	@RequestMapping(value="/players/{username}", method = RequestMethod.GET)
	public String ownerHandler(@PathVariable("username") String username, Model model) {
		Player player = playerDAO.getPlayer(username);
		model.addAttribute(player);
		return "players/show";
	}
	
	@RequestMapping(value = "/players/search", method = RequestMethod.GET)
	public String setupForm(Model model) {
		model.addAttribute("player", new Player());
		return "players/search";
	}

	@RequestMapping(value = "/players", method = RequestMethod.GET)
	public String processSubmit(Player player, BindingResult result, Model model) {

		// allow parameterless GET request for /owners to return all records
		Collection<Player> results;
		if (player.getFirstName() == null) {
			results = playerDAO.getPlayers();
		} else {
			// find owners by last name
			results = playerDAO.findPlayers(player.getFirstName());
		}
		
		if (results.size() < 1) {
			// no owners found
			result.rejectValue("lastName", "notFound", "not found");
			return "players/search";
		}
		if (results.size() > 1) {
			// multiple owners found
			model.addAttribute("selections", results);
			return "players/list";
		}
		else {
			// 1 owner found
			player = results.iterator().next();
			return "redirect:/players/" + player.getUsername();
		}
	}

}
