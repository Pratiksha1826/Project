package Bean;

public class regbean 
{
	private int id;
	private String name , address , contact, email, pwd, gender, city, language;
	public void setName(String name)
	{
		this.name =name;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public void setContact(String contact)
	{
		this.contact=contact;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public void setCity(String city)
	{
		this.city=city;
	}
	public void setGender(String gender)
	{
		this.gender=gender;
	}
	public void setLanguage(String language)
	{
		this.language=language;
	}
	public void  setPassword(String pwd)
	{
		this.pwd = pwd;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public String getPassword()
	{
		return pwd; 
	}
	public int getId()
	{
		return id;
	}
	public String getLanguage()
	{
		return language;
	}
	public String getGender()
	{
		return gender;
	}
	public String getCity()
	{
		return city;
	}
	public String getEmail()
	{
		return email;
	}
	public String getContact()
	{
		return contact;
	}
	
	public String getAddress()
	{
		return address;
		
	}
	public String getName()
	{
		return name;
		
	}
}
