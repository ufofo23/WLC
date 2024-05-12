package concoproject.wlc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SearchController {

		@GetMapping("/search/advanced")
		public String advancedSearch() {
			return "search/advanced";
		}
		
		@GetMapping("/search/byName")
		public String searchByName() {
			return "search/byName";
		}
		
}
