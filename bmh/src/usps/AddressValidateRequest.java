package usps;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import utils.Constants;

@XmlRootElement(name="AddressValidateRequest")
public class AddressValidateRequest {
	private String userId=Constants.USPS_ID;
	private Address address;
	public AddressValidateRequest(){
		
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	@XmlAttribute(name="USERID")
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	@XmlElement(name="Address")
	public void setAddress(Address address) {
		this.address = address;
	}
	public String toXML() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(AddressValidateRequest.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			StringWriter sw = new StringWriter();
			jaxbMarshaller.marshal(this, sw);
			String xmlString = sw.toString();
			return xmlString;
		} catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	public String toFormatedXML() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(AddressValidateRequest.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			StringWriter sw = new StringWriter();
			jaxbMarshaller.marshal(this, sw);
			String xmlString = sw.toString();
			return xmlString;
		} catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
}
