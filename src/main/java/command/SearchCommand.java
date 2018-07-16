package command;

import org.hibernate.validator.constraints.NotEmpty;

public class SearchCommand {

	@NotEmpty
    private String filter;

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}
	
	
	
}
