package smobs;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SocialMachinePage {

	private String name;
	private String url;
	private String logo;
	private List<String> categories;
	private List<String> languages;
	private String registration; 
	private String launchDate;
	private String status;
	
	public SocialMachinePage(String name) {
		super();
		this.name = name;
	}

	public SocialMachinePage(String name, String url) {
		this.name = name;
		this.url = url;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public String isRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(String launchDate) {
		this.launchDate = launchDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * <mediawiki>
	 *   <page>
	 *     <title></title>
	 *     <revision>
	 *       <text>
	 * {{Social Machine
	 * | name = 
	 * | url = http://www.example.org/
	 * | logo = [[File:logo.png|150px|Logo]]
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
		try { 
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			Element mediawiki = doc.createElement("mediawiki");
			doc.appendChild(mediawiki);
			Element page = doc.createElement("page");
			mediawiki.appendChild(page);
			Element title = doc.createElement("title");
			title.setTextContent(name);
			page.appendChild(title);
			Element revision = doc.createElement("revision");
			page.appendChild(revision);
			Element text = doc.createElement("text");
			text.setTextContent(generateTemplateText()+"\n"+generateContentText());
			revision.appendChild(text); 
	        Transformer transformer = TransformerFactory.newInstance().newTransformer();
	        DOMSource source = new DOMSource(doc);
	        StreamResult result = new StreamResult(new File(name+".xml"));
	        transformer.transform(source, result);
		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
		    tfe.printStackTrace();
		  }
		return null;
	}
	
	private String generateTemplateText() {
		StringBuffer out = new StringBuffer("{{Social Machine\n");
		if (name!=null && !name.isEmpty()) {
			out.append("| name = "+name+"\n");
		} else {
			out.append("| name = \n");
		}
		if (url!=null && !url.isEmpty()) {
			out.append("| url = "+url.toString()+"\n");
		} else {
			out.append("| url = \n");
		}
		if (logo!=null && !logo.isEmpty()) {
			out.append("| logo = [[File:"+logo+"|150px|Logo]]\n");
		} else {
			out.append("| logo = \n");
		}
		if (languages!=null && !languages.isEmpty()) {
			out.append("| language = "+languages.toString()+"\n");
		} else {
			out.append("| language = \n");
		}
		if (registration!=null && !registration.isEmpty()) {
			out.append("| registration = "+registration.toString()+"\n");
		} else {
			out.append("| registration = \n");
		}
		if (launchDate!=null && !launchDate.isEmpty()) {
			out.append("| launch date = "+launchDate.toString()+"\n");
		} else {
			out.append("| launch date = \n");
		}
		if (status!=null && !status.isEmpty()) {
			out.append("| status = "+status.toString()+"\n");
		} else {
			out.append("| status = \n");
		}
		out.append("}}");
		return out.toString();
	}
	
	private String generateContentText() {
		StringBuffer out = new StringBuffer("Please include a short description of '''");
		out.append(name);
		out.append("''', with the relevant information from the list below:\n* overall goal of the system\n* launch date, owner, location\n* evolution over time\n* any trivia / interesting facts about the system\n\n");
		out.append("==Goal==\n\n");
		out.append("==Input (Tasks)==\n\n");
		out.append("==Output (Results)==\n\n");
		out.append("==Participants (Users)==\n\n");
		out.append("==Motivation (Incentives)==\n\n");
		out.append("==Other==\n\n");		
		return out.toString();
	}
	
}
