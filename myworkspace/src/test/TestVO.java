package test;

public class TestVO implements Comparable
{
	private String locationName;
	private String address;
	private Long telephoneNumber;
	private String telephoneValue;
	private String tnType;
	private String tnCategory;
	
	public int compareTo(Object o)
	{
		TestVO testVO = (TestVO)o;
		return telephoneValue.compareTo(testVO.getTelephoneValue());
	}

	public TestVO(String locationName, String address, String telephoneValue, String tnType, String tnCategory) {
		super();
		this.locationName = locationName;
		this.address = address;
		this.telephoneValue = telephoneValue;
		this.tnType = tnType;
		this.tnCategory = tnCategory;
	}
	public String toString() {
		return (locationName + "~" +
				address + "~" +
				((telephoneNumber == null)? "" : telephoneNumber.toString()) + "~" +
				telephoneValue + "~" +
				tnType + "~" +
				tnCategory);
	}
	public TestVO(String locationName, String address, Long telephoneNumber, String tnType, String tnCategory) {
		super();
		this.locationName = locationName;
		this.address = address;
		this.telephoneNumber = telephoneNumber;
		this.tnType = tnType;
		this.tnCategory = tnCategory;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public Long getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(Long telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public String getTelephoneValue() {
		return telephoneValue;
	}
	public void setTelephoneValue(String telephoneValue) {
		this.telephoneValue = telephoneValue;
	}
	public String getTnCategory() {
		return tnCategory;
	}
	public void setTnCategory(String tnCategory) {
		this.tnCategory = tnCategory;
	}
	public String getTnType() {
		return tnType;
	}
	public void setTnType(String tnType) {
		this.tnType = tnType;
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return ((TestVO)arg0).getTelephoneNumber().equals(this.getTelephoneNumber());
	}

	
	
	
	
}