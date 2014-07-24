package smobs;

import java.io.File;
import java.net.URL;
import java.util.Date;

class Stub {

	private String name;
	private URL url;
	private File logo;
	private String[] categories;
	private Date launchDate;
	
	public Stub(String name, URL url, File logo, String[] categories, Date launchDate) {
		this.name = name;
		this.url = url;
		this.logo = logo;
		this.categories = categories;
		this.launchDate = launchDate;
	}
	
	/**
	 * <mediawiki>
	 *   <page>
	 *     <title></title>
	 *     <revision>
	 *       <text>
	 * {{Social Machine
	 * | name = 
	 * | logo = [[File:logo.png|150px|Logo]]
	 * | screenshot = 
	 * | url = http://www.example.org/
	 * | type = 
	 * | language = comma separated language list
	 * | registration = Yes / No
	 * | launch date = 
	 * | current status =
	 * }}
	 *       </text>
	 *     </revision>
	 *   </page>
	 * </mediawiki>
	 * 
	 */
	public String generateStubText() {
		StringBuffer out = new StringBuffer();
		
		return out.toString();
	}
	
	
}
