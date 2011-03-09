package uk.co.darkmuse.gae.bgs.validation;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import uk.co.darkmuse.gae.bgs.model.Player;

public class PlayerValidator {
	public void validate(Player player, Errors errors) {
		if (!StringUtils.hasLength(player.getFirstName())) {
			errors.rejectValue("firstName", "required", "required");
		}
		if (!StringUtils.hasLength(player.getLastName())) {
			errors.rejectValue("lastName", "required", "required");
		}
		if (!StringUtils.hasLength(player.getUsername())) {
			errors.rejectValue("username", "required", "required");
		}
		
		Long rating = player.getRating();
		if (rating < 0 || rating > 5000) {
			errors.rejectValue("rating", "out-of-range", "out-of-range");
		}
	}

}